package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired private RoomRepository roomRepository;

    public Page<RoomEntity> getRooms(int limit, int offset, String startDate, String endDate) {
        Pageable pageable = PageRequest.of(offset / limit, limit);

        if (startDate == null || endDate == null) {
            return roomRepository.findAll(pageable);
        }

        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        List<RoomEntity> availableRooms = roomRepository.findAvailableRooms(start, end);

        int startItem = offset;
        int endItem = Math.min((startItem + limit), availableRooms.size());
        List<RoomEntity> pagedRooms = availableRooms.subList(startItem, endItem);

        return new PageImpl<>(pagedRooms, pageable, availableRooms.size());
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
