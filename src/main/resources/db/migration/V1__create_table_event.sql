CREATE TABLE event(
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    date_start TIMESTAMP NOT NULL,
    date_end TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity INTEGER NOT NULL,
    organizer VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
)