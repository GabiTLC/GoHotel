package com.GoHotel.GoHotel;

import com.GoHotel.GoHotel.Models.Hotel;
import com.GoHotel.GoHotel.Services.HotelService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication

public class GoHotelApplication {

	public static void main(String[] args) {

		SpringApplication.run(GoHotelApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(HotelService hotelService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Hotel>> typeReference = new TypeReference<List<Hotel>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/hotels.json");
			try {
				List<Hotel> hotels = mapper.readValue(inputStream,typeReference);
				hotelService.saveAll(hotels);
				System.out.println("Hotel Saved!");
			} catch (IOException e){
				System.out.println("Unable to save hotel: " + e.getMessage());
			}
		};
	}
}
