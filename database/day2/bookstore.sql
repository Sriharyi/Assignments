create database onlinestore;
use onlinestore;

create table author(
URL varchar(50) unique,
author_name varchar(20),
address varchar(50) ,
primary key(author_name,address)
);

create table publisher(
publisher_name varchar(20) primary key,
address varchar(50),
phone integer,
URL varchar(50)
);

create table item(
item_id int primary key,
item_name varchar(500),
item_type varchar(50)
);

create table book(
isbn varchar(10) primary key,
item_id int,
title varchar(20),
book_year int,
price float4,
author_name varchar(20),
address varchar(50) ,
publisher_name varchar(20),
foreign key(publisher_name) references publisher(publisher_name) ,
foreign key(author_name,address) references author(author_name,address),
foreign key(item_id) references item(item_id)
);

create table music(
music_id varchar(10) primary key,
item_id int,
title varchar(20),
price float4,
author_name varchar(20),
address varchar(50) ,
publisher_name varchar(20),
foreign key(publisher_name) references publisher(publisher_name) ,
foreign key(author_name,address) references author(author_name,address),
foreign key(item_id) references item(item_id)
);

create table warehouse(
code varchar(10) primary key,
address varchar(50),
phone integer,
isbn varchar(10),
foreign key(isbn) references book(isbn)
);

create table customer(
email varchar(50) primary key,
name varchar(20),
address varchar(50),
phone integer
);


create table shopping_basket(
basket_id varchar(10) primary key,
email varchar(50),
foreign key(email) references customer(email)
);

create table cart(
basket_id varchar(10),
item_id int,
foreign key(item_id) references item(item_id),
foreign key(basket_id) references shopping_basket(basket_id)
);