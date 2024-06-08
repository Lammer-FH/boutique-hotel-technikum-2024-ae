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
public class CharacteristicDto {

    @JsonProperty("characteristicId")
    private int characteristicId;

    @JsonProperty("name")
    @NotBlank(message = "Der Name darf nicht leer sein!")
    @Size(max = 50, message = "Der Name darf nicht länger als 50 Zeichen sein!")
    private String name;

    @JsonProperty("icon")
    @NotBlank(message = "Das Icon darf nicht leer sein!")
    @Size(max = 50, message = "Das Icon darf nicht länger als 50 Zeichen sein!")
    private String icon;
}
