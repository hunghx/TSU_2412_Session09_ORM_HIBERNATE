<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 7/22/2025
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Sinh viên</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <header class="header">
        <h1>Quản lý Sinh viên</h1>
        <nav class="nav">
            <a href="list.html" class="nav-link active">Danh sách</a>
            <a href="/students/add" class="nav-link">Thêm mới</a>
        </nav>
    </header>

    <main class="main">
        <div class="page-header">
            <h2>Danh sách Sinh viên</h2>
            <a href="/students/add" class="btn btn-primary">
                <span>+</span> Thêm sinh viên
            </a>
        </div>

        <div class="search-section">
            <input type="text" class="search-input" placeholder="Tìm kiếm theo tên, email...">
            <button class="btn btn-secondary">Tìm kiếm</button>
        </div>

        <div class="table-wrapper">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Ngày sinh</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>
                            <div class="student-info">
                                <span>${student.name}</span>
                            </div>
                        </td>
                        <td>${student.email}</td>
                        <td>${student.phone}</td>
                        <td>${student.address}</td>
                        <td>${student.birthday}</td>
                        <td class="actions">
                            <a href="/students/edit/${student.id}" class="btn btn-edit">Sửa</a>
                            <a class="btn btn-delete" href="students/delete/${student.id}" onclick="return confirm('Bạn có chắc muốn xóa không??')">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
            <nav aria-label="...">
                <ul class="pagination">
                    <li class="page-item"><a href="#" class="page-link">Previous</a></li>
<%--                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
                    <c:forEach begin="1" end="${totalPage}" var="p" varStatus="loop" step="1">
                        <li class="page-item ${p==currentPage+1 ? 'active' : ''}">
                            <a class="page-link" href="?page=${p+-1}&size=${size}" aria-current="page">${p}</a>
                        </li>
                    </c:forEach>

<%--                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
    </main>
</div>

<script>
    function confirmDelete(id) {
        if (confirm('Bạn có chắc chắn muốn xóa sinh viên này?')) {
            alert('Đã xóa sinh viên ID: ' + id);
            // Trong thực tế, sẽ gọi API để xóa
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>

</body>
</html>