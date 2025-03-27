import { Plane } from "@/app/model/Plane";

export interface Flight {
    id: number;
    flightNumber: string;
    destination: string;
    departureDate: string;
    departureTime: string;
    arrivalDate: string;
    arrivalTime: string;
    duration: number;
    price: number;
    plane: Plane;
}