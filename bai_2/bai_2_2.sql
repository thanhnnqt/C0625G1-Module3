create database quanlybanhang;
use quanlybanhang;
create table khachhang (
cID int primary key auto_increment,
cName varchar(100),
cAge int
);
create table hoadon (
oID int primary key auto_increment,
kCID int,
oDate date,
oTotalPrice int,
foreign key (kCID) references khachhang(cID)
);
create table sanpham (
pID int primary key auto_increment,
pName varchar(200),
pPrice int
);
create table hoadonsanpham (
hOCID int,
sPID int,
odQTY varchar(100),
foreign key (oOCID) references hoadon (oID),
foreign key (sPID) references sanpham (pID)
);