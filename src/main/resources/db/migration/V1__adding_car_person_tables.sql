-- Create cars table first (no foreign key dependencies)
CREATE TABLE cars (
    id BIGSERIAL PRIMARY KEY,
    make VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    number_plate VARCHAR(20) NOT NULL UNIQUE
);

-- Create persons table with foreign key to cars
CREATE TABLE persons (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    current_car BIGINT

    -- Foreign key constraint
    CONSTRAINT fk_person_car FOREIGN KEY (current_car) REFERENCES cars(id)
);