-- Create Course table
CREATE TABLE Course (
    c_number INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL
);

-- Insert sample data into Course table
INSERT INTO Course (c_number, name, department) VALUES
(101, 'Introduction to Computer Science', 'Computer Science');

-- Create Section table (Weak Entity)
CREATE TABLE Section (
    s_number INT PRIMARY KEY,
    enrollment_limit INT NOT NULL,
    c_number INT,
    FOREIGN KEY (c_number) REFERENCES Course(c_number)
);

-- Insert sample data into Section table
INSERT INTO Section (s_number, enrollment_limit, c_number) VALUES
(1, 50, 101),
(2, 40, 101);

-- Create Room table
CREATE TABLE Room (
    r_number INT PRIMARY KEY,
    capacity INT NOT NULL,
    building VARCHAR(255) NOT NULL
);

-- Insert sample data into Room table
INSERT INTO Room (r_number, capacity, building) VALUES
(101, 60, 'Building A'),
(201, 50, 'Building B');

-- Create Exam table
CREATE TABLE Exam (
    exam_id INT PRIMARY KEY,
    course_name VARCHAR(255),
    section_number INT,
    room_number INT,
    exam_time DATETIME,
    FOREIGN KEY (course_name) REFERENCES Course(name),
    FOREIGN KEY (section_number) REFERENCES Section(s_number),
    FOREIGN KEY (room_number) REFERENCES Room(r_number)
);

-- Insert sample data into Exam table
INSERT INTO Exam (exam_id, course_name, section_number, room_number, exam_time) VALUES
(1, 'Introduction to Computer Science', 1, 101, '2023-12-15 10:00:00'),
(2, 'Introduction to Computer Science', 2, 201, '2023-12-16 14:00:00');

