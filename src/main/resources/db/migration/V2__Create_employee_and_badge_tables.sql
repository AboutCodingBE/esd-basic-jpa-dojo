CREATE TABLE badges (
    id BIGSERIAL PRIMARY KEY,
    badge_number VARCHAR(50) NOT NULL UNIQUE,
    access_level VARCHAR(20) NOT NULL,
    issue_date VARCHAR(10) NOT NULL
);

-- Create employees table with foreign key to badges
CREATE TABLE employees (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    badge_id BIGINT,
    -- Foreign key constraint
    CONSTRAINT fk_employee_badge FOREIGN KEY (badge_id) REFERENCES badges(id)
);

