create database bai_1;
use bai_1;
create table class(
id int primary key auto_increment,
name varchar(200)
);
create table teacher(
id int primary key auto_increment,
name varchar(200),
age int,
country varchar(50)
);
insert into class(id, name) values (1, "Module 1"), (2, "Module 2"), (3, "Module 3");
update class set name = "Module 4" where id = 3;
delete from class where id = 2;
select * from class;
insert into teacher (id, name, age, country) values (1, "Thanh", 29, "Viet Nam"), (2, "Thoi", 31, "Viet Nam"), (3, "An", 23, "Viet Nam");
select * from teacher;
update teacher set name = "Huy" where id = 3;
delete from teacher where id = 2;
