import {Seat} from "@/app/model/Seat";

export interface Plane {
    id: number;
    model: string;
    totalRows: number;
    seatsPerRow: number;
    seatIds: number[];
}