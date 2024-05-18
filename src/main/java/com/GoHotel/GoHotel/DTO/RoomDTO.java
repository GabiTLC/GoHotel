package com.GoHotel.GoHotel.DTO;

import com.GoHotel.GoHotel.Models.Hotel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomDTO {
    private int id;

    private int roomNumber;
    private int type;
    private int price;
    private boolean isAvailable;
    public void SetRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void SetType(int type) {
        this.type = type;
    }
    public void SetPrice(int price) {
        this.price = price;
    }
    public void SetIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
