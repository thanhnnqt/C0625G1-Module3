create database quan_ly_san_pham;
use quan_ly_san_pham;
CREATE TABLE Category (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL
);

CREATE TABLE Product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(200) NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    mo_ta varchar(200) NOT NULL,
    hang_san_xuat TEXT,
    so_luong int not null,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);
INSERT INTO Category (category_name) VALUES
('Laptop'),
('Điện thoại'),
('Máy tính bảng'),
('Phụ kiện'),
('Linh kiện PC');

INSERT INTO Product (product_name, price, mo_ta, hang_san_xuat, so_luong, category_id) VALUES
('Laptop Dell XPS 13', 28, 'Ultrabook mỏng nhẹ, pin lâu', 'Dell', 15, 1),
('Laptop Asus ROG Strix', 35, 'Laptop gaming hiệu năng cao', 'Asus', 10, 1),
('iPhone 15 Pro Max', 33, 'Điện thoại flagship Apple 2023', 'Apple', 20, 2),
('Samsung Galaxy S24 Ultra', 29, 'Điện thoại cao cấp Samsung', 'Samsung', 25, 2),
('iPad Pro 12.9 inch', 28, 'Máy tính bảng Apple màn hình lớn', 'Apple', 12, 3),
('Tai nghe Sony WH-1000XM5', 9.5, 'Tai nghe chống ồn chủ động', 'Sony', 30, 4),
('Chuột Logitech MX Master 3S', 2.5, 'Chuột không dây cao cấp', 'Logitech', 25, 4),
('RAM Kingston Fury 16GB DDR5', 1.8, 'RAM DDR5 cho PC gaming', 'Kingston', 50, 5),
('SSD Samsung 1TB NVMe', 2.5, 'Ổ cứng SSD tốc độ cao NVMe', 'Samsung', 40, 5);


select * from category;
select * from product;
select * from product p join category c on p.category_id = c.category_id;
select p.*, c.category_name from product p join category c on p.category_id = c.category_id where p.product_name like "%%" and c.category_id = 2;
select p.product_id, p.product_name, p.price, p.mo_ta, p.hang_san_xuat, p.so_luong, c.category_name AS categoryName from product p join category c on p.category_id = c.category_id;
SELECT p.product_id, p.product_name, p.price, p.mo_ta, p.hang_san_xuat, p.so_luong, c.category_name 
AS categoryName FROM product p JOIN category c ON p.category_id = c.category_id WHERE 1=1  and p.product_name like '%samsung%' and c.category_id = 2;
delete from product where product_id = 17;
SELECT product_id, product_name, price, mo_ta, hang_san_xuat, so_luong, category_id FROM product WHERE category_id = 4;
UPDATE product SET product_name = "Thành", price = 50, mo_ta = "Không có gì", hang_san_xuat = "Không ai cả", so_luong = 55, category_id = 2 WHERE product_id = 19;