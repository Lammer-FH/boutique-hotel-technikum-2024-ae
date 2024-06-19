package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
    @Size(max = 50, message = "Der Vorname darf nicht länger als 50 Zeichen sein!")
    private String firstName;

    @Column(nullable = false)
    @Size(max = 50, message = "Der Nachname darf nicht länger als 50 Zeichen sein!")
    private String lastName;

    @Column(nullable = false)
    @Email(message = "Die Email muss gültig sein!")
    @Size(max = 50, message = "Die Email darf nicht länger als 50 Zeichen sein!")
    private String email;
}
