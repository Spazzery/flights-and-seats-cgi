import {Flight} from "@/app/model/Flight";
import {Seat} from "@/app/model/Seat";

export interface Booking {
    id: number;
    passengerName: string;
    passengerEmail: string;
    passengerPhone: string;
    bookingTime: string;
    flight: Flight;
    seats: Seat[];
}