package com.example.boutiquehoteltechnikum.controllers;

import com.example.boutiquehoteltechnikum.objects.BookingResponseObject;
import com.example.boutiquehoteltechnikum.objects.BookingRequestObject;
import com.example.boutiquehoteltechnikum.models.BookingEntity;
import com.example.boutiquehoteltechnikum.services.BookingService;
import com.example.boutiquehoteltechnikum.services.RoomService;
import com.example.boutiquehoteltechnikum.transformer.BookingTransformer;
import com.example.boutiquehoteltechnikum.utils.DateValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingTransformer bookingTransformer;

	@PostMapping("")
	public BookingResponseObject bookRoom(@RequestBody @Valid BookingRequestObject bookingRequestObject) {
		DateValidator.validateDates(bookingRequestObject.getStartDate(), bookingRequestObject.getEndDate());
		return bookingTransformer.toDto(bookingService.addBooking(bookingRequestObject));
	}
}
