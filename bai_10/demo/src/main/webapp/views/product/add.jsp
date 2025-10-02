<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
    <style>
        body {
            background-image: url('https://anviethouse.vn/wp-content/uploads/2021/06/Thiet-ke-shop-dien-thoai-1-5.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            font-family: 'Segoe UI', sans-serif;
        }
        .form-container {
            background-color: rgba(255, 255, 255, 0.95);
            border-radius: 12px;
            padding: 30px;
            margin-top: 50px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 40%;
        }
        h2 {
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<h1>Thêm mới</h1>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10 form-container">
            <h2 class="mb-4">Thêm sản phẩm mới</h2>
            <form action="/products?action=create" method="post">
                <div>
                    <label class="form-label">Tên sản phẩm</label>
                    <input name="product_name" class="form-control" required>
                </div>
                <div>
                    <label class="form-label">giá bán</label>
                    <input name="price" type="number" class="form-control" required>
                </div>
                <div>
                    <label class="form-label">Mô tả sản phẩm</label>
                    <input name="mo_ta" type="text" class="form-control" required>
                </div>
                <div>
                    <label class="form-label">Nhà sản xuất</label>
                    <input name="hang_san_xuat" type="text"  class="form-control" required>
                </div>
                <div>
                    <label class="form-label">Số lượng</label>
                    <input name="so_luong" type="text"  class="form-control" required>
                </div>
                <br>
                <div>
                    <select name="category_id">
                        <option>------------------------Chọn loại sản phẩm------------------------</option>
                        <c:forEach items="${categories}" var="cate">
                            <option value="${cate.id}">${cate.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12 text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Thêm sản phẩm</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>