CREATE DATABASE socialservice;

CREATE TABLE IF NOT EXISTS consultation (
    id bigint PRIMARY KEY,
    title varchar(50),
    client_name varchar(50),
    txt varchar(255)
);