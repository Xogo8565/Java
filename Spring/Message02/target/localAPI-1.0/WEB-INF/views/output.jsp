<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .complete {
            display: none;
        }

        .cancel {
            display: none;
        }
    </style>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>No</th>
        <th>닉네임</th>
        <th>메시지</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${messageDTO.no}</td>
        <td>${messageDTO.nickname}</td>
        <td><input type="text" readonly value="${messageDTO.message}"></td>
    </tr>
    </tbody>
</table>
<script>

</script>
</body>
</html>
