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
    <title>Thêm Sinh viên</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <header class="header">
        <h1>Quản lý Sinh viên</h1>
        <nav class="nav">
            <a href="list.html" class="nav-link">Danh sách</a>
            <a href="add.html" class="nav-link active">Thêm mới</a>
        </nav>
    </header>

    <main class="main">
        <div class="page-header">
            <h2>Thêm Sinh viên mới</h2>
            <a href="list.html" class="btn btn-secondary">
                ← Quay lại
            </a>
        </div>

        <div class="form-wrapper">
            <form class="form" action="/students/add" method="post">
                <div class="form-section">
                    <h3>Thông tin cá nhân</h3>

                    <div class="form-group">
                        <label for="name" class="form-label">Họ và tên <span class="required">*</span></label>
                        <input type="text" id="name" name="name" class="form-input" placeholder="Nhập họ và tên" required>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label for="email" class="form-label">Email <span class="required">*</span></label>
                            <input type="email" id="email" name="email" class="form-input" placeholder="example@email.com" required>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="form-label">Số điện thoại</label>
                            <input type="tel" id="phone" name="phone" class="form-input" placeholder="0123456789">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="form-label">Địa chỉ</label>
                        <textarea id="address" name="address" class="form-textarea" rows="3" placeholder="Nhập địa chỉ đầy đủ"></textarea>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label for="birthday" class="form-label">Ngày sinh</label>
                            <input type="date" id="birthday" name="birthday" class="form-input">
                        </div>


                    </div>
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Lưu thông tin</button>
                    <button type="reset" class="btn btn-secondary">Nhập lại</button>
                </div>
            </form>
        </div>
    </main>
</div>

</body>
</html>