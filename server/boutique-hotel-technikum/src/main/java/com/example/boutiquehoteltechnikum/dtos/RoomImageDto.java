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

    @JsonProperty("filename")
    @NotBlank(message = "Der Dateiname darf nicht leer sein!")
    @Size(max = 500, message = "Der Dateiname darf nicht länger als 500 Zeichen sein!")
    private String filename;

    @JsonProperty("isAnchor")
    @NotBlank(message = "Es muss angegeben werden ob dieses Bild das Hauptbild ist!")
    private boolean isAnchor;
}
