<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/23
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        box-sizing: border-box;
    }
    .header {
        display: flex;
        justify-content: flex-end;
    }

    .content {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .board {
        width: 100%;
        height: 90%;
    }
    .board_li {
        height: 90%;
        display: flex;
        justify-content: space-around;
    }
    .board_ul:last-child {
        border-bottom: 1px solid silver;
    }
    .board_head {
        display: flex;
        justify-content: space-around;
        border-bottom: 1px solid black;
    }

    .board_footer {
        display: flex;
        justify-content: flex-end;
    }

    #logout {
        color: white;
        background-color: red;
        border-radius: 10px;
        border: silver;
    }

    #logout:hover {
       background-color: #ec6464;
    }

    #write {
        color: white;
        background-color: gold;
        border-radius: 10px;
        border: silver;
    }
    #write:hover {
        color: white;
        background-color: #ffeb89;
        border-radius: 10px;
        border: silver;
    }



    .pagination ul {
        list-style: none;
        display: flex;
        justify-content: center;
        gap : 20px;
    }
</style>
<body>
<div class="container">
    <div class="header">
        <button id="logout">로그아웃</button>
    </div>
    <div class="content">
        <div class="title">게시판</div>
        <div class="board">
            <div class="board_head">
                <span>글 번호</span> <span>제목</span> <span> 글쓴이</span> <span>날짜</span> <span>조회수</span>
            </div>
            <div class="board_ul">
                <c:if test="${empty board}">
                    등록된 게시글이 없습니다.
                </c:if>
                <c:if test="${not empty board}">
                    <c:forEach items="${board}" var="i">
                        <div class="board_li">
                            <span>${i.seq_board}</span>
                            <span><a href="/board/detail?seq_board=${i.seq_board}">${i.title}</a></span>
                            <span>${i.writer_nickname}</span>
                            <span>${i.date}</span>
                            <span>${i.view_count}</span>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            <div class="pagination">
                <ul>
                    <li class="prev"><a href="/board/toBoard?curPage=${page.naviStrat-1}">prev</a></li>
                    <c:forEach var="num" step="1" begin="${page.naviStart}" end ="${page.naviEnd}">
                        <li class="page"><a href="/board/toBoard?curPage=${num}">${num}</a></li>
                    </c:forEach>
                    <li class="next"><a href="/board/toBoard?curPage=${page.naviEnd-1}">next</a></li>
                </ul>
            </div>
            <div class="board_footer">
                <button id="write">글쓰기</button>
            </div>
        </div>
    </div>
</div>
<script>
    document.querySelector("#write").addEventListener("click",()=>{
        location.href = "/board/toWrite";
    });

    document.querySelector("#logout").addEventListener("click",()=>{
        location.href = "/member/logout"
    })
</script>
</body>
</html>
