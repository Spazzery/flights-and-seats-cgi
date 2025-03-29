"use client";
import { useEffect, useState } from "react";
import { Flight } from "@/app/model/Flight";
import {Table, TableHead, TableBody, TableCell, TableRow} from "@mui/material";

const API_URL = "http://localhost:8080/flights"

export default function FlightsPage() {

    const [flights, setFlights] = useState<Flight[]>([]);

    // fetch data from my API
    // automatically maps json to flight objects
    useEffect(() => {
        fetch(API_URL)
            .then(response => response.json())
            .then(setFlights)
    }, []);

    // used for displaying the table
    interface Column {
        id: keyof Flight;  // is a key in flight object, so we can use it to parse incoming json
        label: string;
    }

    const columns: Column[] = [
        {id: "flightNumber", label: "Flight Number"},
        {id: "destination", label: "Destination"},
        {id: "departureDate", label: "Departure Date"},
        {id: "arrivalDate", label: "Arrival Date"},
        {id: "departureTime", label: "Departure Time"},
        {id: "arrivalTime", label: "Arrival Time"},
        // {id: "duration", label: "Duration"},  // dont wanna include atm
        {id: "price", label: "Price"},
    ]

    // used this tutorial for table: https://dev.to/igbominadeveloper/how-to-build-a-custom-react-table-component-with-typescript-part-1-1ln
    return (
        <div>
            <h1 className="mb-4 text-center text-xl font-bold">View flights</h1>
            <Table>
                <TableHead>
                    <TableRow>
                        {columns.map((column) => (
                            <TableCell key={column.id} className="font-bold">{column.label}</TableCell>
                        ))}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {flights.map((flight) => (
                        <TableRow key={flight.id}>
                            {/*iterate as many times as there are columns*/}
                            {columns.map((column) => (
                                <TableCell key={column.id}>
                                    {flight[column.id]}
                                </TableCell>
                            ))}
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </div>
    )
}