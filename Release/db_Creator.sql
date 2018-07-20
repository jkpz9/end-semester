create database SnakeGameDB;
use SnakeGameDB;
create table user_tb
(
name VARCHAR(45) primary key,
password VARCHAR(45) not null
);


create table Users
(Id int primary key auto_increment,
username VARCHAR(45) not null,
password VARCHAR(200) not null,
win int,
lose int,
score int
);
alter table Users Auto_increment = 1236;

create user hewittking IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON * . * TO hewittking;
