package com.dw.driverapp.controller;

import com.dw.driverapp.dto.EnrollmentDTO;
import com.dw.driverapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    // 유저- 유저네임으로 수강 신청을 조회
    @GetMapping("/enrollment/{username}")
    public ResponseEntity<List<EnrollmentDTO>> enrollmentFindUsername(@PathVariable String username){
        return new  ResponseEntity<>(enrollmentService.enrollmentFindUsername(username), HttpStatus.OK);
    }
    
}
