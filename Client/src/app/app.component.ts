import { Component, OnInit } from '@angular/core';
import { HotelService } from '../services/hotelService';
import { Hotel } from '../models/hotel.model';
import {LocationService} from "../services/locationService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  hotels: Hotel[] = [];
  latitude: number | undefined;
  longitude: number | undefined;

  constructor(private hotelService: HotelService, private locationService: LocationService) {}

  ngOnInit() {
    this.hotelService.getHotels().subscribe(
      (hotels: Hotel[]) => (this.hotels = hotels),
      (error) => console.error('Error fetching hotels:', error)
    );
    this.locationService.getCurrentPosition()
      .then((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  }

  ngOnButtonPress() {
    this.hotelService.getHotelsFiltered(this.latitude, this.longitude).subscribe(
      (hotels: Hotel[]) => (this.hotels = hotels),
      (error) => console.error('Error fetching hotels:', error)
    );
  }
}
