package com.example.finalexam.backend.service;

import com.example.finalexam.backend.DTO.ReviewDTO;
import com.example.finalexam.backend.model.Place;
import com.example.finalexam.backend.model.Review;
import com.example.finalexam.backend.repository.PlaceRepo;
import com.example.finalexam.backend.repository.ReviewRepo;
import com.example.finalexam.backend.repository.UserRepo;
import com.example.finalexam.frontend.form.ReviewForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ReviewService {

    private final PlaceRepo placeRepo;
    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;

    private static int calculatePercent(int votes, int totalVotes) {
        if (totalVotes == 0) {
            return 0;
        }

        if (votes == 0) {
            return 0;
        }

        return (totalVotes / votes);
    }

    public void deleteById(Long id){
        reviewRepo.deleteById(id);
    }

    public List<Review> getAllByPlaceId(Long id){
        return reviewRepo.findAllByPlaceOrderByDateAsc(placeRepo.findById(id).get());
    }
    public int stars(Long id){
        List<Review> reviews = reviewRepo.findAllByPlaceOrderByDateAsc(placeRepo.findById(id).get());

        var total = StreamSupport.stream(reviews.stream().spliterator(), false)
                .mapToInt(Review::getStars)
                .sum();

        return calculatePercent(reviews.size(), total);

    }

    public void createReview(ReviewForm reviewForm, Principal principal) throws IOException {
        File photoFile = new File("src/main/resources/static/images/"+reviewForm.getImage().getOriginalFilename());
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(reviewForm.getImage().getBytes());
        os.close();

        Date date = new Date();
        Review review = Review.builder()
                .comment(reviewForm.getComment())
                .place(placeRepo.findById(Long.parseLong(reviewForm.getPlaceId())).get())
                .user(userRepo.findByLogin(principal.getName()).get())
                .image(photoFile.getName())
                .date(date)
                .stars(Integer.parseInt(reviewForm.getStars()))
                .build();
        reviewRepo.save(review);
    }

}
