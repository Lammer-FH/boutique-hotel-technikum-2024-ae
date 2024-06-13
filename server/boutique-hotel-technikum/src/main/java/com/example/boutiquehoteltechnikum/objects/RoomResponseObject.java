package com.example.boutiquehoteltechnikum.objects;

import com.example.boutiquehoteltechnikum.dtos.RoomDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseObject {

    private int limit;
    private int offset;
    private long total;
    private List<RoomDto> roomDtos;
}
