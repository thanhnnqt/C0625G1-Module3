<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.demo.entity.Account" %>
<%
    Account acc = (Account) session.getAttribute("account");
    if (acc == null || !"employee".equals(acc.getRole())) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<html>
<head><title>Trang nhân viên</title></head>
<body>
<h2>Xin chào, <%= acc.getUsername() %> (Nhân viên)</h2>
<p>Bạn có thể xem và quản lý dữ liệu khách hàng tại đây.</p>
<form action="../../logout" method="post">
    <button type="submit">Đăng xuất</button>
</form>
</body>
</html>
