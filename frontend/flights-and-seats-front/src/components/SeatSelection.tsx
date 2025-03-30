"use client";
import {useState} from "react";
import {Plane} from "@/model/Plane";
import {Seat} from "@/model/Seat";

export default function SeatSelection() {
    const [selectedSeats, setSelectedSeats] = useState([]);

    return (
        <div>
            <h2 className="text-lg font-bold">Select seats</h2>
            <div>
                Here will be a seat map generated
            </div>
        </div>
    )
}

// AI generated, edited by me
export const SeatGrid = ({ plane }: { plane: Plane }) => {
    if (!plane || !plane.seats)
        return (<div>No seats available at the moment!</div>);

    // Groups the seats
    const seatsByRow: { [rowNumber: number]: Seat[] } = {};
    for (const seat of plane.seats) {
        if (!seatsByRow[seat.rowNumber]) {
            seatsByRow[seat.rowNumber] = [];
        }
        seatsByRow[seat.rowNumber].push(seat);
    }

    const seatsPerRow = plane.seatsPerRow || Object.values(seatsByRow)[0]?.length || 0;
    const rowNumbers = Object.keys(seatsByRow).sort((a, b) => parseInt(a) - parseInt(b));
    const maxSeatsPerRow = seatsPerRow + 1  // used for having a middle isle

    return (
        <div className="bg-gray-100 mt-4" style={{ width: '560px', height: '600px' }}>
            {rowNumbers.map(rowNumber => {
                const rowSeats = seatsByRow[parseInt(rowNumber, 10)];
                const middleIndex = Math.floor(rowSeats.length / 2);
                const numSeatsBeforeAisle = middleIndex;
                const numSeatsAfterAisle = rowSeats.length - middleIndex;

                return (
                    <div
                        key={rowNumber}
                        className="grid mb-6"
                        style={{ gridTemplateColumns: `repeat(${rowSeats.length + 1}, 80px)` }} // +1 for the visual aisle space
                    >
                        {rowSeats.slice(0, numSeatsBeforeAisle).map((seat, index) => {
                            const isBusiness = seat && seat.seatType === 'Business';
                            const seatHeight = isBusiness ? 'h-10' : 'h-8';
                            const seatWidth = isBusiness ? 'h-12' : 'h-10';

                            return (
                                <div key={seat.id} className="flex justify-center items-center">
                                    <button
                                        className={`p-2 rounded ${seatHeight} ${seatWidth} ${Boolean(seat.available) ? 'bg-green-500' : 'bg-gray-500'}`}
                                        disabled={Boolean(!seat.available)}
                                        style={{ width: 'auto' }}
                                    >
                                        {seat.rowNumber}{seat.seatLetter}
                                    </button>
                                </div>
                            );
                        })}

                        {/* Visual Middle Aisle */}
                        <div key={`aisle-${rowNumber}`} className="w-full bg-white" style={{ borderRight: '1px solid black', borderLeft: '1px solid black' }} />

                        {rowSeats.slice(numSeatsBeforeAisle).map((seat, index) => {
                            const isBusiness = seat && seat.seatType === 'Business';
                            const seatHeight = isBusiness ? 'h-10' : 'h-8';
                            const seatWidth = isBusiness ? 'h-12' : 'h-10';

                            return (
                                <div key={seat.id} className="flex justify-center items-center">
                                    <button
                                        className={`p-2 rounded ${seatHeight} ${seatWidth} ${Boolean(seat.available) ? 'bg-green-500' : 'bg-gray-500'}`}
                                        disabled={Boolean(!seat.available)}
                                        style={{ width: 'auto' }}
                                    >
                                        {seat.rowNumber}{seat.seatLetter}
                                    </button>
                                </div>
                            );
                        })}
                    </div>
                );
            })}
        </div>
    );
};