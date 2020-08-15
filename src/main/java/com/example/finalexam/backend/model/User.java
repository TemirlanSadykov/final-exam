package com.example.finalexam.backend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Обязательное поле")
    @Column(length = 64)
    private String login;

    @NotBlank(message = "Обязательное поле")
    @Email(message = "Такого email нет")
    @Column(length = 64)
    private String email;

    @NotBlank(message = "Обязательное поле")
    @Size(min = 8, message = "Пароль должен содержать минимум 8 символов")
    @Column(length = 64)
    private String password;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @Column
    @Builder.Default
    private String role = "USER";

}
