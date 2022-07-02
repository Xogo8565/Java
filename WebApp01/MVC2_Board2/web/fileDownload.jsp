<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/25
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <button type ="button" id = "download">다운로드</button>
  <script>
    document.getElementById("download").onclick = function () {
      location.href = "/download.fileTest";
    }
  </script>
</body>
</html>
