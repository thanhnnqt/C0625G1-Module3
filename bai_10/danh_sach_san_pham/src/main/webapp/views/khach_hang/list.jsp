<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
  <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<a href="/khach-hang?action=add"> Thêm mới </a>
<h1>Danh sách khách hàng</h1>
<table class="table table-dark table-striped">
  <tr>
    <th>STT</th>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach var="khachHang" items="${khachHangList}" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${khachHang.name}</td>
      <td>${khachHang.birthDay}</td>
      <td>${khachHang.address}</td>
      <td>
        <img src="<c:url value='/${khachHang.anh}'/>"
        style="width: 120px; height: auto"
        >
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>