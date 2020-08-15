package com.example.finalexam.backend.service;

import com.example.finalexam.backend.DTO.PlaceDTO;
import com.example.finalexam.backend.model.Place;
import com.example.finalexam.backend.repository.PlaceRepo;
import com.example.finalexam.frontend.form.PlaceForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepo placeRepo;

    public List<PlaceDTO> getAll(){
        return placeRepo.findAll().stream().map(PlaceDTO::from).collect(Collectors.toList());
    }

    public void createPlace(PlaceForm placeForm) throws IOException {
        File photoFile = new File("src/main/resources/static/images/"+placeForm.getPhoto().getOriginalFilename());
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(placeForm.getPhoto().getBytes());
        os.close();

        Place place = Place.builder()
                .name(placeForm.getName())
                .description(placeForm.getDescription())
                .photo(photoFile.getName())
                .build();
        placeRepo.save(place);
    }
}
