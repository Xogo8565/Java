<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/16
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/input" method="post">
    <label for="name">
        <input type="text" name = 'name' placeholder="name" id="name">
    </label>
    <label for="memo">
        <input type="text" name = 'memo' placeholder="memo" id="memo">
    </label>
    <button type="submit">submit</button>
</form>
</body>
</html>
