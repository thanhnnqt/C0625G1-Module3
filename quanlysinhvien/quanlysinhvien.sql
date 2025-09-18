create database	quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class (
class_id int not null primary key auto_increment,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit
);
create table student (
student_id int not null primary key auto_increment,
student_name varchar(30) not null,
address varchar(50),
phone_number varchar(20),
`status` bit,
class_id int not null,
foreign key (class_id) references class(class_id)
);
create table `subject` (
sub_id int not null primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint not null default 1 check (credit >= 1),
`status` bit default 1
);
create table mark (
mark_id int not null primary key auto_increment,
sub_id int not null,
student_id int not null,
mark float default 0 check (mark between 0 and 100),
exam_time tinyint default 1,
unique (sub_id, student_id),
foreign key (sub_id) references `subject`(sub_id),
foreign key (student_id) references student(student_id)
);

insert into class (class_name, start_date, `status`) values 
('c0625g1', '2025-06-30', 1), 
('c0725g1', '2025-07-30', 1), 
('c0825g1', '2025-08-30', 1);
insert into student (student_name, address, phone_number, `status`, class_id) values
('nguyen van a', 'da nang', '0123456789', 1, 1),
('nguyen van b', 'quang tri', '012789456', 1, 2),
('nguyen van c', 'quang nam', '0456123789', 1, 1);
insert into `subject` (sub_name, credit, `status`) values
('toan', 4, 1),
('ly', 3, 1),
('van', 4, 1),
('hoa', 2, 1);
insert into mark (sub_id, student_id, mark, exam_time) values
(1, 1, 8, 1),
(1, 2, 7, 1),
(1, 3, 9, 1),
(2, 3, 8, 1),
(2, 1, 6, 1),
(3, 1, 9, 1),
(3, 2, 8, 1);

select * from class;
select * from student;
select * from `subject`;
select * from mark;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
select * from `subject` where `subject`.credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất
select s.sub_name, m.mark from mark m
join `subject` s on m.sub_id = s.sub_id
where m.mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *,
(select avg(m.mark) from mark m where m.student_id = s.student_id) as diemtrungbinh
from student s
order by diemtrungbinh desc;

-- Dùng hàm join
select s.student_id, s.student_name, avg(m.mark) as diemtrungbinh from student s
join mark m on m.student_id = s.student_id
group by s.student_id
order by diemtrungbinh desc;