create database Sports;
use Sports;

-- Create the Team table
CREATE TABLE Team (
    TeamID INT PRIMARY KEY,
    TeamName VARCHAR(255),
    Owner VARCHAR(255),
    Captain VARCHAR(255),
    Coach VARCHAR(255),
    HomeCity VARCHAR(255),
    HomeStadium VARCHAR(255),
    FoundedYear INT
);

-- Create the Player table
CREATE TABLE Player (
    PlayerID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    DateOfBirth DATE,
    Nationality VARCHAR(255),
    PlayingRole VARCHAR(255),
    BattingStyle VARCHAR(255),
    BowlingStyle VARCHAR(255),
    TeamID INT,  -- Foreign key referencing Team
    FOREIGN KEY (TeamID) REFERENCES Team(TeamID)
);

-- Create the IPL Season table
CREATE TABLE IPLSeason (
    SeasonID INT PRIMARY KEY,
    SeasonYear INT,
    StartDate DATE,
    EndDate DATE,
    SeasonChampion INT  -- Foreign key referencing Team
);

-- Create the Match table
CREATE TABLE Match (
    MatchID INT PRIMARY KEY,
    MatchDate DATE,
    Venue VARCHAR(255),
    HostTeam INT,  -- Foreign key referencing Team
    OpponentTeam INT,  -- Foreign key referencing Team
    Result VARCHAR(20),
    Margin VARCHAR(50),
    PlayerOfTheMatch INT,  -- Foreign key referencing Player
    SeasonID INT  -- Foreign key referencing IPLSeason
);

-- Create the PlayerStats table
CREATE TABLE PlayerStats (
    StatID INT PRIMARY KEY,
    PlayerID INT,  -- Foreign key referencing Player
    MatchID INT,  -- Foreign key referencing Match
    RunsScored INT,
    WicketsTaken INT,
    BallsFaced INT,
    BallsBowled INT,
    Boundaries INT,
    Catches INT,
    RunOuts INT,
    BattingAverage DECIMAL(5, 2),
    BowlingAverage DECIMAL(5, 2),
    BattingStrikeRate DECIMAL(5, 2),
    BowlingEconomyRate DECIMAL(5, 2),
    Centuries INT,
    HalfCenturies INT,
    Fours INT,
    Sixes INT
);

-- Insert sample data into Team, Player, IPLSeason tables
INSERT INTO Team (TeamID, TeamName, Owner, Captain, Coach, HomeCity, HomeStadium, FoundedYear)
VALUES
    (1, 'Chennai Super Kings', 'CSK Owner', 'MS Dhoni', 'CSK Coach', 'Chennai', 'M.A. Chidambaram Stadium', 2008),
    (2, 'Mumbai Indians', 'MI Owner', 'Rohit Sharma', 'MI Coach', 'Mumbai', 'Wankhede Stadium', 2008);

INSERT INTO Player (PlayerID, FirstName, LastName, DateOfBirth, Nationality, PlayingRole, BattingStyle, BowlingStyle, TeamID)
VALUES
    (1, 'MS', 'Dhoni', '1981-07-07', 'Indian', 'Wicket-keeper', 'Right-handed', 'Right-arm medium', 1),
    (2, 'Rohit', 'Sharma', '1987-04-30', 'Indian', 'Batsman', 'Right-handed', 'Right-arm off-spin', 2);

INSERT INTO IPLSeason (SeasonID, SeasonYear, StartDate, EndDate, SeasonChampion)
VALUES
    (1, 2023, '2023-03-23', '2023-05-30', 1);

-- Insert sample data into Match and PlayerStats tables (adjust as needed)
-- For simplicity, I'm inserting data for just one match and one player.
INSERT INTO Match (MatchID, MatchDate, Venue, HostTeam, OpponentTeam, Result, Margin, PlayerOfTheMatch, SeasonID)
VALUES
    (1, '2023-04-01', 'M.A. Chidambaram Stadium', 1, 2, 'CSK won', '50 runs', 1, 1);

INSERT INTO PlayerStats (StatID, PlayerID, MatchID, RunsScored, WicketsTaken, BallsFaced, BallsBowled, Boundaries, Catches, RunOuts, BattingAverage, BowlingAverage, BattingStrikeRate, BowlingEconomyRate, Centuries, HalfCenturies, Fours, Sixes)
VALUES
    (1, 1, 1, 30, 0, 25, 0, 5, 1, 0, 30.00, 0.00, 120.00, 0.00, 0, 0, 3, 1);
