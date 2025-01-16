package com.dw.driverapp.controller;

import com.dw.driverapp.model.Notice;
import com.dw.driverapp.model.User;
import com.dw.driverapp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice/all")
    public ResponseEntity<List<Notice>> getAllNotice(){
        return new ResponseEntity<>(noticeService.getAllNotice(),HttpStatus.OK);
    }
}
