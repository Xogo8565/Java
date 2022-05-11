<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/11
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--html 문서에서 하던 작업을 jsp 에서도 동일하게 가능-->
    <button type="button" id='toInput'>toInput</button>
    <button type="button" id ='toOutput'>toOutput</button>

    <script>
        document.getElementById("toInput").onclick = function () {
            location.href = "/ToInput";
        }
        document.getElementById("toOutput").onclick = function () {
            location.href = "/ToOutput";
        }
    </script>
</body>
</html>
