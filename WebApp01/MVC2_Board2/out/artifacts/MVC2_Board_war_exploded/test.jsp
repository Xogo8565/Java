<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/18
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<div class="header">
    <button type="button" id="logoutBtn">로그아웃</button>
    <button type="button" id="toInput">요청보내기</button>
    <form id="testForm">
        <input type="text" name="id">
        <input type="text" name="nickname">
        <button type="submit" id="submitBtn">제출</button>
    </form>
    <button type="button" id="getDataBtn"> 데이터 가지오기</button>
    <button type="button" id="getDtoBtn">DTO 가져오기</button>
    <button type="button" id ="getListBtn">리스트 가져오기</button>
</div>
</body>
<script>
    $("#getListBtn").on("click", function (){
        $.ajax({
            url : "/getList.test",
            dataType: "json",
            success : function (data) {
                for(let dto of data){
                    console.log("dto_title : " + dto.title);
                }
            }, error : function (e){
                console.log(e);
            }
        });
    });
    $("#getDtoBtn").on("click", function () {
        $.ajax({
            url: "/getDto.test",
            type: "get",
            // 서버에서 json 형식의 데이터를 보내줬을 때
            // success 안 쪽에서 js 객체처럼 받고 싶으면 datatype : json 으로 잡아줌줌            dataType: "json",
            success: function (data) {
                console.log(data.title)
            }, error: function (e) {
                console.log(e)
            }

        })
    })
    $("#getDataBtn").on("click", function () {
        $.ajax({
            url: "/getData.test?msg=hello"
            , type: "get"
            , dataType: "text" <%-- 받아올 데이터 타입 --%>
            , success: function (data) {
                console.log(data);
            }, error: function (e) {
                console.log(e);
            }
        });
    });
    $("#toInput").on("click", function () {
        /*
        * ajax : 비동기 통신일 때 사용하는 라이브러리
            전체 페이지의 리로드 없이 부분적인 페이지만 서버와 통신하여 리로드 할 수 있는 것
        * */

        // 1. 요청보내기
        // get =>>  url 활용
        $.ajax({
            url: "/sendMsg.test?msg=HelloWorld", type: "get"
            , success: function () {

            }
            , error: function (e) {
                console.log(e);
            }
        });
    });
    // post 방식으로 요청 보내기 ==> data : serialize
    $("#submitBtn").on("click", function () {
        // form 태그 안의 데이터를 객채 형식으로 변환
        let data = $("#testForm").serialize();

        $.ajax({
            url: "/sendForm.test", type: "post",
            data: data,
            success: function () {

            }, error: function (e) {
                console.log(e);
            }
        });
    });
</script>
</html>
