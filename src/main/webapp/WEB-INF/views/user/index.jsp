<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 8/1/2025
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--Spring form--%>
<form:form modelAttribute="user" action="/add-user" method="post">
    <%--    thng tin của user  --%>
    <form:label path="fullName">Tên người dùng :</form:label>
    <form:input path="fullName"/>
    <form:errors path="fullName" cssStyle="color: red" element="p"/>
    <br/>
    <form:label path="dateOfBirth" >Ngày sinh</form:label>
    <form:input type="date" path="dateOfBirth" />
    <form:errors path="dateOfBirth" cssStyle="color: red" element="p"/>
    <br/>
    <form:label path="email" >Email : </form:label>
    <form:input type="email" path="email" />
    <form:errors path="email" cssStyle="color: red" element="p"/>
    <br/>
    <form:label path="phoneNumber" >Số điện thoại :</form:label>
    <form:input path="phoneNumber" />
    <form:errors path="phoneNumber" cssStyle="color: red" element="p"/>
    <br/>
    <button type="submit">Gửi</button>
</form:form>
</body>
</html>
