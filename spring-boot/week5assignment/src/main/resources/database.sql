-- Active: 1665542897208@@127.0.0.1@3306@b'testdb'

CREATE DATABASE geco_test;

use geco_test;

show tables;

CREATE Table
    IF NOT EXISTS geco_test.users (
        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
        name VARCHAR(200) NOT NULL,
        email VARCHAR(200) NOT NULL UNIQUE,
        phone VARCHAR(200)
    );