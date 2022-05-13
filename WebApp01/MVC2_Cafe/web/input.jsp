<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/input.cafe" method="post">
        <div class="inputContainer">
            <input type="text" name = product_name placeholder="product_name">
            <input type="number" name="product_price" placeholder="product_price">
        </div>
        <div class="buttonContainer">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
