package com.dw.driverapp.service;

import com.dw.driverapp.model.Type;
import com.dw.driverapp.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    TypeRepository typeRepository;

    public Type typeAdd(Type newType) {
        if (newType == null || newType.getName() == null || newType.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("타입 이름은 필수입니다.");
        }
        Type savedType = typeRepository.save(newType);
        return savedType;
    }
}

