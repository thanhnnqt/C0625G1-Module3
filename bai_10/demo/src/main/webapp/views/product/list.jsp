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
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
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
    <table id="tableProduct" class="table table-dark table-striped">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên sản phẩm</th>
                <th>Giá sản phẩm (triệu VNĐ)</th>
                <th>Loại sản phẩm</th>
                <th>Hãng sản xuất</th>
                <th>Số lượng</th>
                <th>Mô tả</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.tenSanPham}</td>
                <td>${product.giaSanPham}</td>
                <td>${product.moTaSanPham}</td>
                <td>${product.hangSanXuat}</td>
                <td>${product.soLuong}</td>
                <td>${product.categoryName}</td>
                <td>
                    <a href="/products?action=edit&product_id=${product.maSanPham}"
                       class="btn btn-primary btn-sm">Sửa</a>
                    <button type="button" class="btn btn-danger btn-sm"
                            data-bs-toggle="modal"
                            data-bs-target="#deleteModal${product.maSanPham}">
                        Xóa
                    </button>

                    <!-- Modal xác nhận -->
                    <div class="modal fade" id="deleteModal${product.maSanPham}" tabindex="-1"
                         aria-labelledby="deleteModalLabel${product.maSanPham}" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" style="color: black"
                                        id="deleteModalLabel${product.maSanPham}">
                                        Xác nhận xóa sản phẩm
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body text-color-black" style="color: black">
                                    Bạn có chắc muốn xóa <strong>${product.tenSanPham}</strong> không?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                        Hủy
                                    </button>
                                    <!-- Nút Xóa thật sự -->
                                    <a href="/products?action=delete&product_id=${product.maSanPham}"
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
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
</body>
</html>
