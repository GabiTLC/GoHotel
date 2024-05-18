package com.GoHotel.GoHotel.Services;

import com.GoHotel.GoHotel.DTO.HotelDTO;
import com.GoHotel.GoHotel.DTO.RoomDTO;
import com.GoHotel.GoHotel.Models.Hotel;
import com.GoHotel.GoHotel.Models.Room;
import com.GoHotel.GoHotel.Repository.HotelRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository repository) {
        this.hotelRepository = repository;
    }

    public List<HotelDTO> listAll() {
        List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll();
        for (Hotel hotel :hotels ){
            Hibernate.initialize(hotel.getRooms());
        }
        List<HotelDTO> hotelDTOs = new ArrayList<>();
        for (Hotel hotel : hotels) {
            hotelDTOs.add(mapHotelToDTO(hotel));
        }
        return hotelDTOs;

    }

    public HotelDTO mapHotelToDTO(Hotel hotel){
        if(hotel==null){
            return null;
        }
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotel.getName());
        hotelDTO.setLatitude(hotel.getLatitude());
        hotelDTO.setLongitude(hotel.getLongitude());
        List<RoomDTO> roomsdto = new ArrayList<>();
        for (Room room : hotel.getRooms()){
            roomsdto.add(mapRoomToDTO(room));
        }
        hotelDTO.setRooms(roomsdto);
        return hotelDTO;
    }
    public Hotel mapFromDTO_ToHotel(HotelDTO hoteldto){
        if(hoteldto==null){
            return null;
        }
        Hotel hotel = new Hotel();
        hotel.setName(hotel.getName());
        hotel.setLatitude(hotel.getLatitude());
        hotel.setLongitude(hotel.getLongitude());
        List<Room> rooms = new ArrayList<>();
        for (RoomDTO room : hoteldto.getRooms()){
            rooms.add(mapFromDTO_ToRoom(room));
        }
        hotel.setRooms(rooms);
        return hotel;
    }

    public RoomDTO mapRoomToDTO(Room room){
        if(room==null){
            return null;
        }
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.SetRoomNumber(room.getRoomNumber());
        roomDTO.SetIsAvailable(room.isAvailable());
        roomDTO.SetPrice(room.getPrice());
        roomDTO.SetType(room.getType());
        return roomDTO;
    }
    public Room mapFromDTO_ToRoom(RoomDTO roomdto){
        if(roomdto==null){
            return null;
        }
        Room room = new Room();
        room.SetRoomNumber(roomdto.getRoomNumber());
        room.SetIsAvailable(roomdto.isAvailable());
        room.SetPrice(roomdto.getPrice());
        room.SetType(roomdto.getType());
        return room;
    }

    public List<HotelDTO> listAllNearMe(double latitude, double longitude) {
        Iterable<Hotel> hotels = hotelRepository.findAll();
        List<HotelDTO> hotelDTOs = new ArrayList<>();
        for (Hotel hotel : hotels) {
            double lat = hotel.getLatitude();
            double lon = hotel.getLongitude();
            double earthRadius = 6378.137;
            double x = earthRadius * Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(lon));
            double y = earthRadius * Math.cos(Math.toRadians(lat)) * Math.sin(Math.toRadians(lon));
            double z = earthRadius * Math.sin(Math.toRadians(lat));
            double distanceToCenter = Math.sqrt(x * x + y * y + z * z);
            double x1 = earthRadius * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
            double y1 = earthRadius * Math.cos(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
            double z1 = earthRadius * Math.sin(Math.toRadians(latitude));
            double distanceOfUser=Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
            if(distanceToCenter-distanceOfUser>10){ //to be added input

                hotelDTOs.add(mapHotelToDTO(hotel));
            }
        }
        return hotelDTOs;
    }

    public HotelDTO findById(int id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return mapHotelToDTO(hotel.orElse(null));
    }


    public int save(HotelDTO hotelDto) {
        Hotel hotel = hotelRepository.save(mapFromDTO_ToHotel(hotelDto));
        return hotel.getId();
    }

    public Iterable<Hotel> saveAll(List<Hotel> hotels){
        for (Hotel hotel : hotels) {
            for (Room room : hotel.getRooms()) {
                room.setHotel(hotel);
            }
        }
        return hotelRepository.saveAll(hotels);
    }

}
