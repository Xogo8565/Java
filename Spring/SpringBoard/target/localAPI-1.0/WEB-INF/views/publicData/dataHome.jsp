<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/07/04
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id = "json">Json</button>
<button id = "xml">xml</button>
<button id = "ajax">ajax</button>
</body>
<script>
    document.querySelector("#json").addEventListener("click",()=>{
        location.href = "/public/json";
    });
    document.querySelector("#xml").addEventListener("click",()=>{
        location.href = "/public/xml";
    });
    document.querySelector("#ajax").addEventListener("click",()=>{
        location.href = "/public/ajax";
    });

</script>
</html>
