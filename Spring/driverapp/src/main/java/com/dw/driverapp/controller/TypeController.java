package com.dw.driverapp.controller;

import com.dw.driverapp.exception.UnauthorizedUserException;
import com.dw.driverapp.model.Type;
import com.dw.driverapp.repository.TypeRepository;
import com.dw.driverapp.service.TypeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
@RequestMapping("/api")
public class TypeController {
    @Autowired
    TypeService typeService;

    @PostMapping("/admin/add/car/type")
    public ResponseEntity<String> typeAdd(@RequestBody Type newType, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            throw new UnauthorizedUserException("로그인한 사용자만 타입을 추가할 수 있습니다.");
        }
        String role = (String) session.getAttribute("role");
        if (!"ADMIN".equals(role) && !"INSTRUCTOR".equals(role)) {
            throw new UnauthorizedUserException("관리자 또는 강사만 타입을 추가할 수 있습니다.");
        }
        if (newType == null || newType.getName() == null || newType.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("타입의 이름을 제공해야 합니다.");
        }
        typeService.typeAdd(newType);
        return new ResponseEntity<>("타입 추가가 완료되었습니다.", HttpStatus.CREATED);
    }

}