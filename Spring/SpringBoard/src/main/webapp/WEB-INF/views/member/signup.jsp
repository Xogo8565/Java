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
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 400px;
            width: 500px;
        }
        .header {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 15%;
        }
        .profile {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            gap: 5px;
            margin-bottom: 20px;
        }

        .profile input {
            border : 1px solid silver;
            border-radius: 5px;
        }
        .imgDiv {
            width: 50px;
            height: 50px;
            border: 1px solid silver;
            border-radius: 25px;
            overflow: hidden;
        }
        .inputDiv{
            height: 60%;
        }
        .id {
            display: flex;
            gap: 10px;
            justify-content: space-between;
        }
        .id input {
            flex-basis: 70%;
        }
        #checkID {
            flex-basis: 20%;
        }
        .inputDiv input {
            width: 100%;
            margin-bottom: 10px;
        }
        .buttonDiv {
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        #checkID {
            background-color: gold;
            color: white;
            border-radius: 10px;
            border: none;
        }

        #submit {
            background-color: gold;
            color: white;
            border-radius: 10px;
            border: none;
        }
        #cancel {
            background-color: silver;
            color: white;
            border-radius: 10px;
            border: none;
        }
        .imgDiv img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h3>????????????</h3>
        </div>
        <div class="inputDiv">
            <form action="/member/signup" method="post" enctype="multipart/form-data" id ="signupForm">
                <div class="profile">
                    <div class="imgDiv">
                        <img src="/resources/images/default_profile.webp" id ="profile_image">
                    </div>
                    <div>????????? ??????</div>
                    <input type="file" id = "profile_file" name="img">
                </div>
                <div class="id">
                    <label for="id"> <span>ID</span>
                    <input type="text" name="id" id="id" class = "unchecked" placeholder="??????(????????????), ?????? ?????? 6~12???">
                    </label>
                    <button type="button" id ="checkID">????????????</button>
                </div>
                <div class="pw">
                    <label for="pw"> <span>PW</span>
                        <input type="password" name = "pw" id="pw" placeholder="??????(????????????), ?????? ?????? 6~12???">
                    </label>
                </div>
                <div class="nickname">
                    <label for="nickname"> <span>NICKNAME</span>
                        <input type="text" name = "nickname" id = "nickname" placeholder="??????(????????????), ??????, ?????? ?????? 4~10???">
                    </label>
                </div>
                <div class="buttonDiv">
                    <button type="submit" id = "submit">submit</button>
                    <button type="button" id = "cancel">cancel</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        document.querySelector("#profile_file").addEventListener("change", function (){
            let reader = new FileReader(); // ???????????? ?????? ????????? ????????? ????????? ???????????? ??? ???????????? ????????? ?????? ????????? ????????? ?????????????????? ?????? ??????????????? ????????? ?????????
            reader.readAsDataURL(this.files[0]) // ??????????????? ?????? ????????? ???????????? ???
            //onload -> trigger / onload ????????? ???????????? ??? callback function?????? img ????????? src ??????

            reader.addEventListener("load", function (e){
                let img = e.target.result; // e.target.result -> ?????????????????? ?????? ??????(??????)??? ??????????????? ????????? ???????????? ?????????
                document.querySelector("#profile_image").src = img;
            })
        });

        document.querySelector("#signupForm").addEventListener("submit", function (event) {
            let id = document.querySelector("#id").value;
            let pw = document.querySelector("#pw").value;
            let nickname = document.querySelector("#nickname").value;

            let idRegex = /[a-zA-Z0-9]{6,12}/;
            let pwRegex = /[a-zA-Z0-9]{6,20}/
            let nickRegex = /[???-???a-zA-Z0-9]{4,10}/;

            if(document.querySelector("#id").classList.contains("unchecked")){
                alert("????????? ?????? ????????? ????????????");
                event.preventDefault();
            }

            if(!idRegex.test(id)){
                alert("ID ?????? ?????????");
                event.preventDefault();
            } else if(!pwRegex.test(pw)){
                alert("PW ?????? ?????????")
                event.preventDefault();
            } else if(!nickRegex.test(nickname)){
                alert("NICKNAME ?????? ?????????");
                event.preventDefault();
            }
        });

        document.querySelector("#checkID").addEventListener("click",()=>{
            window.open("/member/checkIdPopUp", "????????? ????????????", "width = 450px, height=300px, left=500px, top=300px");
        });

        document.querySelector("#cancel").addEventListener("click",()=>{
            location.href = "/";
        });
    </script>
</body>
</html>
