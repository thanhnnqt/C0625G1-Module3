create database bai_2_1;
use bai_2_1;
create table phieuxuat (
ma_phieu_xuat int primary key auto_increment,
ngay_xuat date
);
create table phieunhap (
ma_phieu_nhap int primary key auto_increment,
ngay_nhap date 
);
create table nhacungcap (
ma_cung_cap int primary key auto_increment,
ten_nha_cung_cap varchar(50),
dia_chi varchar(50)
);
create table donhang (
ma_don_hang int primary key auto_increment,
ngay_tao_don_hang date,
foreign key (ma_don_hang) references nhacungcap (ma_cung_cap)
);
create table vattu (
ma_vat_tu int primary key auto_increment,
ten_vat_tu varchar(50)
);
create table phieuxuatvattu (
phieu_xuat int,
vat_tu int,
primary key (phieu_xuat, vat_tu),
foreign key (phieu_xuat) references phieuxuat (ma_phieu_xuat),
foreign key (vat_tu) references vattu (ma_vat_tu)
);
create table phieunhapvattu (
phieu_nhap int,
vat_tu int,
primary key (phieu_nhap, vat_tu),
foreign key (phieu_nhap) references phieunhap (ma_phieu_nhap),
foreign key (vat_tu) references vattu (ma_vat_tu)
);
create table donhangvattu (
don_hang int,
vat_tu int,
primary key (don_hang, vat_tu),
foreign key (don_hang) references donhang (ma_don_hang),
foreign key (vat_tu) references vattu (ma_vat_tu)
);
create table sodienthoai (
so_dien_thoai varchar(20),
nha_cung_cap int primary key,
foreign key (nha_cung_cap) references nhacungcap (ma_cung_cap)
);