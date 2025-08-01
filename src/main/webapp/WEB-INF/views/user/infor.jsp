<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 8/1/2025
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>Tên : ${dto.fullName} </li>
    <li>Ngày sinh : ${dto.dateOfBirth}</li>
    <li>Email :${dto.email} </li>
    <li>Số điện thoai : ${dto.phoneNumber}</li>
    <img src="${dto.avatarUrl}" alt=""/>
</ul>
</body>
</html>
