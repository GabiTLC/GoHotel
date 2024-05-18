package com.GoHotel.GoHotel.Repository;

import com.GoHotel.GoHotel.Models.Hotel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
//    @Override
//    @EntityGraph(attributePaths = {"rooms"})
//    List<Hotel> findAll();

}
