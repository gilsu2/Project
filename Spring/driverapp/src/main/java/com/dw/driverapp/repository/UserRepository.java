package com.dw.driverapp.repository;

import com.dw.driverapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
    Optional<List<User>> findByBirthdate(LocalDate birthdate);
    Optional<List<User>> findByRealName (String realName);
}
