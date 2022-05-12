<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/12
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<button type="button" id='toInput'>toInput</button>
<button type="button" id="toOutput">toOutput</button>
<script>
    document.getElementById("toInput").onclick = function () {
        location.href = '/ToInput.post';
    }
    document.getElementById("toOutput").onclick = function () {
        location.href = '/ToOutput.post';
    }
</script>
</body>
</html>
