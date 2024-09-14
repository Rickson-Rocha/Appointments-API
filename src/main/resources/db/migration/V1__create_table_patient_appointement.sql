

CREATE TABLE patient (
    id SERIAL PRIMARY KEY,            
    first_name VARCHAR(100) NOT NULL, 
    last_name VARCHAR(100) NOT NULL,  
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(11) NOT NULL UNIQUE  
);


CREATE TABLE appointment (
    id SERIAL PRIMARY KEY,            
    patient_id INT NOT NULL,          
    appointment_time TIMESTAMP NOT NULL, 
    description TEXT,                 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    FOREIGN KEY (patient_id) REFERENCES patient(id) 
);


INSERT INTO patient (first_name, last_name, email, cpf) VALUES
('John', 'Doe', 'john.doe@example.com', '123-45-6789'),
('Jane', 'Smith', 'jane.smith@example.com', '987-65-4321');

INSERT INTO appointment (patient_id, appointment_time, description) VALUES
(1, '2024-09-14 10:00:00', 'Routine check-up'),
(2, '2024-09-15 14:00:00', 'Dental cleaning');
