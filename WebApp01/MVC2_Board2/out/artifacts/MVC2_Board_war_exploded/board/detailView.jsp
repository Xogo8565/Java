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

        .modifyPostBtn {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: gold;
        }
        .modifyReplyBtn {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: gold;
        }
        .modifyReplyCancleBtn {
            border: none;
            border-radius: 5px;
            color: white;
            background-color: silver;
            display: none;
        }

        .modifyReplyCompleteBtn {
            display: none;
            border: none;
            border-radius: 5px;
            color: white;
            background-color: gold;
        }

        .replyContainer {
            height: 50%;
        }

        .replyHeader {
            display: flex;
            justify-content: center;
            height: 20%;
        }

        .replyContent {
            overflow-y: auto;
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
                <c:if test="${not empty arrayList}">
                    <c:forEach items="${arrayList}" var="replyDTO">
                        <div class="reply">
                            <div class="replyDiv1">
                                <span class="reply_nickname">${replyDTO.nickname}</span>
                                <span class="reply_date">${replyDTO.written_date}</span>
                            </div>
                            <div class="replyDiv2">
                                <input type="text" value="${replyDTO.content}" class="modifyReplyInput" readonly>
                                <c:if test="${loginSession.id eq replyDTO.id}">
                                    <div class="replyBtnContainer">
                                        <button type="button" class="modifyReplyCompleteBtn"
                                                value="${replyDTO.reply_no}">수정완료
                                        </button>
                                        <button type="button" class="modifyReplyCancleBtn" value="${replyDTO.reply_no}">
                                            취소
                                        </button>
                                        <button type="button" class="modifyReplyBtn" value="${replyDTO.reply_no}">수정하기
                                        </button>
                                        <button type="button" class="deleteReplyBtn" value="${replyDTO.reply_no}">삭제하기
                                        </button>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty arrayList}">
                    <span>표시할 댓글이 없습니다.</span>

                </c:if>
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
        let check = confirm("삭제하시겠습니까?");
        if (check) {
            let deleteForm = $("<form action='/delete.board' method='post'></form>")
            deleteForm.append($("<input>", {type: "hidden", value: "${boardDTO.no}", name: "no"}));
            $("body").append(deleteForm);
            deleteForm.submit();
        }
    });
    $(".modifyPostBtn").on("click", function () {
        location.href = "/toModify.board?no=${boardDTO.no}";
    });
    $("#backBtn").on("click", function () {
        location.href = "/toBoard.board"
    });
    $("#createReply").on("click", function () {
        let form = $("<form></form>");
        let input = $("#replyInput").val();
        if (input === "") {
            alert("댓글을 입력하세요.");
        }
        if (input !== "") {
            form.append($("<input>", {type: "hidden", name: "id", val: "${loginSession.id}"}));
            form.append($("<input>", {type: "hidden", name: "nickname", val: "${loginSession.nickname}"}));
            form.append($("<input>", {type: "hidden", name: "reply", val: input}));
            form.append($("<input>", {type: "hidden", name: "board_no", val: "${boardDTO.no}"}));
            $("body").append(form);
            let data = form.serialize();
            $.ajax({
                url: "/insert.reply",
                data: data,
                type: "post",
                success: function (data) {
                    if (data === "fail") {
                        alert("댓글 등록에 실패했습니다.");
                    }
                    if (data === "success") {
                        showReply();
                    }
                },
                error: function (e) {
                    console.log(e)
                }
            });
            $("#replyInput").val("");
        }
    });

    function showReply() {
        $.ajax({
            url: "/show.reply?board_no=" +${boardDTO.no},
            dataType: "json",
            success: function (data) {
                $(".replyContent").empty();
                $.each(data, function (index, item) {
                    let reply = $("<div class = 'reply'></div>");
                    let replyDiv1 = $("<div class = 'replyDiv1'></div>");
                    let replyDiv2 = $("<div class = 'replyDiv2'></div>");
                    let replyBtnContainer = $("<div class = 'replyBtnContainer'></div>");
                    let id = "${loginSession.id}";

                    replyDiv1.append("<span class = 'reply_nickname'>" + item.nickname + "</span>");
                    replyDiv1.append("<span class = 'reply_date'>" + item.written_date + "</span>");
                    if (item.id==="${loginSession.id}") {
                        replyBtnContainer.append($("<button>").addClass("modifyReplyCompleteBtn").html("수정완료").val(item.reply_no));
                        replyBtnContainer.append($("<button>").addClass("modifyReplyCancleBtn").html("취소").val(item.reply_no));
                        replyBtnContainer.append($("<button>").addClass("modifyReplyBtn").html("수정하기").val(item.reply_no));
                        replyBtnContainer.append($("<button>").addClass("deleteReplyBtn").html("삭제하기").val(item.reply_no));
                    }
                    replyDiv2.append("<input readonly type='text' class='modifyReplyInput' value = '" + item.content + "'>");
                    replyDiv2.append(replyBtnContainer);
                    reply.append(replyDiv1);
                    reply.append(replyDiv2);
                    $(".replyContent").append(reply);
                });
            },
            error: function (e) {
                console.log(e)
            }
        });
    }


    $(document).on("click", ".deleteReplyBtn", function () {
        let check = confirm("삭제하시겠습니까?");
        if (check) {
            let deleteForm = $("<form></form>");
            let reply_no = $(this).val();
            deleteForm.append($("<input>", {type: "hidden", name: "reply_no", value: reply_no}));
            $("body").append(deleteForm);
            let data = deleteForm.serialize();
            $.ajax({
                url: "/delete.reply",
                data: data,
                type: "post",
                success: function (data) {
                    if (data === "fail") {
                        alert("댓글 삭제를 실패했습니다.");
                    }
                    if (data === "success") {
                        showReply();
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    });
    $(document).on("click", ".modifyReplyBtn", function () {
        let prevVal = $(this).parent().siblings(".modifyReplyInput").val();

        $(this).parent().siblings(".modifyReplyInput").attr("readonly", false);
        $(this).siblings(".deleteReplyBtn").css("display", "none");
        $(this).css("display", "none");
        $(this).siblings(".modifyReplyCompleteBtn").css("display", "inline-block");
        $(this).siblings(".modifyReplyCancleBtn").css("display", "inline-block");
        $(this).parent().siblings(".modifyReplyInput").focus();

        $(document).on("click", ".modifyReplyCancleBtn", function () {
            $(this).css("display","none");
            $(this).siblings(".modifyReplyCompleteBtn").css("display","none");
            $(this).siblings(".modifyReplyBtn").css("display", "inline-block");
            $(this).siblings(".deleteReplyBtn").css("display", "inline-block");
            $(this).parent().siblings(".modifyReplyInput").prop("readonly", true);
            $(this).parent().siblings(".modifyReplyInput").val(prevVal);
        });
    });
    $(document).on("click", ".modifyReplyCompleteBtn", function () {
        let modifyForm = $("<form></form>");
        let reply_no = $(this).val();
        let reply = $(this).parent().siblings(".modifyReplyInput").val();
        if (reply === "") {
            alert("댓글을 입력하세요.");
        }
        if (reply !== "") {
            modifyForm.append($("<input>", {type: "hidden", name: "reply_no", value: reply_no}));
            modifyForm.append($("<input>", {type: "hidden", name: "reply", value: reply}));
            $(".body").append(modifyForm);
            let data = modifyForm.serialize();
            $.ajax({
                url: "/modify.reply",
                type: "post",
                data: data,
                success: function (data) {
                    if (data === "fail") {
                        alert("댓글 수정에 실패했습니다.");
                    }
                    if (data === "success") {
                        showReply();
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    });



    // 만약 서버에서 응답해주는 값이 json 일수도 있고 일반 텍스트일 수 도 있으면 dataType 을 명시하지 않는다.
    // json 형식의 문자열을 data = JSON.parse(data) 함수를 통해 자바스크립트 객체 형식으로 변환할 수 있다.

</script>
</body>
</html>
