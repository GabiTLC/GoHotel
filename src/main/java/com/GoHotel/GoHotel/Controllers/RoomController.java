package com.GoHotel.GoHotel.Controllers;

import com.GoHotel.GoHotel.Models.Room;
import com.GoHotel.GoHotel.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/rooms")
public class RoomController {
//    private final RoomService roomService;
//
//    @Autowired
//    public RoomController(RoomService roomService) {
//        this.roomService = roomService;
//    }
//    @GetMapping("")
//    public Optional<List<Room>> listAllAvailable() {
//        return roomService.listAvailable();
//    }
}
