package com.example.boutiquehoteltechnikum.controllers;

import com.example.boutiquehoteltechnikum.dtos.BookingDto;
import com.example.boutiquehoteltechnikum.dtos.BookingWriteDto;
import com.example.boutiquehoteltechnikum.models.BookingEntity;
import com.example.boutiquehoteltechnikum.services.BookingService;
import com.example.boutiquehoteltechnikum.services.RoomService;
import com.example.boutiquehoteltechnikum.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private BookingTransformer bookingTransformer;

	@PostMapping("")
	public BookingDto postBooking(@RequestBody BookingWriteDto bookingWriteDto) {
		BookingEntity bookingEntity = bookingService.addBooking(bookingWriteDto);
		return bookingTransformer.toDto(bookingEntity);
	}
}
