<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/21
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<style>
    .container {
        width: 800px;
        height: 350px;
    }

    .container form {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        gap: 50px;+
    }

    .memberDiv {
        flex-basis: 30%;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        gap: 20px;
    }

    .imgDiv {
        flex-basis: 100px;
        width: 100px;
        border-radius: 100px;
        overflow: hidden;
        background-color: red;
    }

    .imgDiv img {
        width: 100px;
        height: 100px;
    }

    .msgDiv {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        gap: 15px;
    }

    .buttonDiv {
        width: 100%;
        flex-basis: 30px;
        display: flex;
        justify-content: space-between;
        gap: 10px;
    }

    .buttonDiv button {
        background-color: gold;
        border-radius: 10px;
        flex-basis: 20%;
        color: white;
        border: none;
    }

    .buttonDiv button:hover {
        background-color: #f3d99f;
    }

    .modal form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100%;
        width: 100%;
    }

    .modal_content {
        width: 500px;
        height: 250px;
        background-color: white;
        position: relative;
        box-shadow: 20px 20px 20px gray;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
    .modal_overlay {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.47);

    }

    .hidden {
        display: none;
    }

</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<body>
<div class="container">
    <form enctype="multipart/form-data" id ="modifyForm">
        <div class="memberDiv">
            <div class="imgDiv">
                <c:if test="${empty loginSession.profile_image}">
                    <img src="/resources/images/default_profile.webp">
                </c:if>
                <c:if test="${not empty loginSession.profile_image}">
                    <img src="/profile/${loginSession.profile_image}">
                </c:if>
            </div>
            <div class="msgDiv">
                <c:if test="${empty loginSession.profile_message}">
                    <input type="text" id="profile_message" value="no message" name = "profile_message" readonly>
                </c:if>
                <c:if test="${not empty loginSession.profile_message}">
                    <input type="text" id="profile_message" value="${loginSession.profile_message}" name="profile_message" readonly>
                </c:if>
                <input type="file" id="profile_image" name="profile_image" class="hidden">
            </div>
        </div>
        <div class="buttonDiv">
            <button type='button' id="complete" class="hidden">complete</button>
            <button type='button' id="changeProfile">Change profile</button>
            <button type='button' id="logout">Logout</button>
            <button type='button' id="myInfo">My info</button>
            <button type='button' id="toBoard">To board</button>
        </div>
    </form>
    <div class="modal hidden">
        <div class="modal_overlay">
        </div>
        <div class="modal_content">
            <form id ="infoForm">
                <label for="pw"> <span>pw</span>
                    <input type="text" name = "pw" id ="pw">
                </label>
                <label for="nickname"> <span>nickname</span>
                    <input type="text" name = "nickname" id = "nickname">
                </label>
                <div class="btnDiv">
                    <button type="button" id ="submit">submit</button>
                    <button type="button" id ="cancel">cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    document.querySelector("#logout").addEventListener("click", function () {
        location.href = "/member/logout";
    });
    document.querySelector("#changeProfile").addEventListener("click", function () {
        document.querySelector("#profile_image").classList.remove("hidden");
        document.querySelector("#profile_message").readOnly = false;

        this.classList.add("hidden");
        this.previousElementSibling.classList.remove("hidden");

       document.querySelector("#profile_message").focus();
    });

    document.querySelector("#profile_image").addEventListener("change", function (event) {
        let fileReader = new FileReader();
        fileReader.readAsDataURL(document.querySelector("#profile_image").files[0]);
        fileReader.addEventListener("load", (e) => {
            document.querySelector(".imgDiv img").src = e.target.result;
        });

    });

    document.querySelector("#complete").addEventListener("click", function () {
        document.querySelector("#complete").classList.add("hidden");
        document.querySelector("#changeProfile").classList.remove("hidden")
        document.querySelector("#profile_image").classList.add("hidden");
        document.querySelector("#profile_message").readOnly = true;

        //jQuery serialize 함수를 이용해서 file 데이터를 넘길 수 없음
        // formdata 객체 활용

        let data = new FormData(document.querySelector("#modifyForm"));

        $.ajax({
            url : "/member/modifyProfile",
            type : "post",
            data : data,
            enctype : "multipart/form-data",
            contentType : false,
            processData : false,
            success : function (data){
                if(data ==="success"){
                    alert("수정에 성공했습니다");
                } else {
                    alert("수정에 실패했습니다.");
                }
            },
            error : function (e){
                console.log(e);
            }
        })
    });
    document.querySelector("#myInfo").addEventListener("click", function (){
        document.querySelector(".modal").classList.remove("hidden");
    });

    document.querySelector("#submit").addEventListener("click", function (){
        modalClose();

        $.ajax({
            url : "/member/modifyInfo",
            data : { nickname : document.querySelector("#nickname").value, pw : document.querySelector("#pw").value },
            success : function (data) {
                if(data==="success") alert("수정 성공");
                if(data==="fail") alert("수정 실패")
            },
            error : function (e) {
                console.log(e);
            }
        })
    });

    document.querySelector("#cancel").addEventListener("click", modalClose);
    document.querySelector(".modal_overlay").addEventListener("click", modalClose);

    function modalOpen() {
        document.querySelector(".modal").classList.remove("hidden");
    }

    function modalClose(){
        document.querySelector(".modal").classList.add("hidden");
    }


    function removeAllChild(div) {
        while (div.hasChildNodes()) {
            div.removeChild(div.firstChild);
        }
    }

    document.querySelector("#toBoard").addEventListener("click", ()=>{
        location.href = "/board/toBoard";
    })
</script>
</body>
</html>
