package com.example.boutiquehoteltechnikum.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

@Value
@Builder
@Jacksonized
public class BookingDto {

    @JsonProperty("bookingId")
    private int bookingId;

    @JsonProperty("bookingNumber")
    private String bookingNumber;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

    @JsonProperty("breakfast")
    private boolean breakfast;

    @JsonProperty("guests")
    private List<GuestDto> guests;
}