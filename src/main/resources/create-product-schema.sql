CREATE TABLE IF NOT EXISTS product (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(512),
    description VARCHAR(1024),
    created DATETIME,
    place_storage INTEGER,
    reserved BOOLEAN);

