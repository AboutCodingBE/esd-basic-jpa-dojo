-- Create classes table first (no foreign key dependencies)
CREATE TABLE classes (
    id BIGSERIAL PRIMARY KEY,
    class_name VARCHAR(50) NOT NULL,
    teacher VARCHAR(100) NOT NULL,
    room VARCHAR(20) NOT NULL,
);

-- Create children table with foreign key to classes
CREATE TABLE children (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    student_number VARCHAR(20) NOT NULL UNIQUE,
    class_id BIGINT,

    -- Foreign key constraint (Many-to-One: many children belong to one class)
    CONSTRAINT fk_child_class FOREIGN KEY (class_id) REFERENCES classes(id)
);