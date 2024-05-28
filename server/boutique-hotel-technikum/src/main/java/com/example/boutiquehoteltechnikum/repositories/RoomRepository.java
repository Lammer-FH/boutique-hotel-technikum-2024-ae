package com.example.boutiquehoteltechnikum.repositories;

import com.example.boutiquehoteltechnikum.models.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
}
