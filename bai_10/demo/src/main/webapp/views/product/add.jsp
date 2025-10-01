<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<h1>Thêm mới</h1>
<form action="/products?action=add" method="post">
    Tên sản phẩm
    <input name="tenSanPham"><br>
    Giá bán
    <input name="giaSanPham">
    Loại sản phẩm
    <input name="moTaSanPham"><br>
    Hãng sản xuất
    <input name="hangSanXuat"><br>
    Số lượng
    <input name="soLuong"><br>
    Category
    <select name="cId">
        <c:forEach items="${categoryList}" var="cate">
            <option value="${cate.id}">${cate.name}</option>
        </c:forEach>
    </select>
    <button>Lưu</button>
</form>
</body>
</html>