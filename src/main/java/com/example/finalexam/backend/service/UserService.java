package com.example.finalexam.backend.service;

import com.example.finalexam.backend.model.User;
import com.example.finalexam.backend.repository.UserRepo;
import com.example.finalexam.frontend.form.UserRegisterForm;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder encoder;

    public String createUser(UserRegisterForm userRegisterForm){
        if(userRepo.findByLogin(userRegisterForm.getLogin()).isPresent()){
            return "Данный пользователь зарегистрирован";
        }
        else {
            User user = User.builder()
                    .login(userRegisterForm.getLogin())
                    .email(userRegisterForm.getEmail())
                    .password(encoder.encode(userRegisterForm.getPassword()))
                    .build();

            userRepo.save(user);
            return null;
        }
    }
}
