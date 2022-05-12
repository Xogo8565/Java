<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/12
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #noInput {
        display: none;
    }
</style>
<script
        src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<body>
<div class="container">
    <form action="/Modify.post" method="post" id="modifyForm">
        <div class="inputContainer">
            <input type="number" name="no" id="noInput" value="${postDTO.getNo()}">
            <input type="text" name='id' value='${postDTO.getId()}'>
            <textarea name="msg">${postDTO.getMsg()}</textarea>
        </div>
        <div>
            <button id="submit" type="submit">Submit</button>
        </div>
    </form>
    <script>
        // submit 버튼 클릭하면 수정 알림을 띄우고 '확인 클릭시 form 제출
        $("#submit").on("click", function () {
            let answer = confirm("정말 수정하시겠습니까?");
            if (answer) {
                $("#modifyForm").submit();
            }
        })
    </script>
</div>
</body>
</html>
