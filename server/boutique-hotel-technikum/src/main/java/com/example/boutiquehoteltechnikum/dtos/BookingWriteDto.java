package com.example.boutiquehoteltechnikum.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.sql.Date;


@Value
@Builder
@Jacksonized
public class BookingWriteDto {
	@JsonProperty("roomId")
	private int roomId;

	@JsonProperty("startDate")
	private Date startDate;

	@JsonProperty("endDate")
	private Date endDate;

	@JsonProperty("firstName")
	@Size(max = 50, message = "Der Vorname darf nicht länger als 50 Zeichen sein!")
	private String firstName;

	@JsonProperty("lastName")
	@Size(max = 50, message = "Der Nachname darf nicht länger als 50 Zeichen sein!")
	private String lastName;

	@JsonProperty("email")
	@Size(max = 50, message = "Die Email darf nicht länger als 50 Zeichen sein!")
	private String email;

	@JsonProperty("breakfast")
	private boolean breakfast;
}
