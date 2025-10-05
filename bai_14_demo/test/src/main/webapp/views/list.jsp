<%--
  Created by IntelliJ IDEA.
  User: GAMING-PC
  Date: 02/10/2025
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<div class="container mt-4">
    <c:import url="../layout/navbar.jsp"/>
    <h1>Danh sách hợp đồng thanh lý</h1>
    <form method="get" action="/liquidation-contract" class="row g-2 mb-3">
        <input type="hidden" name="action" value="search"/>
        <div class="col-md-4">
            <input type="text" name="liquidation_contract_id" class="form-control" placeholder="Nhập id hợp đồng thanh lý"
                   value="${param.liquidationContractId}"/>
        </div>
        <div class="col-md-3">
            <select name="productId" class="form-control">
                <option value="">-- Tất cả danh mục --</option>
                <c:forEach var="p" items="${productList}">
                    <option value="${p.productId}" ${param.productId == p.productId ? 'selected' : ''}>
                            ${p.productName}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-2">
            <button type="submit" class="btn btn-primary w-100">Tìm kiếm</button>
        </div>
        <div class="col-md-3">
            <a href="/liquidation-contract?action=create" class="btn btn-success w-100">Thêm hợp đồng thanh lý</a>
        </div>
    </form>
    <table id="tableContract" class="table table-dark table-striped">
        <thead>
        <tr>
            <th>STT</th>
            <th>Id hợp đồng</th>
            <th>Ngày tạo hợp đồng</th>
            <th>Giá trị hợp đồng</th>
<%--            <th>Tên sản phẩm</th>--%>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="liquidationContract" items="${contracts}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${liquidationContract.liquidationContractId}</td>
                <td>${liquidationContract.liquidationDate}</td>
                <td>${liquidationContract.liquidationPrice}</td>
<%--                <td>${liquidationContract.productId}</td>--%>
                <td>
                    <a href="/liquidation-contract?action=edit&liquidation_contract_id=${liquidationContract.liquidationContractId}"
                       class="btn btn-primary btn-sm">Sửa</a>
                    <button type="button" class="btn btn-danger btn-sm"
                            data-bs-toggle="modal"
                            data-bs-target="#deleteModal${liquidationContract.liquidationContractId}">
                        Xóa
                    </button>

                    <!-- Modal xác nhận -->
                    <div class="modal fade" id="deleteModal${liquidationContract.liquidationContractId}" tabindex="-1"
                         aria-labelledby="deleteModalLabel${liquidationContract.liquidationContractId}" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" style="color: black"
                                        id="deleteModalLabel${liquidationContract.liquidationContractId}">
                                        Xác nhận xóa sản phẩm
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body text-color-black" style="color: black">
                                    Bạn có chắc muốn xóa <strong>${liquidationContract.liquidationContractId}</strong> không?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                        Hủy
                                    </button>
                                    <!-- Nút Xóa thật sự -->
                                    <a href="/products?action=delete&liquidation_contract_id=${liquidationContract.liquidationContractId}"
                                       class="btn btn-danger">
                                        Xóa
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableContract').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
