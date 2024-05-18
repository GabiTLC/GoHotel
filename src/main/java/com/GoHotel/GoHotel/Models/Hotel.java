package com.GoHotel.GoHotel.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
//@Access(AccessType.FIELD)
@Table(name = "hotels")
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    @OneToMany(mappedBy = "hotel" , cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    //@JsonIgnore
    private List<Room> rooms=new ArrayList<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews=new ArrayList<>();
    public Hotel() {

    }
}
