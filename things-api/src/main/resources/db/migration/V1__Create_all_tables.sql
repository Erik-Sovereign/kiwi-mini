CREATE TABLE batteries (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    energy_input_per_hour INT NOT NULL CHECK (energy_input_per_hour > 0)
);
CREATE TABLE chargers (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    energy_input_per_hour INT NOT NULL CHECK (energy_input_per_hour > 0),
    charging BOOLEAN NOT NULL
);
CREATE TABLE solarpanels (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    energy_output_per_hour INT NOT NULL CHECK (energy_output_per_hour > 0)
)