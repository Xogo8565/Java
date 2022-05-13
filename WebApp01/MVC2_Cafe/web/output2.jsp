<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            width: 500px;

        }

        .resultHead {
            display: flex;
        }

        .resultHead div {
            flex-grow: 1;
        }

        .result {
            display: flex;
        }

        .result div {
            flex-grow: 1;
        }
    </style>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="resultContainer">
        <div class="resultHead">
            <div>번호</div>
            <div>이름</div>
            <div>가격</div>
            <div></div>
        </div>
        <div class="resultContent">
            <c:choose>
                <c:when test="${not empty cafeDTO}">
                    <div class="result">
                        <div>${cafeDTO.getProduct_no()}</div>
                        <div>${cafeDTO.getProduct_name()}</div>
                        <div>${cafeDTO.getProduct_price()}</div>
                        <div>
                            <button type="button" class="modifyBtn" value=${cafeDTO.getProduct_no()}>modify</button>
                            <button type="button" class="deleteBtn" value=${cafeDTO.getProduct_no()}>delete</button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div>표시할 항목이 없습니다.</div>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="selectionContainer">
            <form action="/search.cafe" method="get">
                <input type="text" name="product_name" placeholder="product_name">
                <button type="submit">Search</button>
                <button type="button" id = "searchAllBtn">SearchAll</button>
            </form>
        </div>
    </div>
</div>
<script>
    $(".deleteBtn").on("click", function (){
        let form = $("<form action='/delete.cafe' method='post'></form>");
        form.append($("<input>", {type : 'number', name : 'product_no', value : $(this).val()}));
        $("body").append(form);
        $(form).css("display", "none");
        form.submit();
    });
    $(".modifyBtn").on("click", function (){
        location.href = "/toModify.cafe?product_no=" + $(this).val();
    });
    document.getElementById("searchAllBtn").onclick = function () {
        location.href = "toOutput.cafe";
    }
</script>
</body>
</html>
