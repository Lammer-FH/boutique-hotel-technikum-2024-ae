package com.example.boutiquehoteltechnikum.repositories;

import com.example.boutiquehoteltechnikum.models.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
	boolean existsByBookingNumber(String bookingNumber);
}
