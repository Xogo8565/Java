<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #product_name{
        display: none;
    }
</style>
<body>
<div class="container">
    <form action="/modify.cafe" method="post">
        <div class="inputContainer">
            <input type="number" name = "product_no" id = 'product_name' value=${cafeDTO.getProduct_no()}>
            <input type="text" name = "product_name" value=${cafeDTO.getProduct_name()}>
            <input type="number" name="product_price" value=${cafeDTO.getProduct_price()}>
        </div>
        <div class="buttonContainer">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
