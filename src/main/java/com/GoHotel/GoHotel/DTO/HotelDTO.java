package com.GoHotel.GoHotel.DTO;

import com.GoHotel.GoHotel.Models.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class HotelDTO {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private List<RoomDTO> rooms=new ArrayList<>();


}
