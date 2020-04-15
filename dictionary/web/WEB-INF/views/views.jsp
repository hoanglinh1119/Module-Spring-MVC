<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 20/03/2020
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chu</title>
</head>
<body>
<div class="show">
    <form action="/translate" method="get">
        <input type="text" name="input">
        <input type="submit">
    </form>
</div>
<div class="showkq">
    <h1>Nghia: ${output}</h1>
</div>
</body>
</html>