import {Flight} from "@/model/Flight";
import {Seat} from "@/model/Seat";

export interface Booking {
    id: number;
    passengerName: string;
    passengerEmail: string;
    passengerPhone: string;
    bookingTime: string;
    flightId: number;
    seatIds: number[];
}