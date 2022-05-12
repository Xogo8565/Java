<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/12
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/Input.post" method="post">
        <div class="inputContainer">
            <input type="text" name='id' placeholder="id">
            <textarea name="msg" placeholder="msg"> </textarea>
        </div>
        <div><button type="submit">Submit</button></div>
    </form>
</div>

</body>
</html>
