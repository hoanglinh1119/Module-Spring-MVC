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
    <title>Gia vi</title>
</head>
<body>
<h2> Sandwich Condiments</h2>
<form id="sandwich" action="sandwich" method="post">
    <input id="lettuce" type="checkbox" name="lettuce" value="lettuce">
    <label for="lettuce" >lettuce</label>
    <input id="tomato" type="checkbox" name="tomato" value="tomato">
    <label for="tomato">tomato</label>
    <input id="mustand" type="checkbox" name="mustand" value="mustand">
    <label for="mustand">mustand</label>
    <input id="sprouts" type="checkbox" name="sprouts" value="sprouts">
    <label for="sprouts"> sprouts</label>
    <br>
    <br>
    <br>
    <input type="submit" value="save">
</form>
</body>
</html>