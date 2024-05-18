package com.GoHotel.GoHotel.Services;

import com.GoHotel.GoHotel.Models.Room;
import com.GoHotel.GoHotel.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository repository) {
        this.roomRepository = repository;
    }

    public Iterable<Room> listAll() {
        return roomRepository.findAll();
    }

//    public Optional<List<Room>> listAvailable() {
//        Iterable<Room> rooms = new ArrayList<>();
//        List<Room> availableRooms = new ArrayList<>();
//        rooms = roomRepository.findAll();
//        for (Room room : rooms) {
//            if (room.isAvailable()) {
//                availableRooms.add(room);
//            }
//        }
//        return availableRooms.isEmpty() ? Optional.empty() : Optional.of(availableRooms);
//    }


    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Iterable<Room> save(List<Room> rooms){
        return roomRepository.saveAll(rooms);
    }
}
