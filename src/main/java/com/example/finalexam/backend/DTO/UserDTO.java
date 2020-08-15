package com.example.finalexam.backend.DTO;

import com.example.finalexam.backend.model.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {

    private Long id;
    private String login;
    private String email;
    private String password;

    public static UserDTO from(User user){
        return builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}