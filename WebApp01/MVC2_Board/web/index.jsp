<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        .container1 {
            width: 300px;
            height: 200px;
            border: 1px solid black;
        }

        .container1 * {
            margin: 3px;
        }

        .container1 .title {
            font-weight: bold;
            font-size: 1.4em;
            text-align: center;
        }

        .container1 .content {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container1 .content #idInput {
            width: 80%;
            height: 20px;
        }

        .container1 .content #pwInput {
            width: 80%;
            height: 20px;
        }

        .container1 .remember input {
            margin: 10px;
        }

        .container1 .footer {
            display: flex;
            justify-content: center;
        }

        .container1 .footer #loginBtn {
            border-radius: 10px;
            border: none;
            background-color: gold;
            color: white;
        }

        .container1 .footer #signUpBtn {
            border-radius: 10px;
            border: gold solid 3px;
            background-color: white;
        }

        .container2 {
            width: 500px;
            height: 100px;
            border: 1px solid black;
        }

        .container2 .head {
            border-bottom: 2px solid black;
        }

        .container2 .select {
            display: flex;
            justify-content: space-around;
        }

        .container2 .select button {
            border: none;
            background-color: gold;
            color: white;
            width: 70px;
            height: 25px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<c:choose>
    <c:when test="${not empty loginSession}">
        <c:if test="${rs eq true}">
            <script>
                alert("로그인 성공");
            </script>
        </c:if>
        <div class="container2">
            <div class="head"><h3>${loginSession.nickname} 님 환영합니다</h3></div>
            <div class="select">
                <button type="button" id="logoutBtn">로그아웃</button>
                <button type="button" id="myPageBtn">마이페이지</button>
                <button type="button" id="boardBtn">게시판</button>
                <button type="button" id="resignBtn">회원탈퇴</button>
            </div>
        </div>
        <script>
            document.getElementById("logoutBtn").onclick = function () {
                location.href = "/logout.member";
            }
            document.getElementById("myPageBtn").onclick = function () {
                location.href = "/myPage.member";
            }
            document.getElementById("resignBtn").onclick = function () {
                let resign = confirm("정말로 탈퇴하시겠습니까?");
                if(resign) {
                    location.href = "/resign.member";
                }
            }
            document.getElementById("boardBtn").onclick = function () {
                location.href = "/toBoard.board"
            }
        </script>
    </c:when>
    <c:otherwise>
        <div class="container1">
            <div class="title">
                Board
            </div>
            <form action="/login.member" method="post" id="form">
                <div class="content">
                    <input type="text" placeholder="id" name="id" id="idInput"><br>
                    <input type="password" placeholder="pw" name="pw" id="pwInput"><br>
                    <div class="remember"><input type="checkbox"><span>아이디 기억하기</span></div>
                </div>
                <div class="footer">
                    <button type="button" id='loginBtn'>Login</button>
                    <button type="button" id='signUpBtn'>Sign up</button>
                </div>
                <c:if test="${rs eq false}">
                    <script>
                        alert("로그인 실패");
                    </script>
                </c:if>
            </form>
        </div>
        <script>
            document.getElementById("signUpBtn").onclick = function () {
                location.href = "/toSignUp.member"
            }
            document.getElementById("loginBtn").onclick = function () {
                if (document.getElementById("idInput").value === "" || document.getElementById("pwInput").value === "") {
                    alert("아이디 혹은 비밀번호를 정확히 입력하세요");
                    return;
                }
                document.getElementById("form").submit();
            }
        </script>
    </c:otherwise>
</c:choose>
</body>
</html>
