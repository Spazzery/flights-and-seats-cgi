-- CREATED by CHATGPT

-- Create the 'flight' table with more columns
CREATE TABLE IF NOT EXISTS flight (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      flight_name VARCHAR(255) NOT NULL,
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP
    );

-- Insert sample flight data with departure and arrival times
INSERT INTO flight (flight_name, departure_time, arrival_time)
VALUES
    ('Flight A', '2025-03-23 06:00:00', '2025-03-23 08:00:00'),
    ('Flight B', '2025-03-23 09:00:00', '2025-03-23 11:00:00'),
    ('Flight C', '2025-03-23 12:00:00', '2025-03-23 14:00:00'),
    ('Flight D', '2025-03-23 15:00:00', '2025-03-23 17:00:00'),
    ('Flight E', '2025-03-23 18:00:00', '2025-03-23 20:00:00');
