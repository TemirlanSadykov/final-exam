package com.example.finalexam.frontend.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReviewForm {
    @NotBlank(message = "Обязательное поле")
    private String comment;

    @NotBlank(message = "Обязательное поле")
    private String stars;

    @NotNull(message = "Обязательное поле")
    private MultipartFile image;

    private String placeId;
}
