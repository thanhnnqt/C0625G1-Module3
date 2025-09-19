create database demo;
use demo;
create table products(
id int primary key auto_increment not null,
product_code varchar(50),
product_name varchar(50),
product_price int,
product_amount int,
product_description varchar(50),
product_status tinyint
);

-- Chèn một số dữ liệu mẫu cho bảng Products
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) values
('P001', 'Samsung S22', 20, 10, 'smart phone', 1),
('P002', 'Samsung S10', 10, 5, 'smart phone', 1),
('P003', 'Dell A10', 30, 15, 'laptop', 1),
('P004', 'Iphone 17 promax', 5, 7, 'smart phone', 1),
('P005', 'Asus S10', 25, 12, 'laptop', 1),
('P006', 'Samsung S25 ultra', 40, 30, 'smart phone', 1),
('P007', 'MSI M15', 2, 20, 'mouse gaming', 1),
('P008', 'Dareu D5', 1, 11, 'phone', 1);
select * from products;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index pc_index on products (product_code);
create index pd_index on products (product_description);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create unique index pnpp_index on products (product_name, product_price);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where product_description = 'smart phone';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products
create view v_product as select product_code, product_name, product_price, product_status from products;
select * from v_product;
-- Tiến hành sửa đổi view
update v_product set product_name = 'Samsung s25 ultra' where product_code = 'P002';
-- Tiến hành xóa view
drop view v_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure display_all ()
begin
select * from products;
end //
delimiter ;
call display_all();
-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(
p_code varchar(50),
p_name varchar(50),
p_price int,
p_amount int,
p_description varchar(50),
p_status tinyint)
begin
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) values
(p_code, p_name, p_price, p_amount, p_description, p_status);
end //
delimiter ;
call add_product('P010', 'Samsung s23 ultra', 25, 12, 'smart phone', 1);
SHOW PROCEDURE STATUS WHERE Db = 'demo';
-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product (IN p_id int)
begin
update products set
product_amount = 25
where p_id = id;
end //
delimiter ;
call update_product(8);
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product (IN p_id int)
begin
delete from products
where p_id = id;
end //
delimiter ;
call delete_product(8);