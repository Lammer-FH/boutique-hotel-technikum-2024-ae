package com.example.boutiquehoteltechnikum.services;

import com.example.boutiquehoteltechnikum.models.BookingEntity;
import com.example.boutiquehoteltechnikum.models.GuestEntity;
import com.example.boutiquehoteltechnikum.models.RoomEntity;
import com.example.boutiquehoteltechnikum.objects.BookingRequestObject;
import com.example.boutiquehoteltechnikum.repositories.BookingRepository;
import com.example.boutiquehoteltechnikum.repositories.GuestRepository;
import com.example.boutiquehoteltechnikum.utils.DateValidator;
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

	public BookingEntity addBooking(BookingRequestObject bookingRequestObject) {
		RoomEntity room = roomService.getRoomById(
			bookingRequestObject.getRoomId(),
			DateValidator.getDate(bookingRequestObject.getStartDate()),
			DateValidator.getDate(bookingRequestObject.getEndDate())
		);
		if (room == null)
		{
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Das Zimmer ist zu den angegebenen Daten nicht mehr verfügbar!"
			);
		}

		GuestEntity guestEntity = guestRepository.save(GuestEntity.builder()
			.email(bookingRequestObject.getGuestDto().getEmail())
			.firstName(bookingRequestObject.getGuestDto().getFirstName())
			.lastName(bookingRequestObject.getGuestDto().getLastName())
			.build());

		BookingEntity bookingEntity = BookingEntity.builder()
			.startDate(DateValidator.getDate(bookingRequestObject.getStartDate()))
			.endDate(DateValidator.getDate(bookingRequestObject.getEndDate()))
			.rooms(List.of(room))
			.guests(List.of(guestEntity))
			.breakfast(bookingRequestObject.isBreakfast())
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
		throw new RuntimeException("No unique BookingNumber found!");
	}

	private String createBookingNumber() {
		return "BKG" + (int) (Math.random() * 100_000);
	}
}
