package com.example.boutiquehoteltechnikum.objects;

import com.example.boutiquehoteltechnikum.dtos.GuestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.sql.Date;

@Value
@Builder
@Jacksonized
public class BookingRequestObject {

	@JsonProperty("roomId")
	private int roomId;

	@JsonProperty("startDate")
	private String startDate;

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("guest")
	@Valid
	private GuestDto guestDto;

	@JsonProperty("breakfast")
	private boolean breakfast;
}
