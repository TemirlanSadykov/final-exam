package com.example.finalexam.backend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "galleries")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Обязательное поле")
    private String comment;

    private int stars;

    @NotBlank(message = "Обязательное поле")
    private String image;

    @ManyToOne @JoinColumn(name = "place_id")
    private Place place;
}
