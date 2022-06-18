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
<button id = 'toInput'>To Input</button>
<button id = 'toOutput'>To Output</button>
<button id="toOutput2">To Output(ajax)</button>

<script>
    document.getElementById("toInput").onclick = function () {
        location.href = "/toInput";
    }
    document.getElementById("toOutput").onclick = function () {
        location.href = "/toOutput";
    }
    document.getElementById("toOutput2").onclick = function () {
        location.href = "/toOutput2";
    }
</script>
</body>
</html>
