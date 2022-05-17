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
    .container{
        width: 1200px;
        height: 800px;
    }
    .container * {
        border: 1px solid black;
    }
    .header {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .contentContainer .contentContainer1 {
        height: 80%;
    }
    .contentContainer .contentContainer1 .contentContainer1_1{
        display: flex;
    }
    .contentContainer .contentContainer1 .contentContainer1_2{
        display: flex;
    }
    .contentContainer .contentContainer1 .contentContainer1_3{
        display: flex;
    }
    .contentContainer .contentContainer1 .contentContainer1_title{
        flex-basis: 10%;
    }
    .contentContainer .contentContainer1 .contentContainer1_content{
        flex-basis: 90%;
    }
    .contentContainer .contentContainer1 .contentContainer1_content_1{
        flex-basis: 30%;
    }
    .contentContainer .contentContainer1 .contentContainer1_content_2{
        flex-basis: 50%;
    }
    .contentContainer .contentContainer1 .contentContainer1_3  .contentContainer1_content{
        height: 600px;
    }
    #title {
        width: 90%;
    }
    #content {
        width: 90%;
        height: 90%;
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
    #comment {
        width: 70% ;
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
        gap: 20px;
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


</style>
<body>
    <div class="container">
        <form action="" method="post" id="modifyForm">
            <div class="header"><h3>상세보기</h3></div>
            <div class="contentContainer">
                <div class="contentContainer1">
                    <div class="contentContainer1_1">
                        <div class="contentContainer1_title">제목</div>
                        <div class="contentContainer1_content">
                            <input type="text" name = "title" id="title" value="${boardDTO.getTitle()}" readonly>
                        </div>
                    </div>
                    <div class="contentContainer1_2">
                        <div class="contentContainer1_title"> 글쓴이 </div>
                        <div class="contentContainer1_content_1"> ${boardDTO.getNickname()} </div>
                        <div class="contentContainer1_title"> 작성일 </div>
                        <div class="contentContainer1_content_2"> ${boardDTO.getWritten_date()} </div>
                    </div>
                    <div class="contentContainer1_3">
                        <div class="contentContainer1_title">내용</div>
                        <div class="contentContainer1_content">
                        <textarea name="content" id="content" readonly>
                            ${boardDTO.getContent()}
                        </textarea>
                        </div>
                    </div>
                </div>
                <div class="contentContainer2">
                    <div class="contentContainer2_title">
                        <h4>댓글</h4>
                    </div>
                    <div class="contentContainer2_content">
                        <input type="text" name = "comment" id = "comment">
                        <button type="button" id = "commentBtn"> 댓글 등록 </button>
                    </div>
                </div>
            </div>
            <div class="footer">
                <button id = "backBtn" type="button">뒤로가기</button>
                <button id = "modifyBtn" type="button">수정</button>
            </div>
        </form>
    </div>
    <script>
        document.getElementById("modifyBtn").onclick = function () {
            location.href = "/toBoard.board";
        }
    </script>
</body>
</html>
