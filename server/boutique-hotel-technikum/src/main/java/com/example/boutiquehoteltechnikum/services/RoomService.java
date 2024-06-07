package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomService {

    @Autowired private RoomRepository roomRepository;

    public Page<RoomEntity> getRooms(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset / limit, limit);
        return roomRepository.findAll(pageable);
    }

    public RoomEntity getRoom(int id) {
        if (roomRepository.findById(id).isPresent()) {
            return roomRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Room with id %d not found", id));
        }
    }

    // DEMO: just to demonstrate validation and body params
//    public void saveRoom(RoomEntity roomEntity) {
//        roomRepository.save(roomEntity);
//    }
}
