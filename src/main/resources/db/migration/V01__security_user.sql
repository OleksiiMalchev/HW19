CREATE TABLE product (
       id VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
       name VARCHAR(128),
       cost bigint);

CREATE TABLE users (
       id VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
       name VARCHAR(128),
       password VARCHAR(128),
       role VARCHAR(128));

INSERT INTO product (name,cost) value("book",100), ("pencil",20),("pen",10);

INSERT INTO users(name,password,role) value("user1","user1","USER"),("user2","user2","USER"),("admin","admin","USER,ADMIN");