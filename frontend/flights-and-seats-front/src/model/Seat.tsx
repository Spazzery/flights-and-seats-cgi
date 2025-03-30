import {Plane} from "@/model/Plane";

export interface Seat {
    id: number;
    seatNumber: string;  // 12
    seatLetter: string;  // E
    rowNumber: number;  // 6
    seatType: string;  // Standard, Business
    nextToWindow: boolean;
    nextToAisle: boolean;
    extraLegRoom: boolean;
    available: boolean;
    planeId: number;
}