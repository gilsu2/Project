package com.dw.driverapp.service;

import com.dw.driverapp.dto.UserDTO;
import com.dw.driverapp.exception.InvalidRequestException;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.AuthorityRepository;
import com.dw.driverapp.repository.SubjectRepository;
import com.dw.driverapp.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    AuthorityRepository authorityRepository;


    // 유저- 회원가입
    public UserDTO registerUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userDTO.getUserName());
        if (user.isPresent()) {
            throw new InvalidRequestException("입력하신 정보가 이미 존재합니다.");
        }
        return userRepository.save(
                new User(
                        userDTO.getUserName(),
                        passwordEncoder.encode(userDTO.getPassword()),
                        userDTO.getEmail(),
                        userDTO.getRealName(),
                        userDTO.getBirthdate(),
                        authorityRepository.findById("User")
                                .orElseThrow(() -> new ResourceNotFoundException("NO ROLE")),
                        LocalDateTime.now(),
                        10000)
        ).toDTO();
    }

    // 관리자 - 모든 회원정보 조회
    public List<User> getAllUser() {
        return userRepository.findAll(); // 회원정보 조회
    }

    // 유저 - 로그인, 로그아웃
    public boolean validateUser(String username, String password) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new InvalidRequestException("사용자의 이름이 잘못되었습니다."));
        return passwordEncoder.matches(password, user.getPassword());
    }

    public User usernameFind(String username) {
        return userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("입력하신 회원이 존재하지 않습니다."));
    }

    public User userEmailFind(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("입력하신 email의 정보를 가진 회원이 존재하지 않습니다."));
    }

    public List<User> userBirthdateFind(LocalDate birthdate) {
        return userRepository.findByBirthdate(birthdate)
                .filter(users -> !users.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("입력하신 생일의 정보를 가진 회원이 존재하지 않습니다."));

    }

    public List<User>realNameFind(String realname){
        return userRepository.findByRealName(realname)
                .filter(users -> !users.isEmpty())
                .orElseThrow(()-> new ResourceNotFoundException("입력하신 이름의 realname의 정보를 가진 회원이 존재하지 않습니다."));
    }
}