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
            position: relative;
            height: 20%;
        }
        #checkID {
            position: absolute;
            right: 0;
            bottom: 0;
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
            <h3>회원가입</h3>
        </div>
        <div class="inputDiv">
            <form action="/member/signup" method="post" enctype="multipart/form-data" id ="signupForm">
                <div class="profile">
                    <div class="imgDiv">
                        <img src="/resources/images/default_profile.webp" id ="profile_image">
                    </div>
                    <div>프로필 등록</div>
                    <input type="file" id = "profile_file" name="img">
                </div>
                <div class="id">
                    <label for="id"> <span>ID</span>
                    <input type="text" name="id" id="id" placeholder="영문(대소문자), 숫자 포함 6~12자">
                    </label>
                    <button type="button" id ="checkID">중복확인</button>
                </div>
                <div class="pw">
                    <label for="pw"> <span>PW</span>
                        <input type="password" name = "pw" id="pw" placeholder="영문(대문자), 영문(소문자) , 숫자 최소 1자씩 6~12자">
                    </label>
                </div>
                <div class="nickname">
                    <label for="nickname"> <span>NICKNAME</span>
                        <input type="text" name = "nickname" id = "nickname" placeholder="영문(대소문자), 숫자 포함 6~12자">
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
           let reader = new FileReader(); // 사용자가 파일 태그를 이용해 파일을 선택했을 때 사용자의 로컬에 있는 파일의 정보를 브라우저에서 사용 가능하게끔 해주는 클래스
            reader.readAsDataURL(this.files[0]); // 인자값으로 파일 태그를 넘겨줘야 함
            //onload -> trigger / onload 이벤트 발생했을 때 callback function으로 img 태그의 src 변화

            reader.addEventListener("load", (e)=>{
                let img = e.target.result; // e.target.result -> 브라우저에서 바로 해석(로드)가 가능하게끔 변환된 이미지의 경로값
                document.querySelector("#profile_img").src = img;
            })
        });

        document.querySelector("#signupForm").addEventListener("submit", function (event) {
            let id = document.querySelector("#id").value;
            let pw = document.querySelector("#pw").value;
            let nickname = document.querySelector("#nickname").value;

            let idRegex = /[a-zA-Z0-9]{6,12}/;
            let pwRegex = /[a-zA-Z0-9]{6,12}/
            let nickRegex = /[a-zA-Z0-9]{6,12}/;

            if(!idRegex.test(id)){
                alert("ID 형식 불일치");
                event.preventDefault();
            } else if(!pwRegex.test(pw)){
                alert("PW 형식 불일치")
                event.preventDefault();
            } else if(!nickRegex.test(nickname)){
                alert("NICKNAME 형식 불일치");
                event.preventDefault();
            }
        })
    </script>
</body>
</html>
