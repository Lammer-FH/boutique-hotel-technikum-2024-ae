package com.example.boutiquehoteltechnikum.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class RoomDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    // DEMO: just to demonstrate validation and body params
//    @Size(min = 3, message = "Der Name muss mindestens 3 Zeichen lang sein.")
    private String name;

    @JsonProperty("description")
    private String description;
}
