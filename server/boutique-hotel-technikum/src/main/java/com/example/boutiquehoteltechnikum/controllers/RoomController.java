package com.example.boutiquehoteltechnikum.controllers;

import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.objects.RoomResponseObject;
import com.example.boutiquehoteltechnikum.services.RoomService;
import com.example.boutiquehoteltechnikum.transformer.RoomTransformer;
import com.example.boutiquehoteltechnikum.utils.DateValidator;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
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
        DateValidator.validateDates(startDate, endDate);

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
    public RoomDto getRoomById(
        @PathVariable("id") int id,
        @PathParam(value = "startDate") String startDate,
        @PathParam(value = "endDate") String endDate
    ) {
        DateValidator.validateDates(startDate, endDate);

        RoomEntity roomEntity = roomService.getRoomById(
            id,
            startDate == null ? null : Date.valueOf(startDate),
            endDate == null ? null : Date.valueOf(endDate)
        );
        if (roomEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found or unavailable for the specified dates");
        }
        return roomTransformer.toDto(roomEntity);
    }
}
