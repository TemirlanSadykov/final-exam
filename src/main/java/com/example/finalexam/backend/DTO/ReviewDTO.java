package com.example.finalexam.backend.DTO;

import com.example.finalexam.backend.model.Review;
import com.example.finalexam.backend.model.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDTO {

    private Long id;
    private String comment;
    private String image;
    private int stars;
    private PlaceDTO placeDTO;

    public static ReviewDTO from(Review review){
        return builder()
                .id(review.getId())
                .comment(review.getComment())
                .image(review.getImage())
                .stars(review.getStars())
                .placeDTO(PlaceDTO.from(review.getPlace()))
                .build();
    }
}