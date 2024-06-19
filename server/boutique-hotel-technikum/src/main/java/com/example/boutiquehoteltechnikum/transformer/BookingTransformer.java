package com.example.boutiquehoteltechnikum.transformer;

import com.example.boutiquehoteltechnikum.dtos.*;
import com.example.boutiquehoteltechnikum.models.*;
import com.example.boutiquehoteltechnikum.objects.BookingResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookingTransformer implements ITransformer<BookingEntity, BookingResponseObject> {

    @Autowired
    private RoomTransformer roomTransformer;

    @Override
    public BookingResponseObject toDto(BookingEntity bookingEntity) {
        return BookingResponseObject.builder()
            .bookingId(bookingEntity.getBookingId())
            .bookingNumber(bookingEntity.getBookingNumber())
            .startDate(bookingEntity.getStartDate())
            .endDate(bookingEntity.getEndDate())
            .breakfast(bookingEntity.isBreakfast())
            .guests(bookingEntity.getGuests().stream()
                .map(this::toDto)
                .collect(Collectors.toList()))
            .rooms(bookingEntity.getRooms().stream()
                .map(roomTransformer::toDto)
                .toList())
            .build();
    }

    private GuestDto toDto(GuestEntity guestEntity) {
        return GuestDto.builder()
            .guestId(guestEntity.getGuestId())
            .firstName(guestEntity.getFirstName())
            .lastName(guestEntity.getLastName())
            .email(guestEntity.getEmail())
            .build();
    }
}
