CREATE TABLE batteries (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    energy_input_per_hour INT NOT NULL CHECK (energy_input_per_hour > 0)
)