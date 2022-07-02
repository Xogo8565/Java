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
<button id = 'output1'>output1</button>
<button id = "output2">output2</button>
<button id = "output3">output3</button>

<script>
    document.getElementById("input").onclick = function () {
        location.href = "/input";
    }
    document.getElementById("output1").onclick = function () {
        location.href = "/output";
    }
    document.querySelector("#output2").onclick = function () {
        location.href = "/output2";
    }
    document.querySelector("#output3").onclick = function () {
        location.href = "/output3";
    }

</script>
</body>
</html>
