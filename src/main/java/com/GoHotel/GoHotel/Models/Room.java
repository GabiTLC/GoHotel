package com.GoHotel.GoHotel.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
//@Access(AccessType.FIELD)
@Table(name = "rooms")
public class Room{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_Id")
    private Hotel hotel;


    private int roomNumber;
    private int type;
    private int price;
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations =new ArrayList<>();

    public Room() {}

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
