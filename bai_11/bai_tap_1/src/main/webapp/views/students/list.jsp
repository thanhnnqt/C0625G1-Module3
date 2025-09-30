<%--
  Created by IntelliJ IDEA.
  User: GAMING-PC
  Date: 30/09/2025
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<a href="/students?action=add"> Thêm mới </a>
<h1>Danh sách sinh viên</h1>
<table class="table table-dark table-striped">
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Điểm</th>
        <th>Lớp học</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.score}</td>
            <td>${student.classId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
