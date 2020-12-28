CREATE DATABASE cinema_database encoding ='UTF8';

CREATE SCHEMA IF NOT EXISTS cinema_repository;

CREATE TABLE cinema_repository.users
(
    id        BIGSERIAL PRIMARY KEY,
    username  VARCHAR(100) NOT NULL,
    password  VARCHAR(100) NOT NULL,
    email     VARCHAR(64)  NOT NULL UNIQUE,
    ticket_id INTEGER REFERENCES cinema_repository.tickets (id)

);

DROP TABLE cinema_repository.users;


CREATE TABLE cinema_repository.movie
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(120) NOT NULL,
    description VARCHAR(500) NOT NULL
);

DROP TABLE cinema_repository.users;


CREATE TABLE cinema_repository.tickets
(
    id        BIGSERIAL PRIMARY KEY,
    price     DOUBLE PRECISION NOT NULL,
    cinema_id INTEGER REFERENCES cinema_repository.movie (id)
);

DROP TABLE cinema_repository.tickets;