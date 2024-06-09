package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Rooms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue
    private int roomId;

    @ManyToMany
    @JoinTable(
            name = "RoomToCharacteristics",
            joinColumns = @JoinColumn(name = "roomId"),
            inverseJoinColumns = @JoinColumn(name = "characteristicId"))
    private List<CharacteristicEntity> characteristics;

    @OneToMany(targetEntity = RoomImageEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", foreignKey=@ForeignKey(name = "FK_Room_RoomImages"))
    private List<RoomImageEntity> images;

    @NotBlank(message = "Der Name darf nicht leer sein!")
    @Size(max = 50, message = "Der Name darf nicht länger als 50 Zeichen sein!")
    private String name;

    @Size(max = 500, message = "Die Beschreibung darf nicht länger als 500 Zeichen sein!")
    private String description;
}
