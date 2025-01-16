package com.dw.driverapp.service;

import com.dw.driverapp.dto.SubjectDTO;
import com.dw.driverapp.model.Subject;
import com.dw.driverapp.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;


    public List<SubjectDTO> getAllSubject(){
        return subjectRepository.findAll().stream().map(Subject::toDTO) //map()은 값을 변형 시키는 데에 사용 됨
                .collect(Collectors.toList());
    }

}
