<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/17
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    .container {
        width: 1200px;
        height: 800px;
    }

    .container * {
        border: solid black 1px;
        box-sizing: border-box;
    }

    .header {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 10%;
    }

    .contentContainer .contentContainer1 {
        height: 80%;
    }

    .contentContainer .contentContainer1 .contentContainer1_1 {
        display: flex;
    }

    .contentContainer .contentContainer1 .contentContainer1_2 {
        display: flex;
    }

    .contentContainer .contentContainer1 .contentContainer1_3 {
        display: flex;
        height: 80%
    }

    .contentContainer .contentContainer1 .contentContainer1_title {
        flex-basis: 10%;
    }

    .contentContainer .contentContainer1 .contentContainer1_content {
        flex-basis: 90%;
    }

    .contentContainer .contentContainer1 .contentContainer1_content_1 {
        flex-basis: 30%;
    }

    .contentContainer .contentContainer1 .contentContainer1_content_2 {
        flex-basis: 50%;
    }

    .contentContainer .contentContainer1 .contentContainer1_3 .contentContainer1_content {
        height: 400px;
    }

    .contentContainer2_title {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .contentContainer2_content {
        display: flex;
        justify-content: space-around;
    }

    #title {
        width: 95%;
    }

    #content {
        width: 95%;
        height: 95%;
        resize: none;
    }

    #comment {
        width: 70%;
    }

    #commentBtn {
        border: none;
        background-color: gold;
        color: white;
        width: 70px;
        height: 25px;
    }

    .footer {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 20px;
        height: 10%;

    }

    #backBtn {
        border: none;
        background-color: silver;
        color: white;
        width: 70px;
        height: 25px;
    }

    #modifyBtn {
        border: none;
        background-color: gold;
        color: white;
        width: 70px;
        height: 25px;
    }

    #deleteBtn {
        border: none;
        background-color: red;
        color: white;
        width: 70px;
        height: 25px;
    }

    .hiddenContainer {
        display: none;
    }

</style>
<body>
<div class="container">
    <form action="/modify.board" method="post">
        <div class="header"><h3>????????????</h3></div>
        <div class="contentContainer">
            <div class="contentContainer1">
                <div class="contentContainer1_1">
                    <div class="contentContainer1_title">??????</div>
                    <div class="contentContainer1_content">
                        <input type="text" name="title" id="title" value="${boardDTO.getTitle()}">
                    </div>
                </div>
                <div class="contentContainer1_2">
                    <div class="contentContainer1_title"> ?????????</div>
                    <div class="contentContainer1_content_1"> ${boardDTO.getNickname()} </div>
                    <div class="contentContainer1_title"> ?????????</div>
                    <div class="contentContainer1_content_2"> ${boardDTO.getWritten_date()} </div>
                    <div class="hiddenContainer"><input type="number" name="no" id="no" value="${boardDTO.getNo()}">
                    </div>
                </div>
                <div class="contentContainer1_3">
                    <div class="contentContainer1_title">??????</div>
                    <div class="contentContainer1_content">
                        <textarea name="content" id="content">${boardDTO.getContent()}</textarea>
                    </div>
                </div>
            </div>
            <div class="contentContainer2">
                <div class="contentContainer2_title">
                    <h4>??????</h4>
                </div>
                <div class="contentContainer2_content">
                    <input type="text" name="comment" id="comment" readonly>
                    <button type="button" id="commentBtn"> ?????? ??????</button>
                </div>
            </div>
        </div>
        <div class="footer">
            <button id="backBtn" type="button">????????????</button>
            <button id="modifyBtn" type="submit">??????</button>
        </div>
    </form>
</div>
<script>
    document.getElementById("backBtn").onclick = function () {
        location.href = "/detailView.board?no=${boardDTO.getNo()}";
    }
</script>
</body>
</html>
