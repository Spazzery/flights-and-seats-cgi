import {Plane} from "@/app/model/Plane";

export interface Seat {
    id: number;
    seatNumber: string;  // 12
    seatLetter: string;  // E
    rowNumber: number;  // 6
    seatType: string;  // Standard, Business
    isNextToWindow: boolean;
    isNextToAisle: boolean;
    extraLegRoom: boolean;
    isAvailable: boolean;
    planeId: number;
}