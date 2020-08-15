package com.example.finalexam.backend.DTO;

import com.example.finalexam.backend.model.Review;
import com.example.finalexam.backend.model.User;
import lombok.*;

import java.util.Date;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDTO {

    private Long id;
    private String comment;
    private String image;
    private int stars;
    private Date date;
    private PlaceDTO placeDTO;
    private UserDTO userDTO;

    public static ReviewDTO from(Review review){
        return builder()
                .id(review.getId())
                .comment(review.getComment())
                .image(review.getImage())
                .stars(review.getStars())
                .date(review.getDate())
                .placeDTO(PlaceDTO.from(review.getPlace()))
                .userDTO(UserDTO.from(review.getUser()))
                .build();
    }
}