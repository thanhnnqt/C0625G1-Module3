<%--
  Created by IntelliJ IDEA.
  User: GAMING-PC
  Date: 30/09/2025
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<div class="container mt-4">
<c:import url="../layout/navbar.jsp"/>
<h1>Danh sách sản phẩm</h1>
<form method="get" action="/products" class="row g-2 mb-3">
    <input type="hidden" name="action" value="search"/>
    <div class="col-md-4">
        <input type="text" name="product_name" class="form-control" placeholder="Nhập tên sản phẩm"
               value="${param.productName}"/>
    </div>
    <div class="col-md-3">
        <select name="categoryId" class="form-control">
            <option value="">-- Tất cả danh mục --</option>
            <c:forEach var="c" items="${categories}">
                <option value="${c.id}" ${param.categoryId == c.id ? 'selected' : ''}>
                        ${c.name}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-2">
        <button type="submit" class="btn btn-primary w-100">Tìm kiếm</button>
    </div>
    <div class="col-md-3">
        <a href="/products?action=create" class="btn btn-success w-100">+ Thêm sản phẩm</a>
    </div>
</form>
<table class="table table-dark table-striped">
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm (triệu VNĐ)</th>
        <th>Loại sản phẩm</th>
        <th>Hãng sản xuất</th>
        <th>Số lượng</th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${products}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.tenSanPham}</td>
            <td>${product.giaSanPham}</td>
            <td>${product.moTaSanPham}</td>
            <td>${product.hangSanXuat}</td>
            <td>${product.soLuong}</td>
            <td>${product.categoryName}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
