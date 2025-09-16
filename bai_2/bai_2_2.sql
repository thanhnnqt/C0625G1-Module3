create database bai_2_2;
use bai_2_2;
create table khach_hang (
ma_khach_hang int primary key auto_increment,
ten_khach_hang varchar(100),
tuoi_khach_hang int
);
create table hoa_don (
ma_hoa_don int primary key auto_increment,
khach_hang int,
ngay_tao_hoa_don date,
tong_gia int,
foreign key (khach_hang) references khach_hang(ma_khach_hang)
);
create table san_pham (
ma_san_pham int primary key auto_increment,
ten_san_pham varchar(200),
gia_san_pham int
);
create table hoa_don_san_pham (
hoa_don int,
san_pham int,
so_luong_dat_hang varchar(100),
foreign key (hoa_don) references hoa_don (ma_hoa_don),
foreign key (san_pham) references san_pham (ma_san_pham)
);