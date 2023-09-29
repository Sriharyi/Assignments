-- The following is a database schema for the course enrollment system described above:

create database CourseManagement;
use CourseManagement;

CREATE TABLE courses (
  course_number INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  credits INT NOT NULL,
  syllabus VARCHAR(255) NOT NULL,
  prerequisites VARCHAR(255),
  PRIMARY KEY (course_number)
);

CREATE TABLE course_offerings (
  course_number INT NOT NULL,
  year INT NOT NULL,
  semester VARCHAR(255) NOT NULL,
  section_number INT NOT NULL,
  timings VARCHAR(255) NOT NULL,
  classroom VARCHAR(255) NOT NULL,
  PRIMARY KEY (course_number, year, semester, section_number),
  FOREIGN KEY (course_number) REFERENCES courses(course_number)
);

CREATE TABLE students (
  student_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  program VARCHAR(255) NOT NULL,
  PRIMARY KEY (student_id)
);

CREATE TABLE instructors (
  instructor_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  department VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  PRIMARY KEY (instructor_id)
);

CREATE TABLE instructor_teaches_courses (
  instructor_id INT NOT NULL,
  course_number INT NOT NULL,
  year INT NOT NULL,
  semester VARCHAR(255) NOT NULL,
  section_number INT NOT NULL,
  PRIMARY KEY (instructor_id, course_number, year, semester, section_number),
  FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id),
  FOREIGN KEY (course_number, year, semester, section_number) REFERENCES course_offerings(course_number, year, semester, section_number)
);

CREATE TABLE student_enrolls_in_courses (
  student_id INT NOT NULL,
  course_number INT NOT NULL,
  year INT NOT NULL,
  semester VARCHAR(255) NOT NULL,
  section_number INT NOT NULL,
  PRIMARY KEY (student_id, course_number, year, semester, section_number),
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (course_number, year, semester, section_number) REFERENCES course_offerings(course_number, year, semester, section_number)
);

CREATE TABLE grades (
  student_id INT NOT NULL,
  course_number INT NOT NULL,
  year INT NOT NULL,
  semester VARCHAR(255) NOT NULL,
  section_number INT NOT NULL,
  grade VARCHAR(255) NOT NULL,
  PRIMARY KEY (student_id, course_number, year, semester, section_number),
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (course_number, year, semester, section_number) REFERENCES course_offerings(course_number, year, semester, section_number)
);


-- Courses
INSERT INTO courses (course_number, title, credits, syllabus, prerequisites)
VALUES
  (12345, 'Introduction to Programming', 3, 'This course introduces the fundamental concepts of programming, such as variables, data types, control flow, and functions.', ''),
  (67890, 'Data Structures and Algorithms', 4, 'This course covers the fundamentals of data structures and algorithms, such as arrays, linked lists, stacks, queues, trees, and graphs.', '12345'),
  (98765, 'Software Engineering', 4, 'This course covers the principles and practices of software engineering, such as requirements analysis, design, implementation, testing, and maintenance.', '67890'),
  (45678, 'Machine Learning', 4, 'This course covers the fundamental concepts of machine learning, such as supervised learning, unsupervised learning, and reinforcement learning.', '67890'),
  (32165, 'Computer Networks', 4, 'This course covers the fundamentals of computer networks, such as network architecture, protocols, and routing.', '98765');

-- Course offerings
INSERT INTO course_offerings (course_number, year, semester, section_number, timings, classroom)
VALUES
  (12345, 2023, 'Fall', 1, 'MWF 10:00am - 10:50am', 'CS 101'),
  (67890, 2023, 'Fall', 2, 'TTh 1:00pm - 1:50pm', 'CS 202'),
  (98765, 2023, 'Fall', 3, 'WF 2:00pm - 2:50pm', 'CS 303'),
  (45678, 2023, 'Fall', 4, 'MWF 3:00pm - 3:50pm', 'CS 404'),
  (32165, 2023, 'Fall', 5, 'TTh 4:00pm - 4:50pm', 'CS 505'),
  (12345, 2024, 'Spring', 6, 'MWF 11:00am - 11:50am', 'CS 101'),
  (67890, 2024, 'Spring', 7, 'TTh 2:00pm - 2:50pm', 'CS 202'),
  (98765, 2024, 'Spring', 8, 'WF 3:00pm - 3:50pm', 'CS 303'),
  (45678, 2024, 'Spring', 9, 'MWF 4:00pm - 4:50pm', 'CS 404'),
  (32165, 2024, 'Spring', 10, 'TTh 5:00pm - 5:50pm', 'CS 505');

-- Students
INSERT INTO students (student_id, name, program)
VALUES
  (123456789, 'Alice Smith', 'Computer Science'),
  (987654321, 'Bob Jones', 'Computer Science'),
  (111111111, 'Carol Williams', 'Computer Science'),
  (222222222, 'David Miller', 'Computer Science'),
  (333333333, 'Emily Johnson', 'Computer Science');

-- Instructors
INSERT INTO instructors (instructor_id, name, department, title)
VALUES
  (999999999, 'Professor Doe', 'Computer Science', 'Professor'),
  (888888888, 'Professor Brown', 'Computer Science', 'Professor'),
  (777777777, 'Professor Green', 'Computer Science', 'Professor');

INSERT INTO instructor_teaches_courses (instructor_id, course_number, year, semester, section_number)
VALUES
  (999999999, 12345, 2023, 'Fall', 1),
  (999999999, 67890, 2023, 'Fall', 2),
  (999999999, 98765, 2023, 'Fall', 3);

INSERT INTO student_enrolls_in_courses (student_id, course_number, year, semester, section_number)
VALUES
  (123456789, 12345, 2023, 'Fall', 1),
  (987654321, 67890, 2023, 'Fall', 2),
  (111111111, 98765, 2023, 'Fall', 3);

INSERT INTO grades (student_id, course_number, year, semester, section_number, grade)
VALUES
  (123456789, 12345, 2023, 'Fall', 1, 'A'),
  (987654321, 67890, 2023, 'Fall', 2, 'B'),
  (111111111, 98765, 2023, 'Fall', 3, 'C');

