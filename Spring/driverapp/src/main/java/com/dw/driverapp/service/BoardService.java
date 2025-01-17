package com.dw.driverapp.service;

import com.dw.driverapp.dto.BoardAllDTO;
import com.dw.driverapp.dto.BoardDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.Board;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.BoardRepository;
import com.dw.driverapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Locale.filter;


@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    UserRepository userRepository;

    // 유저- 게시판의 모든 글 조회
    public List<BoardAllDTO> getAllBoard() {
        return boardRepository.findAll().stream().map(Board::TODTO).toList();
    }

    // 유저- id로 게시판 조회
    public BoardDTO boardIdfind(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 ID를 가진 Board가 존재하지 않습니다.")).toDTO();
    }

    //유저- 게시판의 제목을 검색해서 조회
    public List<BoardDTO> boardTitleFind(String title) {
        String title1 = "%" + title + "%";
        return boardRepository.findByTitleLike(title1)
                .filter(boards -> !boards.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("해당 제목의 게시글을 찾을 수 없습니다.")).stream()
                .map(Board::toDTO)
                .collect(Collectors.toList());
    }

    // 유저- 사용자가 게시한 게시글 조회
    public List<BoardDTO> boardUsernameFind(String username) {
        return boardRepository.findByAuthor_UserName(username)
                .filter(boards -> !boards.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("입력하신 회원이 존재하지 않습니다."))
                .stream()
                .map(Board::toDTO)
                .collect(Collectors.toList());
    }

    // 유저 - 로그인 중인 회원의 게시글 작성
    public BoardAllDTO saveBoard(BoardAllDTO boardAllDTO, String username) {
        User author = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Board newBoard = new Board();
        newBoard.setTitle(boardAllDTO.getTitle());
        newBoard.setContent(boardAllDTO.getContent());
        newBoard.setAuthor(author); // 로그인된 사용자로 author 설정
        newBoard.setCreatedDate(LocalDateTime.now());
        newBoard.setModifiedDate(LocalDateTime.now());
        Board savedBoard = boardRepository.save(newBoard);
        return savedBoard.TODTO();
    }

    // 유저- 로그인 중인 회원의 게시글 삭제
    public BoardAllDTO deleteBoard(Long id , String username) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found"));
        if (!board.getAuthor().getUserName().equals(username)) {
            throw new UnauthorizedUserException("본인이 작성한 게시글만 삭제할 수 있습니다.");
        }
        board.setTitle("삭제된 게시글입니다.");
        board.setContent("해당 게시글은 사용자가 의해 삭제되었습니다.");
        board.setModifiedDate(LocalDateTime.now());
        Board updatedBoard = boardRepository.save(board);
        return updatedBoard.TODTO();
    }
}
