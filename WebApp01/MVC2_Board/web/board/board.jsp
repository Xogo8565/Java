<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/17
  Time: 1:39 PM
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
        height: 400px;
    }

    .header {
        display: flex;
        justify-content: flex-end;
        height: 10%;
    }

    .header #logoutBtn {
        border-radius: 10px;
        border: none;
        background-color: red;
        color: white;
    }

    .header #writeBtn {
        border-radius: 10px;
        border: none;
        background-color: gold;
        color: white;
    }

    .content {
        height: 80%;
    }

    .content table {
        width: 100%;
    }

    .content table * {
        border: 1px solid black;
    }

    .content table .no {
        width: 5%;
    }

    .content table .title {
        width: 50%;
    }

    .content table .nickname {
        width: 10%;
    }

    .content table .written_date {
        width: 30%;
    }

    .content table .view_count {
        width: 5%;
    }

    .content table tbody {
        text-align: center;
        height: 90%;
    }

    .footer {
        display: flex;
        justify-content: flex-end;
        height: 10%;
    }

    .footer #homeBtn {
        border-radius: 10px;
        border: none;
        background-color: gold;
        color: white;
    }

</style>
<body>
<div class="container">
    <div class="header">
        <button type="button" id="logoutBtn">로그아웃</button>
        <button type="button" id="writeBtn">글쓰기</button>
    </div>
    <div class="content">
        <table>
            <thead>
            <tr>
                <th class='no'>글번호</th>
                <th class='title'>제목</th>
                <th class='nickname'>글쓴이</th>
                <th class='written_date'>작성일</th>
                <th class='view_count'>조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty arrayList}">
                <tr>
                    <td colspan="5"> 등록된 게시글이 없습니다.</td>
                </tr>
            </c:if>
            <c:if test="${not empty arrayList}">
                <c:forEach items="${arrayList}" var="boardDTO">
                    <tr>
                        <th class='no'>${boardDTO.getNo()}</th>
                        <th class='title'><a href="/detailView.board?no=${boardDTO.getNo()}">${boardDTO.getTitle()}</a>
                        </th>
                        <th class='nickname'>${boardDTO.getNickname()}</th>
                        <th class='written_date'>${boardDTO.getWritten_date()}</th>
                        <th class='view_count'>${boardDTO.getView_count()}</th>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
    <div class="footer">
        <button type="button" id="homeBtn"> 홈으로</button>
    </div>
</div>
<script>
    document.getElementById("homeBtn").onclick = function () {
        location.href = "/";
    }
    document.getElementById("logoutBtn").onclick = function () {
        location.href = "/logout.member";
    }
    document.getElementById("writeBtn").onclick = function () {
        location.href = "/toWrite.board";
    }


</script>
</body>
</html>
