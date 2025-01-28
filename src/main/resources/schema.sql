CREATE TABLE pet_booking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    owner_name VARCHAR(100) NOT NULL,
    pet_name VARCHAR(100) NOT NULL,
    appointment_date DATE NOT NULL,
    service_type VARCHAR(100) NOT NULL,
    pet_breed VARCHAR(100) NOT NULL,
    notes VARCHAR(255)
);

-- Insert sample data
INSERT INTO pet_booking (owner_name, pet_name, appointment_date, service_type, pet_breed, notes)
VALUES 
('Alice Smith', 'Buddy', '2025-01-20', 'Grooming', 'Golden Retriever', 'Regular grooming session');
