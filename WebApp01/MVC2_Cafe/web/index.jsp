<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <button type="button" id="toInput">ToInput</button>
  <button type="button" id="toOutput">ToOutput</button>
  <script>
    document.getElementById("toInput").onclick = function () {
      location.href = "/toInput.cafe";
    }
    document.getElementById("toOutput").onclick = function () {
      location.href = "/toOutput.cafe"
    }
  </script>
  </body>
</html>
