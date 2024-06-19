package com.example.boutiquehoteltechnikum.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class GuestDto {

    @JsonProperty("guestId")
    private int guestId;

    @JsonProperty("firstName")
    @Size(max = 50, message = "Der Vorname darf nicht länger als 50 Zeichen sein!")
    private String firstName;

    @JsonProperty("lastName")
    @Size(max = 50, message = "Der Nachname darf nicht länger als 50 Zeichen sein!")
    private String lastName;

    @JsonProperty("email")
    @Email(message = "Die Email muss gültig sein!")
    @Size(max = 50, message = "Die Email darf nicht länger als 50 Zeichen sein!")
    private String email;
}
