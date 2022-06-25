<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/22
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <button type="button" id ="getAPI">API 가져오기</button>
    <button type="button" id = "select">출력테스트</button>
  </body>
  <script>
    document.getElementById("getAPI").onclick = function () {
      location.href = "/get.api";
    }
    document.getElementById("select").onclick = function () {
      location.href = "/select.api"
    }
  </script>
</html>
