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

        #rememberID {
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
                    <div class="rememberDiv"><input type="checkbox" id = "rememberID"><span>아이디 기억하기</span></div>
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

            $(document).ready(function(){

                // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
                var key = getCookie("key");
                $("#idInput").val(key);

                if($("#idInput").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
                    $("#rememberID").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
                }

                $("#rememberID").change(function(){ // 체크박스에 변화가 있다면,
                    if($("#rememberID").is(":checked")){ // ID 저장하기 체크했을 때,
                        setCookie("key", $("#idInput").val(), 7); // 7일 동안 쿠키 보관
                    }else{ // ID 저장하기 체크 해제 시,
                        deleteCookie("key");
                    }
                });

                // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
                $("#idInput").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
                    if($("#rememberIDk").is(":checked")){ // ID 저장하기를 체크한 상태라면,
                        setCookie("key", $("#idInput").val(), 7); // 7일 동안 쿠키 보관
                    }
                });
            });

            function setCookie(cookieName, value, exdays){
                var exdate = new Date();
                exdate.setDate(exdate.getDate() + exdays);
                var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
                document.cookie = cookieName + "=" + cookieValue;
            }

            function deleteCookie(cookieName){
                var expireDate = new Date();
                expireDate.setDate(expireDate.getDate() - 1);
                document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
            }

            function getCookie(cookieName) {
                cookieName = cookieName + '=';
                var cookieData = document.cookie;
                var start = cookieData.indexOf(cookieName);
                var cookieValue = '';
                if(start != -1){
                    start += cookieName.length;
                    var end = cookieData.indexOf(';', start);
                    if(end == -1)end = cookieData.length;
                    cookieValue = cookieData.substring(start, end);
                }
                return unescape(cookieValue);
            }
            
        </script>
    </c:otherwise>
</c:choose>
</body>
</html>
