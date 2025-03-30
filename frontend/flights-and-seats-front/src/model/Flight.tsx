import { Plane } from "@/model/Plane";

export class Flight {
    id?: number;
    flightNumber?: string;
    destination?: string;
    departureDate?: string;
    departureTime?: string;
    arrivalDate?: string;
    arrivalTime?: string;
    duration?: number;
    price?: number;
    planeId?: number;
}