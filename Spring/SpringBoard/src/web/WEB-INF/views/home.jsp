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
            <form action="">
                <label for="id"> ID
                    <input type="text" id = "id" name = "id">
                </label>
                <label for="pw"> PW
                    <input type="password" id = "pw" name = "pw">
                </label>
                <div class="rememberDiv">
                    <input type="checkbox" id ="remember"> <span>Remember ID</span>
                </div>
                <div class="buttonDiv">
                    <button type="submit" id = "login">로그인</button>
                    <button type="button" id ="signup">회원가입</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        document.querySelector("#login").addEventListener("click", ()=> location.href ="/member/login");
        document.querySelector("#signup").addEventListener("click", () => location.href= "/member/toSignup")
    </script>
</body>
</html>
