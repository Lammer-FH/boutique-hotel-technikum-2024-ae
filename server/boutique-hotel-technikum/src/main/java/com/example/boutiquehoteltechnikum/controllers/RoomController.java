package com.example.boutiquehoteltechnikum.controllers;

import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public List<RoomDto> getRooms() {
        List<RoomEntity> roomEntities = roomService.getRooms();
        List<RoomDto> roomDtos = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            roomDtos.add(
                RoomDto.builder()
                    .id(roomEntity.getId())
                    .name(roomEntity.getName())
                    .description(roomEntity.getDescription())
                    .build());
        }
        return roomDtos;
    }

    @GetMapping("/{id}")
    public RoomDto getRoom(@PathVariable int id) {
        RoomEntity roomEntity = roomService.getRoom(id);
        return RoomDto.builder()
                .id(roomEntity.getId())
                .name(roomEntity.getName())
                .description(roomEntity.getDescription())
                .build();
    }

    // DEMO: just to demonstrate validation and body params
//    @PostMapping("/")
//    public void saveRoom(@RequestBody @Valid RoomDto roomDto) {
//        RoomEntity roomEntity = RoomEntity.builder()
//                .name(roomDto.getName())
//                .description(roomDto.getDescription())
//                .build();
//        roomService.saveRoom(roomEntity);
//    }
}
