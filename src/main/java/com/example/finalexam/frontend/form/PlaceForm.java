package com.example.finalexam.frontend.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Getter
@Setter
public class PlaceForm {
    @NotBlank(message = "Обязательное поле")
    private String name;

    @NotBlank(message = "Обязательное поле")
    private String description;

    @NotNull(message = "Обязательное поле")
    private MultipartFile photo;
}
