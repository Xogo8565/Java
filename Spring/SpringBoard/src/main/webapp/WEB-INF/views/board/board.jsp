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

    a {
        text-decoration: none;
        color: black;
    }

    .board_head:first-child, .board_head:last-child, .board_li:first-child, .board_li:last-child {
        flex-basis: 15px;
    }

    .board_head span:nth-child(2), .board_li span:nth-child(2) {
        flex-basis: 50%;
        overflow: hidden;
        display: block;
        text-overflow: ellipsis;
        white-space: nowrap;
        text-align: left;
    }

    .board_head span:nth-child(3), .board_li span:nth-child(3) {
        flex-basis: 70px;
        overflow: hidden;
        display: block;
        text-overflow: ellipsis;
        white-space: nowrap;
        text-align: left;
    }

    .board_head span:nth-child(4), .board_li span:nth-child(4) {
        flex-basis: 100px;
        overflow: hidden;
        display: block;
        text-overflow: ellipsis;
        white-space: nowrap;
        text-align: left;
    }

    .noResult {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
<div class="container">
    <div class="header">
        <button id="logout">????????????</button>
    </div>
    <div class="content">
        <div class="title">?????????</div>
        <div class="board">
            <div class="board_head">
                <span>??? ??????</span> <span>??????</span> <span> ?????????</span> <span>??????</span> <span>?????????</span>
            </div>
            <div class="board_ul">
                <c:if test="${empty map['board']}">
                    <div class="noResult">????????? ???????????? ????????????</div>
                </c:if>
                <c:if test="${not empty map['board']}">
                    <c:forEach items="${map['board']}" var="i">
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
                    <li class="prev"><a>prev</a></li>
                    <c:forEach var="num" step="1" begin="${map['page'].naviStart}" end ="${map['page'].naviEnd}">
                        <li class="page"><a href="/board/toBoard?curPage=${num}">${num}</a></li>
                    </c:forEach>
                    <li class="next"><a>next</a></li>
                </ul>
            </div>
            <div class="board_footer">
                <button id="write">?????????</button>
            </div>
        </div>
    </div>
</div>
<script>
    let prev = ${map['page'].prevBtn};
    let next = ${map['page'].nextBtn};
    if(prev) document.querySelector(".prev a").href = "/board/toBoard?curPage=${map['page'].naviStart-1}";
    if(next) document.querySelector(".next a").href = "/board/toBoard?curPage=${map['page'].naviEnd+1}";

    document.querySelector("#write").addEventListener("click",()=>{
        location.href = "/board/toWrite";
    });

    document.querySelector("#logout").addEventListener("click",()=>{
        location.href = "/member/logout"
    })
</script>
</body>
</html>
