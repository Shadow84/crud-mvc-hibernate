CREATE DATABASE 'test';
USE 'test';

CREATE TABLE `users` (  
  `id` int(6) NOT NULL AUTO_INCREMENT,  
  `name` varchar(40),  
  `age` int(6),  
  `isAdmin` bit,
  `createdDate` timestamp,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;  

INSERT INTO `users` (name,age,isAdmin)
VALUES ('Khilafn', 20, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Max', 30, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Lula', 10, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Mafa', 40, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Nigar', 50, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Dunk', 60, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Alcos', 70, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Mimi', 80, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Manana', 90, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Lillo', 45, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Lillo2', 453, b'1');
INSERT INTO `users` (name,age,isAdmin)
VALUES ('Lillo1', 4, b'1');
