package com.example.finalexam.backend.DTO;

import com.example.finalexam.backend.model.Place;
import com.example.finalexam.backend.model.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceDTO {

    private Long id;
    private String name;
    private String description;
    private String photo;

    public static PlaceDTO from(Place place){
        return builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .photo(place.getPhoto())
                .build();
    }
}