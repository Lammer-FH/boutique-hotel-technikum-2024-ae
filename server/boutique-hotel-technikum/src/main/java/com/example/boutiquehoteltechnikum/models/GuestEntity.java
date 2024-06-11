package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Guests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
}
