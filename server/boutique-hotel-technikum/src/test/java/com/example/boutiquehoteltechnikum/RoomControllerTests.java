package com.example.boutiquehoteltechnikum;

import com.example.boutiquehoteltechnikum.controllers.RoomController;
import com.example.boutiquehoteltechnikum.dtos.CharacteristicDto;
import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.dtos.RoomImageDto;
import com.example.boutiquehoteltechnikum.models.CharacteristicEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.models.RoomImageEntity;
import com.example.boutiquehoteltechnikum.objects.RoomResponseObject;
import com.example.boutiquehoteltechnikum.services.RoomService;
import com.example.boutiquehoteltechnikum.transformer.RoomTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RoomControllerTests {

    @Mock
    private RoomService roomService;

    @Mock
    private RoomTransformer roomTransformer;

    @InjectMocks
    private RoomController roomController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    private List<CharacteristicEntity> characteristicEntities = Arrays.asList(
        CharacteristicEntity.builder().characteristicId(1).name("Extra 1").icon("Icon 1").build(),
        CharacteristicEntity.builder().characteristicId(2).name("Extra 2").icon("Icon 2").build()
    );

    private List<RoomImageEntity> imageEntities = Arrays.asList(
        RoomImageEntity.builder().roomImageId(1).filename("Extra 1").isAnchor(true).build(),
        RoomImageEntity.builder().roomImageId(2).filename("Extra 2").isAnchor(false).build()
    );

    private List<RoomEntity> mockedRoomEntities = Arrays.asList(
        RoomEntity.builder().roomId(1).name("Raum Eins").description("Beschreibung von Raum Eins.")
                .images(imageEntities).characteristics(characteristicEntities).build(),
        RoomEntity.builder().roomId(2).name("Raum Zwei").description("Beschreibung von Raum Zwei.")
                .images(imageEntities).characteristics(characteristicEntities).build(),
        RoomEntity.builder().roomId(3).name("Raum Drei").description("Beschreibung von Raum Drei.")
                .images(imageEntities).characteristics(characteristicEntities).build(),
        RoomEntity.builder().roomId(4).name("Raum Vier").description("Beschreibung von Raum Vier.")
                .images(imageEntities).characteristics(characteristicEntities).build(),
        RoomEntity.builder().roomId(5).name("Raum Fuenf").description("Beschreibung von Raum Fuenf.")
                .images(imageEntities).characteristics(characteristicEntities).build()
    );

    private List<CharacteristicDto> characteristicDtos = Arrays.asList(
        CharacteristicDto.builder().characteristicId(1).name("Extra 1").icon("Icon 1").build(),
        CharacteristicDto.builder().characteristicId(1).name("Extra 1").icon("Icon 1").build()
    );

    private List<RoomImageDto> imageDtos = Arrays.asList(
            RoomImageDto.builder().roomImageId(1).filename("Extra 1").isAnchor(true).build(),
            RoomImageDto.builder().roomImageId(2).filename("Extra 2").isAnchor(false).build()
    );

    private List<RoomDto> mockedRoomDtos = Arrays.asList(
        RoomDto.builder().roomId(1).name("Raum Eins").description("Beschreibung von Raum Eins.")
                .images(imageDtos).characteristics(characteristicDtos).build(),
        RoomDto.builder().roomId(2).name("Raum Zwei").description("Beschreibung von Raum Zwei.")
                .images(imageDtos).characteristics(characteristicDtos).build(),
        RoomDto.builder().roomId(3).name("Raum Drei").description("Beschreibung von Raum Drei.")
                .images(imageDtos).characteristics(characteristicDtos).build(),
        RoomDto.builder().roomId(4).name("Raum Vier").description("Beschreibung von Raum Vier.")
                .images(imageDtos).characteristics(characteristicDtos).build(),
        RoomDto.builder().roomId(5).name("Raum Fuenf").description("Beschreibung von Raum Fuenf.")
                .images(imageDtos).characteristics(characteristicDtos).build()
    );

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void whenGetRooms_thenReturnPageOfRooms() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(5, 0, 150, mockedRoomDtos);

        Pageable pageable= PageRequest.of(0, 5);
        Page<RoomEntity> mockedResult = new PageImpl<>(mockedRoomEntities, pageable,150);

        when(roomService.getRooms(5, 0)).thenReturn(mockedResult);
        when(roomTransformer.toDto(mockedRoomEntities.get(0))).thenReturn(mockedRoomDtos.get(0));
        when(roomTransformer.toDto(mockedRoomEntities.get(1))).thenReturn(mockedRoomDtos.get(1));
        when(roomTransformer.toDto(mockedRoomEntities.get(2))).thenReturn(mockedRoomDtos.get(2));
        when(roomTransformer.toDto(mockedRoomEntities.get(3))).thenReturn(mockedRoomDtos.get(3));
        when(roomTransformer.toDto(mockedRoomEntities.get(4))).thenReturn(mockedRoomDtos.get(4));

        String result = this.mockMvc.perform(get("/api/v1/rooms?limit=5&offset=0"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }

    @Test
    void whenGetRoomsWithDifferentLimitAndOffset_thenReturnPageOfRooms() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(3, 8, 150, mockedRoomDtos.subList(0, 3));

        Pageable pageable= PageRequest.of(2, 3);
        Page<RoomEntity> mockedResult = new PageImpl<>(mockedRoomEntities.subList(0, 3), pageable,150);

        when(roomService.getRooms(3, 8)).thenReturn(mockedResult);
        when(roomTransformer.toDto(mockedRoomEntities.get(0))).thenReturn(mockedRoomDtos.get(0));
        when(roomTransformer.toDto(mockedRoomEntities.get(1))).thenReturn(mockedRoomDtos.get(1));
        when(roomTransformer.toDto(mockedRoomEntities.get(2))).thenReturn(mockedRoomDtos.get(2));

        String result = this.mockMvc.perform(get("/api/v1/rooms?limit=3&offset=8"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }

    @Test
    void whenGetRoomsWithInvalidLimit_thenReturnCorrectError() throws Exception {
        String result = this.mockMvc.perform(get("/api/v1/rooms?limit=0&offset=10"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getErrorMessage();

        assertThat(result).isEqualTo("Limit (0) cannot be less or equal zero");
    }

    @Test
    void whenGetRoomsWithInvalidOffset_thenReturnCorrectError() throws Exception {
        String result = this.mockMvc.perform(get("/api/v1/rooms?limit=5&offset=-5"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getErrorMessage();

        assertThat(result).isEqualTo("Offset (-5) cannot be less than zero");
    }
}
