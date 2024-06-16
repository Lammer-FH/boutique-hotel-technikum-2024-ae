package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.dtos.BookingWriteDto;
import com.example.boutiquehoteltechnikum.models.BookingEntity;
import com.example.boutiquehoteltechnikum.models.GuestEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.repositories.BookingRepository;
import com.example.boutiquehoteltechnikum.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	private RoomService roomService;

	public BookingEntity addBooking(BookingWriteDto bookingWriteDto) {
		RoomEntity room = roomService.getRoomById(
			bookingWriteDto.getRoomId(),
			bookingWriteDto.getStartDate(),
			bookingWriteDto.getEndDate()
		);
		if (room == null)
		{
			throw new ResponseStatusException(
				HttpStatus.valueOf(401),
				"{'message': 'room is no longer available'}"
			);
		}

		GuestEntity guestEntity = guestRepository.save(GuestEntity.builder()
			.email(bookingWriteDto.getEmail())
			.firstName(bookingWriteDto.getFirstName())
			.lastName(bookingWriteDto.getLastName())
			.build());

		BookingEntity bookingEntity = BookingEntity.builder()
			.startDate(bookingWriteDto.getStartDate())
			.endDate(bookingWriteDto.getEndDate())
			.rooms(List.of(room))
			.guests(List.of(guestEntity))
			.breakfast(bookingWriteDto.isBreakfast())
			.bookingNumber(generateUniqueBookingNumber())
			.build();

		return bookingRepository.save(bookingEntity);
	}

	private String generateUniqueBookingNumber()
	{
		String bookingNumber;
		for(int i = 0; i < 100; i++)
		{
			bookingNumber = createBookingNumber();
			boolean exists = bookingRepository.existsByBookingNumber(bookingNumber);
			if (!exists)
			{
				return bookingNumber;
			}
		}
		throw new RuntimeException("No unique BookingNumber found");
	}

	private String createBookingNumber() {
		return "BKG" + Math.random() * 100_000;
	}
}
