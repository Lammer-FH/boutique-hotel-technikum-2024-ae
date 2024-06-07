package com.example.boutiquehoteltechnikum.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
public class RoomDto {

    @JsonProperty("roomId")
    private int roomId;

    @JsonProperty("characteristics")
    private List<CharacteristicDto> characteristics;

    @JsonProperty("images")
    private List<RoomImageDto> images;

    @JsonProperty("name")
    @Size(max = 50, message = "Der Name darf nicht länger als 50 Zeichen sein!")
    private String name;

    @JsonProperty("description")
    @Size(max = 500, message = "Die beschreibung darf nicht länger als 500 Zeichen sein!")
    private String description;
}
