package com.dw.driverapp.controller;

import com.dw.driverapp.dto.SubjectDTO;
import com.dw.driverapp.model.Subject;
import com.dw.driverapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import java.lang.invoke.CallSite;
import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/subject/all")
    public ResponseEntity<List<SubjectDTO>>getAllSubject(){
        return new ResponseEntity<>(subjectService.getAllSubject(), HttpStatus.OK);
    }
}
