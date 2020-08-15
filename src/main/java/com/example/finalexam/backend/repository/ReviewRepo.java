package com.example.finalexam.backend.repository;

import com.example.finalexam.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
