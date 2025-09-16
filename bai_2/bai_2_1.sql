create database bai_2_1;
use bai_2_1;
create table phieu_xuat (
ma_phieu_xuat int primary key auto_increment,
ngay_xuat date
);
create table phieu_nhap (
ma_phieu_nhap int primary key auto_increment,
ngay_nhap date 
);
create table nha_cung_cap (
ma_cung_cap int primary key auto_increment,
ten_nha_cung_cap varchar(50),
dia_chi varchar(50)
);
create table don_hang (
ma_don_hang int primary key auto_increment,
ngay_tao_don_hang date,
ma_cung_cap int,
foreign key (ma_cung_cap) references nha_cung_cap (ma_cung_cap)
);
create table vat_tu (
ma_vat_tu int primary key auto_increment,
ten_vat_tu varchar(50)
);
create table phieu_xuat_vat_tu (
phieu_xuat int,
vat_tu int,
gia_xuat double,
so_luong int,
primary key (phieu_xuat, vat_tu),
foreign key (phieu_xuat) references phieu_xuat (ma_phieu_xuat),
foreign key (vat_tu) references vat_tu (ma_vat_tu)
);
create table phieu_nhap_vat_tu (
phieu_nhap int,
vat_tu int,
gia_nhap double,
so_luong int,
primary key (phieu_nhap, vat_tu),
foreign key (phieu_nhap) references phieu_nhap (ma_phieu_nhap),
foreign key (vat_tu) references vat_tu (ma_vat_tu)
);
create table don_hang_vat_tu (
don_hang int,
vat_tu int,
primary key (don_hang, vat_tu),
foreign key (don_hang) references don_hang (ma_don_hang),
foreign key (vat_tu) references vat_tu (ma_vat_tu)
);
create table so_dien_thoai (
so_dien_thoai varchar(20),
nha_cung_cap int primary key,
foreign key (nha_cung_cap) references nha_cung_cap (ma_cung_cap)
);