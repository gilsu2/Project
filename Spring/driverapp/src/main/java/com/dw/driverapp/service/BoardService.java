package com.dw.driverapp.service;

import com.dw.driverapp.dto.BoardAllDTO;
import com.dw.driverapp.dto.BoardDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.Board;
import com.dw.driverapp.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    // 유저- 게시판의 모든 글 조회
    public List<BoardAllDTO> getAllBoard() {
        return boardRepository.findAll().stream().map(Board::TODTO).toList();
    }

    // 유저- id로 게시판 조회
    public BoardDTO boardIdfind(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 ID를 가진 Board가 존재하지 않습니다."));
        return board.toDTO();
    }

}
