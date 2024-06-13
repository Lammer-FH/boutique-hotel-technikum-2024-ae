package com.example.boutiquehoteltechnikum.controllers;

import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.objects.RoomResponseObject;
import com.example.boutiquehoteltechnikum.services.RoomService;
import com.example.boutiquehoteltechnikum.transformer.RoomTransformer;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTransformer roomTransformer;

    @GetMapping("")
    public RoomResponseObject getRooms(@RequestParam("limit") int limit, 
                                       @RequestParam("offset") int offset,
                                       @RequestParam(value = "startDate", required = false) String startDate,
                                       @RequestParam(value = "endDate", required = false) String endDate) {
        if (limit <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Limit (%d) cannot be less or equal zero", limit));
        }
        if (offset < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Offset (%d) cannot be less than zero", offset));
        }
        validateDates(startDate, endDate);

        Page<RoomEntity> roomPages = roomService.getRooms(limit, offset, startDate, endDate);
        List<RoomEntity> roomEntities = roomPages.getContent();
        List<RoomDto> roomDtos = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            roomDtos.add(roomTransformer.toDto(roomEntity));
        }
        return RoomResponseObject.builder()
            .limit(limit)
            .offset(offset)
            .total(roomPages.getTotalElements())
            .roomDtos(roomDtos)
            .build();
    }

    @GetMapping("/{id}")
    public RoomDto getRoomById(@PathVariable("id") int id, @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate) {
        RoomEntity roomEntity = roomService.getRoomById(id, startDate, endDate);
        if (roomEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found or unavailable for the specified dates");
        }
        return roomTransformer.toDto(roomEntity);
    }

    private void validateDates(String startDate, String endDate) {
        if (startDate != null && endDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try {
                Date start = dateFormat.parse(startDate);
                Date end = dateFormat.parse(endDate);
                if (end.before(start)) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "End date must be after start date");
                }
            } catch (ParseException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dates must be in the format yyyy-MM-dd");
            }
        }
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
