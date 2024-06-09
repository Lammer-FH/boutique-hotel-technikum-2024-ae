package com.example.boutiquehoteltechnikum.functional;

import com.example.boutiquehoteltechnikum.dtos.CharacteristicDto;
import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.dtos.RoomImageDto;
import com.example.boutiquehoteltechnikum.models.CharacteristicEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.models.RoomImageEntity;
import com.example.boutiquehoteltechnikum.objects.RoomResponseObject;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@SpringBootTest
public class RoomControllerIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private RoomRepository roomRepository;

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
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void givenLimitAndOffset_whenGetRoom_thenReturnPageOfRooms() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(5, 0, 150, roomDtos);

        Pageable pageable= PageRequest.of(0, 5);
        Page<RoomEntity> mockedResult = new PageImpl<>(roomEntities, pageable,150);

        given(roomRepository.findAll(pageable)).willReturn(mockedResult);

        String result = this.mockMvc.perform(get("/api/v1/rooms")
                .param("limit", "5")
                .param("offset", "0"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }

    @Test
    void givenNoRooms_whenGetRoom_thenReturnEmptyPage() throws Exception {
        RoomResponseObject mockedRoomResponseObject = new RoomResponseObject(5, 0, 0, new ArrayList<>());

        Pageable pageable= PageRequest.of(0, 5);
        Page<RoomEntity> mockedResult = new PageImpl<>(new ArrayList<>(), pageable,0);

        given(roomRepository.findAll(pageable)).willReturn(mockedResult);

        String result = this.mockMvc.perform(get("/api/v1/rooms")
                        .param("limit", "5")
                        .param("offset", "0"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(mockedRoomResponseObject));
    }


}
