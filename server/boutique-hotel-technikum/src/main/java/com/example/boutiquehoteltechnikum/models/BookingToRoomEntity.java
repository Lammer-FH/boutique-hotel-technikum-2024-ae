package com.example.boutiquehoteltechnikum.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BookingToRooms")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingToRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bookingId", nullable = false)
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private RoomEntity room;
}
