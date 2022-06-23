<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/20
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    * {
        box-sizing: border-box;
    }

    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 500px;
        width: 1000px;
    }

    .header {
        height: 20%;
    }

    .content {
        height: 80%;
    }

    .content input {
        width: 100%;
    }

    .rememberDiv {
        display: flex;
        gap: 5px;
    }

    #remember {
        flex-basis: 10px;
    }

    .rememberDiv span {
        flex-basis: 120px;
    }

    .buttonDiv {
        display: flex;
        justify-content: center;
        gap: 10px;
    }

    #login {
        background-color: gold;
        color: white;
        border-radius: 10px;
        border: none;
    }

    #signup {
        background-color: black;
        color: white;
        border-radius: 10px;
        border: none;
    }

    input {
        margin: 15px;
    }

</style>
<body>
<div class="container">
    <div class="header"><h3>로그인</h3></div>
    <div class="content">
        <form id ="loginForm" method="get" action="/member/login">
            <label for="id"> ID
                <input type="text" id="id" name="id">
            </label>
            <label for="pw"> PW
                <input type="password" id="pw" name="pw">
            </label>
            <div class="rememberDiv">
                <input type="checkbox" id="remember"> <span>Remember ID</span>
            </div>
            <div class="buttonDiv">
                <button type="submit" id="login">로그인</button>
                <button type="button" id="signup">회원가입</button>
            </div>
        </form>
    </div>
</div>
<script>
    document.querySelector("#signup").addEventListener("click", () => {
        console.log("A");
        location.href = "/member/toSignup"
    })

    document.querySelector("#login").addEventListener("submit", (event)=>{
        if(document.querySelector("#id").value===""　||　document.querySelector("#pw").value===""){
            event.preventDefault();
            alert("아이디 혹은 비밀번호를 입력해주세요")
        }
    });

    let result = "${loginResult}";
    if(result === "false"){
        alert("아이디 혹은 비밀번호를 잘못 입력하셨습니다");
    }

</script>
</body>
</html>
