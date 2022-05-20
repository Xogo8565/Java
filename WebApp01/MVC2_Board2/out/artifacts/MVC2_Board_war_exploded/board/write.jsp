<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/17
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    .container {
        width: 1200px;
        height: 400px;
    }
    .container *{
        margin: 15px;
    }

    .container .header {
        height: 10%;
        text-align: center;
    }

    .container .content {
        height: 80%;
    }

    .container .content #content1 {
        border: 1px solid black;
        height: 15%;
        display: flex;
        align-items: center;
    }

    .container .content #content1 input {
        width: 80%;
        height: 80%;
    }
    .container .content #content1 span {
        width: 15%;
        text-align: center;
    }

    .container .content #content2 {
        border: 1px solid black;
        height: 85%;
        display: flex;
        align-items: center;
    }

    .container .content #content2 textarea {
        width: 80%;
        height: 80%;
    }
    .container .content #content2 span {
        width: 15%;
        text-align: center;
    }

    .container .footer {
        height: 10%;
        display: flex;
        justify-content: center;
        gap: 10px;
    }

    .container .footer #backBtn {
        border: none;
        background-color: silver;
        color: white;
        width: 70px;
        height: 25px;
    }

    .container .footer #submitBtn {
        border: none;
        background-color: gold;
        color: white;
        width: 70px;
        height: 25px;
    }
</style>
<body>
<div class="container">
    <form action="/write.board" method="post" id = "writeForm">
        <div class="header">
            <h4>글쓰기</h4>
        </div>
        <div class="content">
            <div id="content1">
                <span>제목</span>
                <input type="text" name="title" id="title">
            </div>
            <div id="content2">
                <span>내용</span>
                <textarea name="content" id="content"></textarea>
            </div>
        </div>
        <div class="footer">
            <button type="button" id="backBtn">뒤로가기</button>
            <button type="button" id="submitBtn">저장</button>
        </div>
    </form>
</div>
<script>
    document.getElementById("submitBtn").onclick = function () {
        let title = document.getElementById("title");
        let content = document.getElementById("content");
        if (title.value === "") {
            title.value = "제목없음";
        }
        if (content.value === "") {
            alert("내용을 입력하세요");
            content.focus();
            return
        }

        document.getElementById("writeForm").submit();
    }
    document.getElementById("backBtn").onclick = function () {
        location.href = "/toBoard.board";
    }

</script>
</body>
</html>
