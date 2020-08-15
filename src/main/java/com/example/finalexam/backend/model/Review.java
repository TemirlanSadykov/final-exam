package com.example.finalexam.backend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Обязательное поле")
    private String comment;

    private int stars;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private Date date;

    private String image;

    @ManyToOne @JoinColumn(name = "place_id")
    private Place place;
}
