CREATE TABLE IF NOT EXISTS photo (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(45),
    content_type VARCHAR(45),
    arr binary
);