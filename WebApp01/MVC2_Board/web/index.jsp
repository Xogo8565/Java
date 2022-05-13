<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/13
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      .container {
        width: 300px;
        height: 200px;
        border: 1px solid black;
      }
      .container * {
        margin : 3px;
      }
      .title{
        font-weight: bold;
        font-size: 1.4em;
        text-align: center;
      }
      .content {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      .content #idInput {
        width: 80%;
        height: 20px;
      }
      .content #pwInput {
        width: 80%;
        height: 20px;
      }
      .remember input {
        margin : 10px;
      }
      .footer {
        display: flex;
        justify-content: center;
      }
      .footer #loginBtn {
        border-radius: 10px;
        border: none;
        background-color: gold;
        color : white;
      }
      .footer #signUpBtn {
        border-radius: 10px;
        border: gold solid 3px;
        background-color: white;
      }
    </style>
  </head>
  <body>
  <div class="container">
    <div class="title">
      Board
    </div>
    <form action="" method="post">
      <div class="content">
        <input type="text" placeholder="id" name="id" id = "idInput"><br>
        <input type="text" placeholder="pw" name="pw" id = "pwInput"><br>
        <div class="remeber"><input type="checkbox"><span>아이디 기억하기</span></div>
      </div>
      <div class="footer">
        <button type="submit" id = 'loginBtn'>Login</button>
        <button type="button" id = 'signUpBtn'>Sign up</button>
      </div>
    </form>
  </div>
  <script>
    document.getElementById("signUpBtn").onclick = function () {
      location.href = "/toSignUp.member"
    }
  </script>
  </body>
</html>
