<%--
  Created by IntelliJ IDEA.
  User: Microsoft Windows
  Date: 20/03/2020
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Time Zone</title>
</head>
<body>
<h2> Caculator</h2>
<form id="caculator" action="index" method="post">
    <input name="value1" type="text" >
    <input name="value2" type="text">
    <br>
    <input type="submit" name="select" id="addition" value="addition(+)">
    <input type="submit" name="select" id="subtraction" value="subtraction(-)">
    <input type="submit" name="select" id="multiplication" value="multiplication(*)">
    <input type="submit" name="select" id="division" value="division(/)">
    <br>
    <br>
    <br>
    <h2>Result ${select}:${result}</h2>
</form>


</body>
</html>