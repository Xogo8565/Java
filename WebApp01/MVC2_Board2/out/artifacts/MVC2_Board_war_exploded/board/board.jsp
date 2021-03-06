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

    .searchDiv {
        margin: 10px;
        display: flex;
        justify-content: flex-end;
        gap: 20px;
    }

    #search {
        width: 200px;
    }

    #searchBtn {
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
    .pagination {
        display: flex;
        justify-content: center;
        gap : 10px;
        list-style-type: none;
    }
    .page_item{
        flex-basis : 30px
    }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<body>
<div class="container">
    <div class="header">
        <button type="button" id="logoutBtn">????????????</button>
        <button type="button" id="writeBtn">?????????</button>
    </div>
    <div class="searchDiv">
        <form>
            <input type="text" name="search" id="search">
            <button type="button" id="searchBtn">??????</button>
        </form>
    </div>
    <div class="content">
        <table>
            <thead>
            <tr>
                <th class='no'>?????????</th>
                <th class='title'>??????</th>
                <th class='nickname'>?????????</th>
                <th class='written_date'>?????????</th>
                <th class='view_count'>?????????</th>
            </tr>
            </thead>
            <tbody class="boardBody">
            <c:if test="${empty arrayList}">
                <tr>
                    <td colspan="5"> ????????? ???????????? ????????????.</td>
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
        <div class = "pageNation">
            <ul class="pagination">
                <c:if test="${hashMap.prevBtn eq true}">
                    <li class="page_item"><a href="/toBoard.board?curPage=${hashMap.navStart-1}">prev</a></li>
                </c:if>
                <c:forEach var="pageNum" begin="${hashMap.navStart}" end="${hashMap.navEnd}" step = "1">
                    <li class="page_item"><a href="/toBoard.board?curPage=${pageNum}">${pageNum}</a></li>
                </c:forEach>
                <c:if test="${hashMap.nextBtn eq true}">
                    <li class="page_item"><a href="/toBoard.board?curPage=${hashMap.navEnd+1}">next</a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="footer">
        <button type="button" id="homeBtn"> ?????????</button>
    </div>
</div>
<script>
    document.getElementById("searchBtn").onclick = function () {
        let search = document.getElementById("search").value;
        $.ajax({
            url : "/search.board?search="+search,
            dataType: "json",
            success : function (data) {
                // a ????????? ????????????
                // a.empty() -> a?????? ????????? ???????????? ?????? ?????? ????????? ??????
                // a.remove() -> a?????? ????????? ??????
                console.log(data);
                $(".boardBody").empty();
                console.log(data.length);
                if (data.length !== 0) {
                    for (let boardDto of data) {
                        let tr = $("<tr>");
                        let td1 = $("<td>").html(boardDto.no);
                        let anchor = $("<a>").attr("href", "/detailView.board?no="+boardDto.no).html(boardDto.title);
                        let td2 = $("<td>").append(anchor);
                        let td3 = $("<td>").html(boardDto.nickname);
                        let td4 = $("<td>").html(boardDto.written_date);
                        let td5 = $("<td>").html(boardDto.view_count);
                        tr.append(tr, td1, td2, td3, td4, td5);
                        $(".boardBody").append(tr);
                    }
                } else {
                    $(".boardBody").append("<tr><td colspan='5'>????????? ???????????? ????????????</td></tr>");
                    // let tr = $("<tr>");
                    // let td = $("<td colspan='5'>").html("????????? ???????????? ????????????.");
                    // tr.append(td);
                    // $(".boardBody").append(tr);
                }
            }, error : function (e){
                console.log(e);
            }
        });
    }
    document.getElementById("homeBtn").onclick = function () {
        location.href = "/";
    }
    document.getElementById("logoutBtn").onclick = function () {
        location.href = "/logout.member";
    }
    document.getElementById("writeBtn").onclick = function () {
        location.href = "/toWrite.board";
    }
    console.log(${hashMap.navStart} + " : " ${haspMap.navEnd})
</script>
</body>
</html>
