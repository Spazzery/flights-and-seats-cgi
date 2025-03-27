-- Created by Copilot

-- Create Plane table
CREATE TABLE plane (
    id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(255) NOT NULL,
    total_rows INT NOT NULL,
    seats_per_row INT NOT NULL
);

-- Create Seat table
CREATE TABLE seat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    seat_number VARCHAR(10) NOT NULL,
    seat_letter VARCHAR(1) NOT NULL,
    row_number INT NOT NULL,
    seat_type VARCHAR(50) NOT NULL,
    is_next_to_window BOOLEAN NOT NULL,
    is_next_to_aisle BOOLEAN NOT NULL,
    extra_leg_room BOOLEAN NOT NULL,
    is_available BOOLEAN NOT NULL,
    plane_id INT,
    FOREIGN KEY (plane_id) REFERENCES plane(id) ON DELETE CASCADE
);

-- Create Flight table
CREATE TABLE flight (
    id INT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(50) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    departure_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    arrival_date DATE NOT NULL,
    arrival_time TIME NOT NULL,
    duration INT NOT NULL,
    price DOUBLE NOT NULL,
    plane_id INT,
    FOREIGN KEY (plane_id) REFERENCES plane(id) ON DELETE CASCADE
);

-- Create Booking table
CREATE TABLE booking (
    id INT PRIMARY KEY AUTO_INCREMENT,
    passenger_name VARCHAR(255) NOT NULL,
    passenger_email VARCHAR(255) NOT NULL,
    passenger_phone VARCHAR(20) NOT NULL,
    booking_time TIMESTAMP NOT NULL,
    flight_id INT,
    FOREIGN KEY (flight_id) REFERENCES flight(id) ON DELETE CASCADE
);

-- Create Join Table for Booking and Seat
CREATE TABLE booking_seat (
    booking_id INT NOT NULL,
    seat_id INT NOT NULL,
    PRIMARY KEY (booking_id, seat_id),
    FOREIGN KEY (booking_id) REFERENCES booking(id) ON DELETE CASCADE,
    FOREIGN KEY (seat_id) REFERENCES seat(id) ON DELETE CASCADE
);
