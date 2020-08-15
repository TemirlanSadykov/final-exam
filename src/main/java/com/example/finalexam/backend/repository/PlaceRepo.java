package com.example.finalexam.backend.repository;

import com.example.finalexam.backend.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place, Long> {
    Page<Place> findAll(Pageable pageable);
}
