package com.example.boutiquehoteltechnikum.transformer;

import com.example.boutiquehoteltechnikum.dtos.BookingDto;
import com.example.boutiquehoteltechnikum.dtos.GuestDto;
import com.example.boutiquehoteltechnikum.models.BookingEntity;
import com.example.boutiquehoteltechnikum.models.GuestEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookingTransformer implements ITransformer<BookingEntity, BookingDto> {

    @Override
    public BookingDto toDto(BookingEntity bookingEntity) {
        return BookingDto.builder()
            .bookingId(bookingEntity.getBookingId())
            .bookingNumber(bookingEntity.getBookingNumber())
            .startDate(bookingEntity.getStartDate())
            .endDate(bookingEntity.getEndDate())
            .breakfast(bookingEntity.isBreakfast())
            .guests(bookingEntity.getGuests().stream()
                .map(this::toDto)
                .collect(Collectors.toList()))
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
