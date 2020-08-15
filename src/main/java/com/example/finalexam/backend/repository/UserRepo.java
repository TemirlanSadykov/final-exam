package com.example.finalexam.backend.repository;

import com.example.finalexam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
