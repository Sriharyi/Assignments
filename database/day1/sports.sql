-- Players table
CREATE TABLE Players (
    player_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    registration_date DATE,
    rating INT,
    games_played INT,
    games_won INT,
    games_lost INT,
    games_drawn INT
);

-- Games table
CREATE TABLE Games (
    game_id INT PRIMARY KEY AUTO_INCREMENT,
    player1_id INT NOT NULL,
    player2_id INT NOT NULL,
    game_date DATE,
    result ENUM('win', 'loss', 'draw'),
    moves TEXT, -- You can store moves as a JSON array or other format
    FOREIGN KEY (player1_id) REFERENCES Players(player_id),
    FOREIGN KEY (player2_id) REFERENCES Players(player_id)
);

-- PlayerStatistics table (optional)
CREATE TABLE PlayerStatistics (
    stat_id INT PRIMARY KEY AUTO_INCREMENT,
    player_id INT NOT NULL,
    game_id INT NOT NULL,
    move_count INT,
    pieces_captured INT,
    checkmates INT,
    castling_count INT,
    stalemates INT,
    FOREIGN KEY (player_id) REFERENCES Players(player_id),
    FOREIGN KEY (game_id) REFERENCES Games(game_id)
);

-- Inserting data into the Players table
INSERT INTO Players (username, email, password_hash, registration_date, rating, games_played, games_won, games_lost, games_drawn)
VALUES
    ('player1', 'player1@example.com', 'hashed_pass1', '2023-01-15', 1600, 20, 10, 8, 2),
    ('player2', 'player2@example.com', 'hashed_pass2', '2023-02-20', 1400, 25, 12, 10, 3),
    ('player3', 'player3@example.com', 'hashed_pass3', '2023-03-25', 1800, 15, 9, 4, 2),
    ('player4', 'player4@example.com', 'hashed_pass4', '2023-04-30', 1200, 18, 6, 9, 3),
    ('player5', 'player5@example.com', 'hashed_pass5', '2023-05-05', 1700, 22, 14, 6, 2);

-- Inserting data into the Games table
INSERT INTO Games (player1_id, player2_id, game_date, result, moves)
VALUES
    (1, 2, '2023-01-20', 'win', '["e4", "e5", "Nf3"]'),
    (1, 3, '2023-02-10', 'draw', '["d4", "d5", "Nc3"]'),
    (2, 4, '2023-03-05', 'loss', '["e4", "Nf6", "d3"]'),
    (3, 1, '2023-04-01', 'win', '["e4", "c5", "Nf3"]'),
    (4, 2, '2023-05-15', 'draw', '["e4", "e6", "Nf3"]');

-- Inserting data into the PlayerStatistics table (optional)
INSERT INTO PlayerStatistics (player_id, game_id, move_count, pieces_captured, checkmates, castling_count, stalemates)
VALUES
    (1, 1, 3, 2, 1, 1, 0),
    (1, 2, 3, 1, 0, 0, 1),
    (2, 3, 3, 3, 0, 0, 0),
    (3, 4, 3, 2, 1, 1, 0),
    (4, 5, 3, 1, 0, 0, 1);
