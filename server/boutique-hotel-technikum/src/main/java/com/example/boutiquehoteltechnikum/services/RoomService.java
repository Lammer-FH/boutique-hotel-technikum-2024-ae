package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomService {

    @Autowired private RoomRepository roomRepository;

    public List<RoomEntity> getRooms() {
        return roomRepository.findAll();
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
