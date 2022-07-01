<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/16
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<button id = 'input'>to Input</button>
<button id = 'outputList'>to Output List</button>
<button id = "output">to Output</button>

<script>
    document.getElementById("input").onclick = function () {
        location.href = "/input";
    }
    document.getElementById("outputList").onclick = function () {
        location.href = "/outputList";
    }
    document.querySelector("#output").onclick = function () {
        location.href = "/output";
    }

</script>
</body>
</html>
