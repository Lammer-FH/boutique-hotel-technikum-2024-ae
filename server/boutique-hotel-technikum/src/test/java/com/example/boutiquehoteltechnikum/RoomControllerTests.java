package com.example.boutiquehoteltechnikum;

import com.example.boutiquehoteltechnikum.controllers.RoomController;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.services.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RoomControllerTests {

//    @Mock
//    private RoomService roomService;
//
//    @InjectMocks
//    private RoomController roomController;
//
//    private MockMvc mockMvc;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void whenGetRooms_thenReturnListOfRooms() throws Exception {
//        List<RoomEntity> mockedRooms = new ArrayList<>();
//        mockedRooms.add(RoomEntity.builder().roomId(25).name("Raum Eins").description("Beschreibung von Raum Eins.").build());
//        mockedRooms.add(RoomEntity.builder().roomId(46).name("Raum Zwei").description("Beschreibung von Raum Zwei.").build());
//
//        when(roomService.getRooms(5, 0)).thenReturn(mockedRooms);
//
//        String result = this.mockMvc.perform(get("/api/v1/rooms"))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRooms));
//    }
//
//    @Test
//    void whenGetRoom_thenReturnRoom() throws Exception {
//        RoomEntity mockedRoom = RoomEntity.builder().roomId(25).name("Raum Eins").description("Beschreibung von Raum Eins.").build();
//
//        when(roomService.getRoom(25)).thenReturn(mockedRoom);
//
//        String result = this.mockMvc.perform(get("/api/v1/rooms/25"))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoom));
//    }
}
