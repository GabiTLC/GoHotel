package com.GoHotel.GoHotel.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String review;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_Id")
    private Hotel hotel;

    public Review() {

    }
}
