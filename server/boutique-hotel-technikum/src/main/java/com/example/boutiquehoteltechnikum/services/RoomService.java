package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired private RoomRepository roomRepository;

    public Page<RoomEntity> getRooms(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset / limit, limit);
        return roomRepository.findAll(pageable);
    }
    public List<RoomEntity> getAvailableRooms(String startDate, String endDate) {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        return roomRepository.findAvailableRooms(start, end);
    }
    public RoomEntity getRoomById(int id, String startDate, String endDate) {
        RoomEntity roomEntity = roomRepository.findById(id).orElse(null);
        if (roomEntity == null) {
            return null;
        }
        if (startDate != null && endDate != null) {
            Date start = Date.valueOf(startDate);
            Date end = Date.valueOf(endDate);
            List<RoomEntity> availableRooms = roomRepository.findAvailableRooms(start, end);
            if (!availableRooms.contains(roomEntity)) {
                return null;
            }
        }
        return roomEntity;
    }
}
