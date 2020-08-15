package com.example.finalexam.backend.repository;

import com.example.finalexam.backend.model.Place;
import com.example.finalexam.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findAllByPlaceOrderByDateAsc(Place place);
}
