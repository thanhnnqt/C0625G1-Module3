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
insert into khach_hang (ten_khach_hang, tuoi_khach_hang) values ('Minh Quan', 10),('Ngoc Oanh', 20), ('Hong Ha', 50);
insert into hoa_don (khach_hang, ngay_tao_hoa_don) values (1, '2006-03-21'), (2, '2006-03-23'), (1, '2006-03-16');
insert into san_pham (ten_san_pham, gia_san_pham) values ('May Giat', 3), ('Tu Lanh', 5), ('Dieu Hoa', 7), ('Quat', 1), ('Bep Dien', 2);
insert into hoa_don_san_pham (hoa_don, san_pham, so_luong_dat_hang) values (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
select * from khach_hang;
select * from hoa_don;
select * from san_pham;
select * from hoa_don_san_pham;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select h.ma_hoa_don, h.ngay_tao_hoa_don, s.gia_san_pham
from hoa_don h
inner join hoa_don_san_pham hs on h.ma_hoa_don = hs.hoa_don
inner join san_pham s on hs.san_pham = s.ma_san_pham;

-- Lấy ra danh sách khách hàng và sản phẩm khách hàng đó mua
select k.ten_khach_hang, s.ten_san_pham
from khach_hang k
inner join hoa_don h on k.ma_khach_hang = h.khach_hang
inner join hoa_don_san_pham hs on h.ma_hoa_don = hs.hoa_don
inner join san_pham s on hs.san_pham = s.ma_san_pham;

-- Lấy ra khách hàng không mua sản phẩm nào
select k.ten_khach_hang from khach_hang k left join hoa_don h on h.khach_hang = k.ma_khach_hang where h.khach_hang is null;

-- Hiển thị mã hóa đơn, ngày bán và giá của từng hóa đơn
select hs.hoa_don, h.ngay_tao_hoa_don, (s.gia_san_pham * hs.so_luong_dat_hang) as total
from hoa_don_san_pham hs 
inner join hoa_don h on hs.hoa_don = h.ma_hoa_don
inner join san_pham s on hs.san_pham = s.ma_san_pham;