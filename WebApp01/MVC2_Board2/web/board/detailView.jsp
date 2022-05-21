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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            border: 1px solid black;
            box-sizing: border-box;
        }

        .container {
            width: 1200px;
            height: 1000px;
        }

        .header {
            display: flex;
            justify-content: center;
            height: 10%;
        }

        .postHeader_1 {
            display: flex;
        }

        .postHeader_2 {
            display: flex;
        }

        .postHeaderTitle {
            flex-basis: 10%;
            text-align: center;
        }

        .postHeaderDetail {
            flex-basis: 40%;
        }

        .contentContainer {
            height: 85%;
        }

        .postContainer {
            height: 50%;
        }

        .postContent {
            display: flex;
            height: 85%;
        }

        .postContentTitle {
            flex-basis: 10%;
            text-align: center;
        }

        .postContentDetail {
            flex-basis: 90%;
        }

        .postContentDetail textarea {
            width: 95%;
            height: 95%;
            resize: none;
        }

        .footer {
            height: 3%;
            display: flex;
            justify-content: flex-end;
        }

        #backBtn {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: silver;
        }

        button[class*="delete"] {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: RED;
        }

        button[class*="modify"] {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: gold;
        }

        .modifyReplyCompleteBtn {
            display: none;
        }

        .replyContainer {
            height: 50%;
        }

        .replyHeader {
            display: flex;
            justify-content: center;
            height: 20%;
        }

        .replyDiv1 {
            display: flex;
        }

        .reply_nickname {
            flex-basis: 15%;
        }

        .reply_date {
            flex-basis: 15%;
            align-self: flex-end;
        }

        .replyDiv2 {
            display: flex;
        }

        .replyDiv2 input {
            flex-basis: 80%;
        }

        .replyBtnContainer {
            flex-basis: 20%;
        }

        #createReply {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: gold;
        }

        .replyInputDiv {
            height: 7%;
            display: flex;
            justify-content: center;
            gap: 30px;
        }

        .replyInputDiv input {
            flex-basis: 80%;
        }

        .replyContent {
            height: 70%;
        }

        .reply_date {
            color: silver;
            font-size: 0.7em;
        }
    </style>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<body>
<div class="container">
    <div class="header"><h3>상세보기</h3></div>
    <div class="contentContainer">
        <div class="postContainer">
            <div class="postHeader">
                <div class="postHeader_1">
                    <div class="postHeaderTitle"><span>제목</span></div>
                    <div class="postHeaderDetail"><span>${boardDTO.title}</span></div>
                </div>
                <div class="postHeader_2">
                    <div class="postHeaderTitle"><span>글쓴이</span></div>
                    <div class="postHeaderDetail"><span>${boardDTO.nickname}</span></div>
                    <div class="postHeaderTitle"><span>날짜</span></div>
                    <div class="postHeaderDetail"><span>${boardDTO.written_date}</span></div>
                </div>
            </div>
            <div class="postContent">
                <div class="postContentTitle"><span>내용</span></div>
                <div class="postContentDetail"><textarea readonly>${boardDTO.content}</textarea></div>
            </div>
        </div>
        <div class="replyContainer">
            <div class="replyHeader">
                <h4> 댓글 보기</h4>
            </div>
            <div class="replyContent">
                <div class="reply">
                    <c:if test="${not empty arrayList}">
                        <c:forEach items="${arrayList}" var="replyDTO">
                            <div class="replyDiv1">
                                <span class="reply_nickname">${replyDTO.nickname}</span>
                                <span class="reply_date">${replyDTO.written_date}</span>
                            </div>
                            <div class="replyDiv2">
                                <input type="text" value="${replyDTO.content}" class="modifyReplyInput" readonly>
                                <c:if test="${loginSession.id eq replyDTO.id}">
                                    <div class="replyBtnContainer">
                                        <button type="button" class="modifyReplyCompleteBtn" value="${$replyDTO.reply_no}">
                                            수정 완료
                                        </button>
                                        <button type="button" class="modifyReplyBtn" value="${$replyDTO.reply_no}">수정하기
                                        </button>
                                        <button type="button" class="deleteReplyBtn" value="${$replyDTO.reply_no}">삭제하기
                                        </button>
                                    </div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty arrayList}">
                        <span>표시할 댓글이 없습니다.</span>
                    </c:if>
                </div>
            </div>
            <div class="replyInputDiv">
                <input type="text" id="replyInput">
                <button type="button" id="createReply">댓글 등록</button>
            </div>
        </div>
    </div>
    <div class="footer">
        <c:if test="${loginSession.id eq boardDTO.id}">
            <button type="button" class="deletePostBtn">삭제</button>
            <button type="button" class="modifyPostBtn">수정</button>
        </c:if>
        <button type="button" id="backBtn">뒤로가기</button>
    </div>
</div>
<script>
    $(".deletePostBtn").on("click", function () {
        let deleteForm = $("<form action='/delete.board' method='post'></form>")
        deleteForm.append($("<input>",{ type: "hidden", value : "${boardDTO.no}", name : "no"}));
        $("body").append(deleteForm);
        deleteForm.submit();
    })
    $(".modifyPostBtn").on("click", function () {
        location.href = "/toModify.board?no=${boardDTO.no}";
    });
    $("#backBtn").on("click", function () {
        location.href = "/toBoard.board"
    });
</script>
</body>
</html>
