drop database if exists restaurant;
create database restaurant;

use restaurant;

create table `order`(
	id bigint auto_increment primary key,
	order_status enum('WAITING','ACCEPTED','INPROGRESS','RECEIVED','PAID'),
    customer varchar(50),
    bill decimal(10,2)
)auto_increment = 0;

create table `item`(
	id bigint auto_increment primary key,
    `name` varchar(50),
    `description` varchar(255),
    price decimal(10,2),
    order_id bigint,
    foreign key(order_id) references `order`(id)
)auto_increment = 0;
