package com.example.finalexam.frontend.controller;

import com.example.finalexam.backend.service.ReviewService;
import com.example.finalexam.frontend.form.ReviewForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/place/review")
    public String createReview(@Valid ReviewForm reviewForm, Principal principal,
                               BindingResult validationResult, RedirectAttributes attributes) throws IOException {
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/place/"+reviewForm.getPlaceId();
        }
        reviewService.createReview(reviewForm, principal);
        return "redirect:/";
    }
    @GetMapping("/place/delete/{id}")
    public String createReview(@PathVariable Long id){
        reviewService.deleteById(id);
        return "redirect:/";
    }
}
