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
<form action="/students?action=add" method="post">
    ID
    <input name="id"><br>
    Tên
    <input name="name"><br>
    Giới tính <br>
    <input type="radio" name="gender" value="1">Male<br>
    <input type="radio" name="gender" value="0">Female<br>
    Điểm
    <input name="score"><br>
    Lớp
    <select name="classId">
        <option value="1">c1121g1</option>
        <option value="2">c1221g1</option>
        <option value="3">a0821i1</option>
        <option value="4">a0921i1</option>
    </select>
    <button>Lưu</button>
</form>
</body>
</html>