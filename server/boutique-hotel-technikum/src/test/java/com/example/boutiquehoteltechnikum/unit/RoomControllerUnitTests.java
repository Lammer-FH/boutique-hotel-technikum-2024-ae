package com.example.boutiquehoteltechnikum.unit;

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
public class RoomControllerUnitTests {

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

    private List<RoomEntity> roomEntities = Arrays.asList(
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
        CharacteristicDto.builder().characteristicId(2).name("Extra 2").icon("Icon 2").build()
    );

    private List<RoomImageDto> imageDtos = Arrays.asList(
            RoomImageDto.builder().roomImageId(1).filename("Extra 1").isAnchor(true).build(),
            RoomImageDto.builder().roomImageId(2).filename("Extra 2").isAnchor(false).build()
    );

    private List<RoomDto> roomDtos = Arrays.asList(
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
    void givenLimitAndOffset_whenGetRooms_thenReturnPageOfRooms() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(5, 0, 150, roomDtos);

        Pageable pageable= PageRequest.of(0, 5);
        Page<RoomEntity> mockedResult = new PageImpl<>(roomEntities, pageable,150);

        when(roomService.getRooms(5, 0, null, null)).thenReturn(mockedResult);
        when(roomTransformer.toDto(roomEntities.get(0))).thenReturn(roomDtos.get(0));
        when(roomTransformer.toDto(roomEntities.get(1))).thenReturn(roomDtos.get(1));
        when(roomTransformer.toDto(roomEntities.get(2))).thenReturn(roomDtos.get(2));
        when(roomTransformer.toDto(roomEntities.get(3))).thenReturn(roomDtos.get(3));
        when(roomTransformer.toDto(roomEntities.get(4))).thenReturn(roomDtos.get(4));

        String result = this.mockMvc.perform(get("/api/v1/rooms")
                    .param("limit", "5")
                    .param("offset", "0"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }

    @Test
    void givenDifferentLimitAndOffset_whenGetRooms_thenReturnPageOfRooms() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(3, 8, 150, roomDtos.subList(0, 3));

        Pageable pageable= PageRequest.of(2, 3);
        Page<RoomEntity> mockedResult = new PageImpl<>(roomEntities.subList(0, 3), pageable,150);

        when(roomService.getRooms(3, 8, null, null)).thenReturn(mockedResult);
        when(roomTransformer.toDto(roomEntities.get(0))).thenReturn(roomDtos.get(0));
        when(roomTransformer.toDto(roomEntities.get(1))).thenReturn(roomDtos.get(1));
        when(roomTransformer.toDto(roomEntities.get(2))).thenReturn(roomDtos.get(2));

        String result = this.mockMvc.perform(get("/api/v1/rooms")
                    .param("limit", "3")
                    .param("offset", "8"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }

    @Test
    void givenInvalidLimit_whenGetRooms_thenReturnCorrectError() throws Exception {
        String result = this.mockMvc.perform(get("/api/v1/rooms")
                    .param("limit", "0")
                    .param("offset", "10"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getErrorMessage();

        assertThat(result).isEqualTo("Limit (0) cannot be less or equal zero");
    }

    @Test
    void givenInvalidOffset_whenGetRooms_thenReturnCorrectError() throws Exception {
        String result = this.mockMvc.perform(get("/api/v1/rooms")
                    .param("limit", "5")
                    .param("offset", "-5"))
            .andExpect(status().isBadRequest())
            .andReturn().getResponse().getErrorMessage();

        assertThat(result).isEqualTo("Offset (-5) cannot be less than zero");
    }

    @Test
    void givenStartDateAndEndDate_whenGetRooms_thenReturnListOfAvailableRooms() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(5, 0, 5, roomDtos);

        when(roomService.getRooms(5, 0, "2024-06-01", "2024-06-30")).thenReturn(new PageImpl<>(roomEntities));
        when(roomTransformer.toDto(roomEntities.get(0))).thenReturn(roomDtos.get(0));
        when(roomTransformer.toDto(roomEntities.get(1))).thenReturn(roomDtos.get(1));
        when(roomTransformer.toDto(roomEntities.get(2))).thenReturn(roomDtos.get(2));
        when(roomTransformer.toDto(roomEntities.get(3))).thenReturn(roomDtos.get(3));
        when(roomTransformer.toDto(roomEntities.get(4))).thenReturn(roomDtos.get(4));

        String result = this.mockMvc.perform(get("/api/v1/rooms")
                    .param("limit", "5")
                    .param("offset", "0")
                    .param("startDate", "2024-06-01")
                    .param("endDate", "2024-06-30"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }
}
