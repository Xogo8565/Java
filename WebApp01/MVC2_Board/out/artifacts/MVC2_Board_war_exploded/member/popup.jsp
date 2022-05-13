<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .container {
        width: 400px;
        height: 150px;
    }

    .container * {
        margin: 5px;
    }

    .title {
        text-align: center;
        font-weight: bold;
        font-size: 1.2em;
        height: 20%
    }

    .content1 {
        display: flex;
        height: 30%;
        justify-content: center;
        margin-bottom: 15px;
    }

    .content1 #id {
        flex-basis: 250px;
    }

    .content1 #checkBtn {
        flex-basis: 70px;
        border-radius: 10px;
        border: none;
        background-color: gold;
        color: white;
    }

    .content2 {
        display: flex;
        height: 30%;
    }

    .content2_title {
        flex-grow: 1;
    }

    .content2_content {
        flex-grow: 1;
    }

    .footer {
        height: 20%;
        display: flex;
        justify-content: center;
    }

    #useBtn {
        flex-basis: 60px;
        border-radius: 10px;
        border: none;
        background-color: gold;
        color: white;
    }

    #cancleBtn {
        flex-basis: 60px;
        border-radius: 10px;
        border: none;
        background-color: silver;
        color: white;
    }
</style>
<body>
<div class="container">
    <div class="title">아이디 중복 확인</div>
    <form action="/checkId.member" method="get">
        <div class="content1">
            <input type="text" id="id" name="id" placeholder="ID" value="${id}">
            <button type="submit" id="checkBtn">중복 확인</button>
        </div>
        <div class="content2">
            <div class="content2_title">
                <span>확인 결과 : </span>
                <span>
                    <c:if test="${rs eq 'true'}">
                        사용 가능한 ID 입니다.
                    </c:if>
                    <c:if test="${rs eq 'false'}">
                        사용 불가능한 ID 입니다.
                    </c:if>
            </span>
            </div>
            <div class="content2_content">
            </div>
        </div>
        <div class="footer">
            <button type="button" id='useBtn'>사용</button>
            <button type="button" id="cancleBtn">닫기</button>
        </div>
    </form>
</div>
<script>
    document.getElementById("useBtn").onclick = function () {
        // 1. 팝업창을 열어줬던 부모창의 id input 칸에 사용자가 입력한 id를 전달하는 것
        // 2. 팝업창을 닫음
        opener.document.getElementById("idInput").value = document.getElementById("id").value;
        self.close();
    }

    document.getElementById("cancleBtn").onclick = function () {
        self.close();
    }
</script>
</body>
</html>
