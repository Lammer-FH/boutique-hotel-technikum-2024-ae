package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "RoomImages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomImageEntity {

    @Id
    @GeneratedValue
    private int roomImageId;

    @NotBlank(message = "Der Pfad darf nicht leer sein!")
    @Size(max = 500, message = "Der Pfad darf nicht länger als 500 Zeichen sein!")
    private String imagePath;
}
