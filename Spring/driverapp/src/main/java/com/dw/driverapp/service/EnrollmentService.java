package com.dw.driverapp.service;

import com.dw.driverapp.dto.EnrollmentDTO;
import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.Enrollment;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.EnrollmentRepository;
import com.dw.driverapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    UserRepository userRepository;

    public List<EnrollmentDTO> enrollmentFindUsername(String username){
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("존재하지 않는 유저네임입니다."));
        List<Enrollment> enrollments = enrollmentRepository.findByUser_UserName(username);
        if (enrollments.isEmpty()) {
            throw new ResourceNotFoundException("해당 유저는 수강신청을 하지 않았습니다.");
        }
        return enrollments.stream()
                .map(Enrollment::TOdto)
                .collect(Collectors.toList());
    }
}
