package com.dw.driverapp.service;

import com.dw.driverapp.model.Notice;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeRepository noticeRepository;


    public List<Notice> getAllNotice(){
        return noticeRepository.findAll();
    }
}


