create database quan_ly_internet;
use quan_ly_internet;
create table may_tinh (
ma_may_tinh int primary key auto_increment,
ten_hang_san_xuat varchar(50),
vi_tri int
);
create table loai_khach_hang (
ma_loai_khach_hang int primary key auto_increment,
ten_loai_khach_hang varchar(50)
);
create table khach_hang (
ma_khach_hang int primary key auto_increment,
ten_khach_hang varchar(50),
email varchar(50),
ma_loai_khach_hang int,
foreign key (ma_loai_khach_hang) references loai_khach_hang (ma_loai_khach_hang)
);
create table dich_vu_di_kem (
ma_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(50),
gia_dich_vu_di_kem double
);
create table dich_vu (
ma_dich_vu int primary key auto_increment,
thoi_gian_bat_dau datetime,
thoi_gian_ket_thuc datetime,
tong_tien_thanh_toan double,
ma_khach_hang int,
ma_may_tinh int,
ma_dich_vu_di_kem int,
foreign key (ma_khach_hang) references khach_hang (ma_khach_hang),
foreign key (ma_may_tinh) references may_tinh (ma_may_tinh)
);
create table goi_dich_vu_di_kem (
ma_goi_dich_vu_di_kem int primary key auto_increment,
so_luong int,
ma_dich_vu int,
ma_dich_vu_di_kem int,
foreign key (ma_dich_vu) references dich_vu (ma_dich_vu),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem (ma_dich_vu_di_kem)
);