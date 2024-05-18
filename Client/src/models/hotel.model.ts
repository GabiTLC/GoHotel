import {Room} from './room.model'

export interface Hotel {
  id: number;
  name: string;
  latitude: number;
  longitude: number;
  rooms: Room[];

  // constructor(id: number, name: string, latitude: number, longitude: number, rooms: Room[]) {
  //   this.id = id;
  //   this.name = name;
  //   this.latitude = latitude;
  //   this.longitude = longitude;
  //   this.rooms = rooms
  // }

}
