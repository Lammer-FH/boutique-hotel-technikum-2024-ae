package com.example.boutiquehoteltechnikum.objects;

import com.example.boutiquehoteltechnikum.dtos.GuestDto;
import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

@Value
@Builder
@Jacksonized
public class BookingResponseObject {

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

    @JsonProperty("rooms")
    private List<RoomDto> rooms;

    @JsonProperty("guests")
    private List<GuestDto> guests;
}
