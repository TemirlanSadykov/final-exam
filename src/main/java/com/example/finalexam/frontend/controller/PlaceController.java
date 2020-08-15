package com.example.finalexam.frontend.controller;


import com.example.finalexam.backend.service.PlaceService;
import com.example.finalexam.backend.service.PropertiesService;
import com.example.finalexam.backend.service.ReviewService;
import com.example.finalexam.backend.service.UserService;
import com.example.finalexam.frontend.form.PlaceForm;
import com.example.finalexam.frontend.form.UserRegisterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class PlaceController {

    private final UserService userService;
    private final PlaceService placeService;
    private final ReviewService reviewService;
    private final PropertiesService propertiesService;

    @GetMapping("/")
    public String places(Model model, Principal principal, Pageable pageable, HttpServletRequest uriBuilder){
        var place = placeService.getAll(pageable);
        var uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(place, propertiesService.getDefaultPageSize(), model, uri);
        model.addAttribute("userName", userService.checkUser(principal));
        return "places";

    }

    @GetMapping("/place/new")
    public String createPlace(Model model, Principal principal){
        model.addAttribute("userName", principal.getName());
        return "place";
    }

    @PostMapping("/place/new")
    public String createPlace(@Valid PlaceForm placeForm,
                        BindingResult validationResult, RedirectAttributes attributes) throws IOException {
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/place/new";
        }
        placeService.createPlace(placeForm);
        return "redirect:/";
    }
    @GetMapping("/place/{id}")
    public String place(Model model, @PathVariable Long id, Principal principal){
        model.addAttribute("userName", principal.getName());
        model.addAttribute("place", placeService.getById(id));
        model.addAttribute("review", reviewService.getAllByPlaceId(id));
        model.addAttribute("stars", reviewService.stars(id));
        return "review";
    }
}
