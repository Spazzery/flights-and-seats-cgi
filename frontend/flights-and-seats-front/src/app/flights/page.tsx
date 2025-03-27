"use client";
import { useEffect, useState } from "react";
import { Flight } from "@/app/model/Flight";

export default function FlightsPage() {
    const [flights, setFlights] = useState<Flight[]>([]);

    // fetch from my api
    useEffect(() => {
        fetch("http://localhost:8080/flights") // Adjust API URL
            .then((res) => res.json())
            .then(setFlights);
    }, []);

    return (
        <div>
            <h1 className="text-xl font-bold mb-4">Choose a Flight</h1>
            <ul className="space-y-2">
                {flights.map((flight) => (

                    <li key={flight.id} className="p-3 border rounded shadow">
                        {flight.flightNumber} - {flight.price}
                    </li>

                ))}
            </ul>
        </div>
    );
}