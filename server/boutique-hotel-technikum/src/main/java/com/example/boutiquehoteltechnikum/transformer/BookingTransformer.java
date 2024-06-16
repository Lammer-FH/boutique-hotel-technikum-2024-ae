package com.example.boutiquehoteltechnikum.transformer;

import com.example.boutiquehoteltechnikum.dtos.*;
import com.example.boutiquehoteltechnikum.models.*;
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
            .rooms(bookingEntity.getRooms().stream()
                .map(this::toDto)
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

    private RoomDto toDto(RoomEntity roomEntity) {
        return RoomDto.builder()
            .roomId(roomEntity.getRoomId())
            .name(roomEntity.getName())
            .description(roomEntity.getDescription())
            .characteristics(roomEntity.getCharacteristics() == null ? null : roomEntity.getCharacteristics().stream().map(this::toDto).toList())
            .images(roomEntity.getImages() == null ? null : roomEntity.getImages().stream().map(this::toDto).toList())
            .build();
    }

    private RoomImageDto toDto(RoomImageEntity roomImageEntity) {
        return RoomImageDto.builder()
            .roomImageId(roomImageEntity.getRoomImageId())
            .filename(roomImageEntity.getFilename())
            .isAnchor(roomImageEntity.isAnchor())
            .build();
    }

    private CharacteristicDto toDto(CharacteristicEntity characteristicEntity) {
        return CharacteristicDto.builder()
            .name(characteristicEntity.getName())
            .characteristicId(characteristicEntity.getCharacteristicId())
            .icon(characteristicEntity.getIcon())
            .build();
    }
}
