<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 20/03/2020
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyen doi tien te</title>
</head>
<body>
<form action="/convert1" method="get">
    <input type="text" placeholder="nhap tien USD" name="input">
    <input type="submit" style="color: blue">
</form>
<h2 style="color: red"> so tien VND: ${output}</h2>
</body>
</html>