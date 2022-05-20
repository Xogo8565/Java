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

    .comment_container {
        padding-left: 15px;
    }

    .commentInput_container form {
        display: flex;
        justify-content: space-around;
        align-items: center;
    }

    #content {
        width: 95%;
        height: 95%;
        resize: none;
    }

    #comment {
        width: 70%;
        resize: none;
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

    .c_container_header {
        display: flex;
        justify-content: flex-start;
        gap: 20px;
        height: 30px;
    }

    .c_container1 {
        width: 85%;
        margin: 2px;
    }

    .c_container1:not(:first-child) {
        border-top: 1px solid black;
    }

    .reply_nickname {
        font-size: 1.2em;
    }

    .reply_date {
        color: silver;
        font-size: 0.8em;
    }

    #notFoundReply {
        text-align: center;
    }

    .comment {
        display: flex;
        justify-content: space-between;
    }

    .comment input {
        width: 80%;
    }

    .modifyCommentBtn {
        border: none;
        background-color: gold;
        color: white;
        width: 70px;
        height: 25px;
    }

    .deleteCommentBtn {
        border: none;
        background-color: red;
        color: white;
        width: 70px;
        height: 25px;
    }

    .replyModifyCompleteBtn {
        border: none;
        background-color: gold;
        color: white;
        width: 70px;
        height: 25px;
        display: none;
        text-align: center;
        line-height: 25px;
    }
    .c_container_btn{
        display: flex;
    }

</style>

<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<body>
<div class="container">
    <div class="header"><h3>상세보기</h3></div>
    <div class="contentContainer">
        <div class="contentContainer1">
            <div class="contentContainer1_1">
                <div class="contentContainer1_title">제목</div>
                <div class="contentContainer1_content">
                    ${boardDTO.getTitle()}
                </div>
            </div>
            <div class="contentContainer1_2">
                <div class="contentContainer1_title"> 글쓴이</div>
                <div class="contentContainer1_content_1"> ${boardDTO.getNickname()} </div>
                <div class="contentContainer1_title"> 작성일</div>
                <div class="contentContainer1_content_2"> ${boardDTO.getWritten_date()} </div>
            </div>
            <div class="contentContainer1_3">
                <div class="contentContainer1_title">내용</div>
                <div class="contentContainer1_content">
                    <textarea id="content" readonly>${boardDTO.getContent()}</textarea>
                </div>
            </div>
        </div>
        <div class="contentContainer2">
            <div class="contentContainer2_title">
                <h4>댓글</h4>
            </div>
            <div class="contentContainer2_content">
                <div class="comment_container">
                    <c:if test="${not empty arrayList}">
                        <c:forEach items="${arrayList}" var="replyDTO">
                            <div class="c_container1">
                                <div class="c_container_header">
                                    <span class="reply_nickname">${replyDTO.nickname}</span>
                                    <span class="reply_date">${replyDTO.written_date}</span>
                                </div>
                                <div class="c_container_content">
                                    <div class="comment">
                                        <input type="text" class="comment" id="comment${replyDTO.reply_no}" readonly
                                               value="${replyDTO.content}">
                                        <c:if test="${loginSession.id eq replyDTO.id}">
                                            <div class="c_container_btn">
                                                <button type="button" class="modifyCommentBtn"
                                                        value="${replyDTO.reply_no}">수정</button>
                                                <button type="button" class="deleteCommentBtn"
                                                        value="${replyDTO.reply_no}">삭제</button>
                                                <button type="button" class="replyModifyCompleteBtn"
                                                        value="${replyDTO.reply_no}">수정완료</button>
                                            </div>
                                            <script>
                                                $(".deleteCommentBtn").on("click", function () {
                                                    let deleteReplyForm = $("<form action = '/delete.reply' method = 'post'></form>");
                                                    let number = $(this).val();
                                                    deleteReplyForm.append($("<input>", {
                                                        type: "hidden",
                                                        name: "reply_no",
                                                        value: number
                                                    }));
                                                    deleteReplyForm.append($("<input>", {
                                                        type: "hidden",
                                                        name: "board_no",
                                                        id: "board_no",
                                                        value: "${boardDTO.no}"
                                                    }));
                                                    deleteReplyForm.appendTo($("body"));
                                                    deleteReplyForm.submit();
                                                });

                                                $(".modifyCommentBtn").on("click", function () {
                                                    $(this).siblings().css("display", "none");
                                                    $(this).css("display", "none");
                                                    $(this).parent().siblings("input").prop("readonly", false);
                                                    $(this).siblings(".replyModifyCompleteBtn").css("display", "block");
                                                    $(".replyModifyCompleteBtn").on("click", function () {
                                                        let modifyForm = $("<form action = '/modify.reply' method='post'></form>");
                                                        let num = $(this).val();
                                                        let input = $("#comment${replyDTO.reply_no}").val();
                                                        modifyForm.append($("<input>",{ type : "hidden", value : num , name : "reply_no"}));
                                                        modifyForm.append($("<input>",{ type : "hidden", value : "${boardDTO.no}", name : "board_no"}));
                                                        modifyForm.append($("<input>",{ type : "hidden", value :  input , name : "reply"}));
                                                        $("body").append(modifyForm);
                                                        modifyForm.submit();
                                                    });
                                                });
                                            </script>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty arrayList}">
                        <span id="notFoundReply">등록된 댓글이 없습니다.</span>
                    </c:if>
                </div>
                <div class="commentInput_container">
                    <form id="commentForm">
                        <textarea name="comment" id="comment"></textarea>
                        <button type="button" id="commentBtn"> 댓글 등록</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <button id="backBtn" type="button">뒤로가기</button>
        <c:if test="${loginSession.id eq boardDTO.id}">
            <button id="modifyBtn" type="button">수정</button>
            <button id="deleteBtn" type="button">삭제</button>
            <script>
                document.getElementById("modifyBtn").onclick = function () {
                    location.href = "/toModify.board?no=${boardDTO.no}";
                }
                document.getElementById("deleteBtn").onclick = function () {
                    let deleteConfirm = confirm("정말로 삭제하시겠습니까?");
                    if (deleteConfirm) {
                        let deleteForm = $("<form action='/delete.board' method='post' id = 'deleteForm'></form>");
                        deleteForm.append($("<input>", {
                            type: 'text',
                            name: 'no',
                            value: ${boardDTO.no},
                            id: "delete"
                        }));
                    }
                }
            </script>
        </c:if>
    </div>
</div>
<script>
    document.getElementById("backBtn").onclick = function () {
        location.href = "/toBoard.board";
    }
    document.getElementById("commentBtn").onclick = function () {
        if (document.getElementById("comment").value !== "") {
            let commentForm = $("#commentForm");
            commentForm.append($("<input>", {
                type: "hidden",
                name: "comment_id",
                id: "comment_id",
                value: "${loginSession.id}"
            }));
            commentForm.append($("<input>", {
                type: "hidden",
                name: "comment_nickname",
                id: "comment_nickname",
                value: "${loginSession.nickname}"
            }));
            commentForm.append($("<input>", {
                type: "hidden",
                name: "board_no",
                id: "board_no",
                value: "${boardDTO.no}"
            }));

            $.ajax({
                url : "/insert.reply",
                data : { comment : $("#comment").val()},
                type : "post",
                dataType: "json",
                success : function (data) {

                }, error : function (e){
                    console.log(e);
                }
            });
        }
    }
</script>
</body>
</html>
