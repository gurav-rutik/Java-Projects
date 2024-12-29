-- Database: online_exam_portal
CREATE DATABASE IF NOT EXISTS online_exam_portal;
USE online_exam_portal;

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Table: questions
CREATE TABLE IF NOT EXISTS questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    option4 VARCHAR(255) NOT NULL,
    answer VARCHAR(255) NOT NULL
);

-- Table: results
CREATE TABLE IF NOT EXISTS results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    score INT NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);

-- Sample Data: users
INSERT INTO users (username, password) VALUES
('admin', 'admin123'),
('user1', 'password1');

-- Sample Data: questions
INSERT INTO questions (question, option1, option2, option3, option4, answer) VALUES
('What is the capital of France?', 'Paris', 'Berlin', 'Madrid', 'Rome', 'Paris'),
('Which planet is known as the Red Planet?', 'Earth', 'Mars', 'Jupiter', 'Venus', 'Mars'),
('What is 5 + 7?', '10', '11', '12', '13', '12');
