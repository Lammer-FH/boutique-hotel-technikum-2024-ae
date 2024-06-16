package com.example.boutiquehoteltechnikum.repositories;


import com.example.boutiquehoteltechnikum.models.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Integer> {
}
