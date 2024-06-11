package com.example.boutiquehoteltechnikum.repositories;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query("SELECT r FROM RoomEntity r WHERE r.roomId NOT IN (" +
           "SELECT br.room.roomId FROM BookingToRoomEntity br " +
           "JOIN br.booking b " +
           "WHERE b.startDate < :endDate AND b.endDate > :startDate)")
    List<RoomEntity> findAvailableRooms(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
