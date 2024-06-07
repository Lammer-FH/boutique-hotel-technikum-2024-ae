package com.example.boutiquehoteltechnikum;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import com.example.boutiquehoteltechnikum.services.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTests {

//    @Mock
//    private RoomRepository roomRepository;
//
//    @InjectMocks
//    private RoomService roomService;
//
//    @Test
//    void whenGetRooms_thenReturnListOfRooms() {
//        List<RoomEntity> mockedRooms = new ArrayList<>();
//        mockedRooms.add(RoomEntity.builder().roomId(25).name("Raum Eins").description("Beschreibung von Raum Eins.").build());
//        mockedRooms.add(RoomEntity.builder().roomId(46).name("Raum Zwei").description("Beschreibung von Raum Zwei.").build());
//
//        given(roomRepository.findAll()).willReturn(mockedRooms);
//
//        List<RoomEntity> result = roomService.getRooms(5, 0);
//
//        assertEquals(mockedRooms, result);
//    }
//
//    @Test
//    void whenGetRoom_thenReturnRoom() {
//        RoomEntity mockedRoom = RoomEntity.builder().roomId(25).name("Raum Eins").description("Beschreibung von Raum Eins.").build();
//
//        given(roomRepository.findById(25)).willReturn(Optional.ofNullable(mockedRoom));
//
//        RoomEntity result = roomService.getRoom(25);
//
//        assertEquals(mockedRoom, result);
//    }
//
//    @Test
//    void whenGetRoomWithInvalidId_thenReturnError() {
//        given(roomRepository.findById(105)).willReturn(Optional.ofNullable(null));
//
//        Exception exception = assertThrows(ResponseStatusException.class, () -> roomService.getRoom(105));
//        assertTrue(exception.getMessage().contains("Room with id 105 not found"));
//    }
}
