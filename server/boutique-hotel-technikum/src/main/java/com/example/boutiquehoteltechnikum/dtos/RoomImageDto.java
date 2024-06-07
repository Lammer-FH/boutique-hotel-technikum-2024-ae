package com.example.boutiquehoteltechnikum.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class RoomImageDto {

    @JsonProperty("roomImageId")
    private int roomImageId;

    @JsonProperty("imagePath")
    @NotBlank(message = "Der Pfad darf nicht leer sein!")
    @Size(max = 500, message = "Der Pfad darf nicht länger als 500 Zeichen sein!")
    private String imagePath;
}
