package com.example.finalexam.frontend.controller;

import com.example.finalexam.backend.service.UserService;
import com.example.finalexam.frontend.form.UserRegisterForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false, defaultValue = "false") Boolean error){
        model.addAttribute("error", error);
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterForm userRegisterForm,
                        BindingResult validationResult, RedirectAttributes attributes){

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        String user = userService.createUser(userRegisterForm);
        if (user == null){
            return "redirect:/login";
        }
        else {
            attributes.addFlashAttribute("error", user);
            return "redirect:/register";
        }

    }
}
