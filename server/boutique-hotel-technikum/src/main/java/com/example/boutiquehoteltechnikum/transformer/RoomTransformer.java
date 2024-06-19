package com.example.boutiquehoteltechnikum.transformer;

import com.example.boutiquehoteltechnikum.dtos.CharacteristicDto;
import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.dtos.RoomImageDto;
import com.example.boutiquehoteltechnikum.models.CharacteristicEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.models.RoomImageEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoomTransformer implements ITransformer<RoomEntity, RoomDto> {

    public RoomDto toDto(RoomEntity roomEntity) {
        return  RoomDto.builder()
            .roomId(roomEntity.getRoomId())
            .characteristics(roomEntity.getCharacteristics().stream().map(this::toDto).collect(Collectors.toList()))
            .images(roomEntity.getImages().stream().map(this::toDto).collect(Collectors.toList()))
            .name(roomEntity.getName())
            .description(roomEntity.getDescription())
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
