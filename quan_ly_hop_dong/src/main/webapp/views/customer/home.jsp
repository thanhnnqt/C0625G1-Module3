<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.demo.entity.Account" %>
<%
    Account acc = (Account) session.getAttribute("account");
    if (acc == null || !"customer".equals(acc.getRole())) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<html>
<head><title>Trang khách hàng</title></head>
<body>
<h2>Xin chào, <%= acc.getUsername() %> (Khách hàng)</h2>
<p>Chào mừng bạn đến với hệ thống!</p>
<form action="../../logout" method="post">
    <button type="submit">Đăng xuất</button>
</form>
</body>
</html>
