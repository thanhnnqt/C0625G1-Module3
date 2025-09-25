<%--
  Created by IntelliJ IDEA.
  User: GAMING-PC
  Date: 25/09/2025
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/discount" method="post">
    <h2>Tính tỷ lệ chiết khấu</h2>
    <input name="t1" value="${text}">
    <input name="n1" value="${num1}">
    <input name="n2" value="${num2}">
    <button>Discount</button>
</form>
<h3>Kêt quả: ${discount}</h3>
</body>
</html>
