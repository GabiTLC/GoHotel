package com.GoHotel.GoHotel.Controllers;

import com.GoHotel.GoHotel.DTO.HotelDTO;
import com.GoHotel.GoHotel.Models.Hotel;
import com.GoHotel.GoHotel.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path="/api/hotels")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {


    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping("")
    public Iterable<HotelDTO> list() {
        return hotelService.listAll();
    }
    @GetMapping("/{latitude}/{longitude}")
    public Iterable<HotelDTO> listAllNearMe(@PathVariable double latitude, @PathVariable double longitude){
        return hotelService.listAllNearMe(latitude, longitude);
    }
//    @GetMapping("/hotelsNearMe")
//    public Optional<Hotel> listNearMe() {
//        return hotelService.listAllNearMe();
//    }

    @GetMapping("/{id}")
    public HotelDTO get(@PathVariable int id) {
        return hotelService.findById(id);
    }
}
