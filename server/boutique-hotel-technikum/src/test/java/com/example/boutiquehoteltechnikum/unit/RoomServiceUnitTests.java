package com.example.boutiquehoteltechnikum.unit;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import com.example.boutiquehoteltechnikum.services.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RoomServiceUnitTests {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    private List<RoomEntity> mockedRoomEntities = Arrays.asList(
            RoomEntity.builder().roomId(1).name("Raum Eins").description("Beschreibung von Raum Eins.").build(),
            RoomEntity.builder().roomId(2).name("Raum Zwei").description("Beschreibung von Raum Zwei.").build(),
            RoomEntity.builder().roomId(3).name("Raum Drei").description("Beschreibung von Raum Drei.").build(),
            RoomEntity.builder().roomId(4).name("Raum Vier").description("Beschreibung von Raum Vier.").build(),
            RoomEntity.builder().roomId(5).name("Raum Fuenf").description("Beschreibung von Raum Fuenf.").build()
    );

    @Test
    void givenLimitAndOffset_whenGetRooms_thenReturnPageOfRooms() {
        Pageable pageable= PageRequest.of(0, 5);
        Page<RoomEntity> mockedResult = new PageImpl<>(mockedRoomEntities, pageable,150);

        given(roomRepository.findAll(pageable)).willReturn(mockedResult);

        Page<RoomEntity> result = roomService.getRooms(5, 0);

        assertEquals(mockedResult, result);
    }

    @Test
    void givenDifferentLimitAndOffset_whenGetRooms_thenReturnPageOfRooms() {
        Pageable pageable= PageRequest.of(2, 3);
        Page<RoomEntity> mockedResult = new PageImpl<>(mockedRoomEntities, pageable,150);

        given(roomRepository.findAll(pageable)).willReturn(mockedResult);

        Page<RoomEntity> result = roomService.getRooms(3, 8);

        assertEquals(mockedResult, result);
    }
}
