// AI generated functions

import {Seat} from "@/model/Seat";

const API_URL = "http://localhost:8080"

export const fetchFlight = async (flightId: string | number) => {
    // debug
    // console.log(`fetch flight: ${typeof(flightId)}`)  // string

    const response = await fetch(`${API_URL}/flights/${flightId}`);
    if (!response.ok) throw new Error("Failed to fetch flight");
    return response.json();
};

export const fetchPlane = async (planeId: string | number) => {
    // debug
    // console.log(`fetch plane: ${typeof(planeId)}`)  // number

    const response = await fetch(`${API_URL}/planes/${planeId}`);
    if (!response.ok) throw new Error("Failed to fetch plane");
    return response.json();
};

export const fetchSeats = async (seatIds: number[]) => {
    const response = await fetch(`${API_URL}/seats`);
    if (!response.ok) throw new Error("Failed to fetch seats");

    // all seats
    const allSeats: Seat[] = await response.json();

    // Filter only the seats that belong to the given seatIds
    // TODO: do filtering in backend later. right now in frontend to make it work
    return allSeats.filter(seat => seatIds.includes(seat.id));
};
