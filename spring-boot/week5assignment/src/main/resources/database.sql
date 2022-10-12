-- Active: 1665542897208@@127.0.0.1@3306@b'testdb'

CREATE DATABASE geco_test;

use geco_test;

show tables;

CREATE Table
    IF NOT EXISTS geco_test.users (
        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
        name VARCHAR(200) NOT NULL,
        email VARCHAR(200) NOT NULL UNIQUE,
        phone VARCHAR(200),
        address VARCHAR(200),
        password VARCHAR(200)
    );

INSERT INTO
    geco_test.users (
        name,
        email,
        phone,
        address,
        password
    )
VALUES (
        "Piggy",
        "piggy@gmail.com",
        "12345678",
        "Orchard",
        "12345"
    ), (
        "Puppy",
        "puppy@gmail.com",
        "22345678",
        "Novena",
        "56789"
    ), (
        "Bunny",
        "bunny@gmail.com",
        "32345678",
        "Newton",
        "abcde"
    ), (
        "Kitty",
        "kitty@gmail.com",
        "42345678",
        "River Valley",
        "vwxyz"
    );

SELECT * FROM geco_test.users;