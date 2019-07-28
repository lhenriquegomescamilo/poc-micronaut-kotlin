CREATE TABLE Persons
(
    id   serial PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);