package com.example.finalexam.frontend.controller;


import com.example.finalexam.backend.service.PlaceService;
import com.example.finalexam.backend.service.UserService;
import com.example.finalexam.frontend.form.PlaceForm;
import com.example.finalexam.frontend.form.UserRegisterForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class PlaceController {

    private final UserService userService;
    private final PlaceService placeService;

    @GetMapping("/")
    public String places(Model model, Principal principal){
        model.addAttribute("places", placeService.getAll());
        model.addAttribute("userName", userService.checkUser(principal));
        return "places";

    }

    @GetMapping("/place/new")
    public String place(Model model, Principal principal){
        model.addAttribute("userName", principal.getName());
        return "place";
    }

    @PostMapping("/place/new")
    public String place(@Valid PlaceForm placeForm,
                        BindingResult validationResult, RedirectAttributes attributes) throws IOException {
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/place/new";
        }
        placeService.createPlace(placeForm);
        return "redirect:/";
    }
}
