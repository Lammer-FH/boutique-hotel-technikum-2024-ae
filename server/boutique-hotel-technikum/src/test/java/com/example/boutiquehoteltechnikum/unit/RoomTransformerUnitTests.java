package com.example.boutiquehoteltechnikum.unit;

import com.example.boutiquehoteltechnikum.dtos.CharacteristicDto;
import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.dtos.RoomImageDto;
import com.example.boutiquehoteltechnikum.models.CharacteristicEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.models.RoomImageEntity;
import com.example.boutiquehoteltechnikum.transformer.RoomTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class RoomTransformerUnitTests {

    @InjectMocks
    private RoomTransformer roomTransformer;

    private List<CharacteristicEntity> characteristicEntities = Arrays.asList(
            CharacteristicEntity.builder().characteristicId(1).name("Extra 1").icon("Icon 1").build(),
            CharacteristicEntity.builder().characteristicId(2).name("Extra 2").icon("Icon 2").build()
    );

    private List<RoomImageEntity> imageEntities = Arrays.asList(
            RoomImageEntity.builder().roomImageId(1).filename("Extra 1").isAnchor(true).build(),
            RoomImageEntity.builder().roomImageId(2).filename("Extra 2").isAnchor(false).build()
    );

    private RoomEntity mockedRoomEntity = RoomEntity.builder().roomId(1).name("Raum Eins").description("Beschreibung von Raum Eins.")
                    .images(imageEntities).characteristics(characteristicEntities).build();

    private List<CharacteristicDto> characteristicDtos = Arrays.asList(
            CharacteristicDto.builder().characteristicId(1).name("Extra 1").icon("Icon 1").build(),
            CharacteristicDto.builder().characteristicId(2).name("Extra 2").icon("Icon 2").build()
    );

    private List<RoomImageDto> imageDtos = Arrays.asList(
            RoomImageDto.builder().roomImageId(1).filename("Extra 1").isAnchor(true).build(),
            RoomImageDto.builder().roomImageId(2).filename("Extra 2").isAnchor(false).build()
    );

    private RoomDto mockedRoomDto = RoomDto.builder().roomId(1).name("Raum Eins").description("Beschreibung von Raum Eins.")
                    .images(imageDtos).characteristics(characteristicDtos).build();

    @Test
    void givenRoomEntity_whenToDto_thenReturnRoomDto() {
        RoomDto result = roomTransformer.toDto(mockedRoomEntity);

        assertThat(mockedRoomDto).isEqualTo(result);
    }
}
