package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired private RoomRepository roomRepository;

    public Page<RoomEntity> getRooms(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset / limit, limit);
        return roomRepository.findAll(pageable);
    }
}
