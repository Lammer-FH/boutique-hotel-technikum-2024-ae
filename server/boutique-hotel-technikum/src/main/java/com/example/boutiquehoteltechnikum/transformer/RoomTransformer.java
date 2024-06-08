package com.example.boutiquehoteltechnikum.transformer;

import com.example.boutiquehoteltechnikum.dtos.CharacteristicDto;
import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.dtos.RoomImageDto;
import com.example.boutiquehoteltechnikum.models.CharacteristicEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.models.RoomImageEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTransformer implements ITransformer<RoomEntity, RoomDto> {

    public RoomDto toDto(RoomEntity roomEntity) {
        List<CharacteristicDto> characteristicDtos = new ArrayList<>();
        for (CharacteristicEntity characteristicEntity : roomEntity.getCharacteristics()) {
            characteristicDtos.add(CharacteristicDto.builder()
                    .characteristicId(characteristicEntity.getCharacteristicId())
                    .name(characteristicEntity.getName())
                    .icon(characteristicEntity.getIcon())
                    .build());
        }
        List<RoomImageDto> roomImageDtos = new ArrayList<>();
        for (RoomImageEntity roomImageEntity : roomEntity.getImages()) {
            roomImageDtos.add(RoomImageDto.builder()
                    .roomImageId(roomImageEntity.getRoomImageId())
                    .filename(roomImageEntity.getFilename())
                    .isAnchor(roomImageEntity.isAnchor())
                    .build());
        }
        return  RoomDto.builder()
            .roomId(roomEntity.getRoomId())
            .characteristics(characteristicDtos)
            .images(roomImageDtos)
            .name(roomEntity.getName())
            .description(roomEntity.getDescription())
            .build();
    }
}
