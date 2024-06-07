package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Characteristics")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacteristicEntity {

    @Id
    @GeneratedValue
    private int characteristicId;

    @NotBlank(message = "Der Name darf nicht leer sein!")
    @Size(max = 50, message = "Der Name darf nicht länger als 50 Zeichen sein!")
    private String name;
}
