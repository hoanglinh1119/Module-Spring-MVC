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
    <style type="text/css">
        select {
            width: 200px;
            height: 20px;
        }
    </style>
</head>
<body>
<h2>Current Local Times Around the World</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id="locale" action="worldClock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()">
        <option value="Asia/Ho_Chi_Minh">Select a city</option>
        <option value="Asia/Ho_Chi_Minh" selected>Ho Chi Minh</option>
        <option value="Singapore">Singapore</option>
        <option value="Asia/Hong_Kong">Hong Kong</option>
        <option value="Asia/Tokyo">Tokyo</option>
        <option value="Asia/Seoul">Seoul</option>
        <option value="Europe/London">London</option>
        <option value="Europe/Madrid">Madrid</option>
        <option value="America/New_York">New York</option>
        <option value="Australia/Sydney">Sydney</option>
        <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
</form>

</body>
</html>