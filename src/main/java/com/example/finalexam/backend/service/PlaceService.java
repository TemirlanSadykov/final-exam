package com.example.finalexam.backend.service;

import com.example.finalexam.backend.DTO.PlaceDTO;
import com.example.finalexam.backend.model.Place;
import com.example.finalexam.backend.repository.PlaceRepo;
import com.example.finalexam.frontend.form.PlaceForm;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepo placeRepo;

    public Page<PlaceDTO> getAll(Pageable pageable){
        return placeRepo.findAll(pageable).map(PlaceDTO::from);
    }

    public PlaceDTO getById(Long id){
        return PlaceDTO.from(placeRepo.findById(id).get());
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
