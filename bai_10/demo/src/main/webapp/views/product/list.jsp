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
<c:import url="../layout/navbar.jsp"/>
<a href="/products?action=add"> Thêm mới </a>
<h1>Danh sách sản phẩm</h1>
<table class="table table-dark table-striped">
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm (triệu VNĐ)</th>
        <th>Loại sản phẩm</th>
        <th>Hãng sản xuất</th>
        <th>Số lượng</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.tenSanPham}</td>
            <td>${product.giaSanPham}</td>
            <td>${product.moTaSanPham}</td>
            <td>${product.hangSanXuat}</td>
            <td>${product.soLuong}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
