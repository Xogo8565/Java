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
<button id = "output2">Output2</button>

<script>
  document.getElementById("input").onclick = () => {
    location.href = "/toInput.stu";
  }
  document.getElementById("output").onclick = () => {
    location.href = "/toOutput.stu";
  }
  document.getElementById("output2").onclick = () => {
      location.href = "/toOutput.stu2";
  }
</script>
</body>
</html>
