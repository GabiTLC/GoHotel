import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Hotel} from "../models/hotel.model";

@Injectable({ providedIn: 'root' })
export class HotelService {
  private apiUrl = 'http://localhost:8080/api/hotels';

  constructor(private http: HttpClient) {}

  getHotels() {
    return this.http.get<Hotel[]>(this.apiUrl);
  }

  getHotelsFiltered(lat: number | undefined, long: number | undefined) {
    return this.http.get<Hotel[]>(this.apiUrl); // change call to new method
  }

  getProduct(id: number) {
    return this.http.get<Hotel>(`${this.apiUrl}/${id}`);
  }

  // createProduct(product: Hotel) {
  //   return this.http.post<Hotel>(this.apiUrl, product);
  // }

  // ... similar methods for update and delete
}
