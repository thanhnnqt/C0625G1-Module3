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
<form action="/khach-hang?action=add" method="post">
  ID
  <input name="id"><br>
  Tên
  <input name="name"><br>
  Ngày sinh
  <input name="birthDay">
  Địa chỉ
  <input name="address"><br>
  <button>Lưu</button>
</form>
</body>
</html>