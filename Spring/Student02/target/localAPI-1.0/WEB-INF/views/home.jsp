<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/16
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id = "input">Input</button>
<button id = "output">Output</button>

<script>
  document.getElementById("input").onclick = () => {
    location.href = "/input";
  }
  document.getElementById("output").onclick = () => {
    location.href = "/output";
  }
</script>
</body>
</html>
