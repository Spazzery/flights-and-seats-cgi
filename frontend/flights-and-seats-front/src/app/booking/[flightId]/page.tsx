"use client";
import { useEffect, useState } from "react";
import { useParams } from "next/navigation";
import {Flight} from "@/model/Flight";
import {Plane} from "@/model/Plane";
import {Seat} from "@/model/Seat";
import {fetchFlight, fetchPlane, fetchSeats} from "@/utils/fetcher";
import {SeatGrid} from "@/components/SeatSelection";

export default function BookingPage() {
    const { flightId } = useParams() as { flightId: string };
    const [flight, setFlight] = useState<Flight | null>(null);
    const [plane, setPlane] = useState<Plane | null>(null);
    // const [seats, setSeats] = useState<Seat[]>([]);

    // AI generated, I modified
    useEffect(() => {
        const loadFlightData = async () => {
            try {
                const flightData = await fetchFlight(flightId);
                setFlight(flightData);

                if (flightData.planeId) {
                    const planeData = await fetchPlane(flightData.planeId);

                    if (planeData.seatIds) {
                        const seatsData = await fetchSeats(planeData.seatIds);
                        // setSeats(seatsData);  // not even needed rn

                        // update plane with seats
                        const updatedPlane = {...planeData, seats: seatsData}
                        setPlane(updatedPlane)

                        // console.log("updated plane")
                        // console.log(updatedPlane)
                    } else {
                        setPlane(planeData);
                    }

                }
            } catch (error) {
                console.error("Error loading flight data:", error);
            }
        }

        // actually load data
        loadFlightData();

    }, [flightId]);


    // temporarily show nothing
    if (!flight || !plane) return <p>Loading...</p>;

    // debug
    // console.log("flight")
    // console.log(flight)
    // console.log("hii")
    // console.log(plane)

    return (
            <div className="relative flex flex-col items-center"> {/* Container for plane outline and seats */}
                {flight && <h1 className="text-xl text-bold">Flight number: {flight.flightNumber}</h1>}
                {plane && <h2>Plane model: {plane.model}</h2>}
                <h3>Seats in the plane:</h3>

                {/*display seats grid*/}
                <div>
                    {plane && <SeatGrid plane={plane} />}
                </div>

            </div>
    )
}