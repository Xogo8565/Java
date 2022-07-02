<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/16
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Output</title>
    <style>

        .hidden {
            display: none;
        }

    </style>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>Nickname</th>
        <th>message</th>
        <th>address</th>
        <th>phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="i">
        <tr>
            <td>${i.nickname}</td>
            <td>${i.message}</td>
            <td>${i.address}</td>
            <td>${i.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>

</script>
</body>
</html>
