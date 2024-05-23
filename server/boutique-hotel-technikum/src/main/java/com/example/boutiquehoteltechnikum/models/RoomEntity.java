package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
    private int id;
    private String name;
    private String description;
}
