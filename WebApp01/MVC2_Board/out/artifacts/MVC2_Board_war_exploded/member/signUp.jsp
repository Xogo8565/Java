<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .container{
            width: 800px;
            height: 1000px;
        }
        .container * {
            margin : 5px
        }
        .title {
            font-size: 1.4em;
            font-weight: bold;
            text-align: center;
        }

        #content1_content {
            display: flex;
        }
        #content1_content input {
            flex-grow: 2;
            height: 20px;
        }
        #content1_content button {
            flex-grow: 1;
            border-radius: 10px;
            border: none;
            background-color: gold;
            color : white;
        }
        #content2_content input {
            width: 100%;
            height: 20px;
        }
        #content3_content input {
            width: 100%;
            height: 20px;
        }
        #content4_content input {
            width: 100%;
            height: 20px;
        }
        #content5_content {
            display: flex;
        }
        #content5_content select {
            flex-grow: 1;
            height: 20px;
        }
        #content5_content input {
            flex-grow: 1;
            height: 20px;
        }
        #content6_content1 {
            display: flex;
        }
        #content6_content1 input {
            flex-basis: 50%;
            height: 20px;
        }
        #content6_content1 button {
            flex-basis: 50%;
            border-radius: 10px;
            border: none;
            background-color: gold;
            color : white;
        }
        #content6_content2 {
            display: flex;
        }
        #content6_content2 input {
            height: 20px;
            flex-grow: 1;
        }
        #content6_content3 {
            display: flex;
        }
        #content6_content3 input {
            height: 20px;
            flex-grow: 1;
        }
        .footer {
            display: flex;
            justify-content: center;
        }
        .footer #signUpBtn {
            flex-basis: 60px;
            border-radius: 10px;
            border: none;
            background-color: gold;
            color : white;
        }
        .footer #cancleBtn {
            flex-basis: 60px;
            border-radius: 10px;
            border: none;
            background-color: silver;
            color : white;
        }

    </style>
</head>
<body>
<div class="container">
    <form action="" method="post">
        <div class="title">
            회원가입
        </div>
        <div class="contentContainer">
            <div id="content1">
                <div id="content1_title">ID(Email)</div>
                <div id="content1_content">
                    <input type="text" name='id' placeholder="id" id="idInput" disabled>
                    <button type="button" id="checkIdBtn">아이디 확인</button>
                </div>
            </div>
            <div id="content2">
                <div id="content2_title">PW</div>
                <div id="content2_content"><input type="text" name="pw" placeholder="pw"></div>
            </div>
            <div id="content3">
                <div id="content3_title">Re-PW</div>
                <div id="content3_content"><input type="text" name="re_pw" placeholder="re_pw"></div>
            </div>
            <div id="content4">
                <div id="content4_title">Nickname</div>
                <div id="content4_content"><input type="text" name="nickname" placeholder="nickname"></div>
            </div>
            <div id="content5">
                <div id="content5_title">Phone</div>
                <div id="content5_content">
                    <select name="phoneNum1">
                        <option value="010">010</option>
                        <option value="010">011</option>
                        <option value="010">017</option>
                    </select>
                    <input type="number" name="phoneNum2"><input type="number" name="phoneNum3">
                </div>
            </div>
            <div id="content6">
                <div id="content6_content1">
                    <input type="text" name="postCode" placeholder="우편번호">
                    <button type="button" id="findAddressBtn">우편번호 찾기</button>
                </div>
                <div id="content6_content2"><input type="text" name="address_1" placeholder="도로명 주소"></div>
                <div id="content6_content3"><input type="text" name="address_2" placeholder="상세 주소"><input type="text"
                                                                                                           name="address_3"
                                                                                                           placeholder="읍/면/동">
                </div>
            </div>
        </div>
        <div class="footer">
            <button type="button" id="cancleBtn">취소</button>
            <button type="submit" id ="signUpBtn">가입</button>
        </div>
    </form>
</div>
<script>
    document.getElementById("checkIdBtn").onclick = function () {
        // 팝업창을 띄우기 위해 필요한 3가지 값
        // 1. jsp 경로값 / 팝업창을 꾸며주는 jsp 별도로 필요
        // 2. 팝업창의 이름값
        // 3. 팝업창의 크기
        let url = "/idCheckPopup.member";
        let name = "아이디 중복검사";
        let option = "width = 450px, height=300px, left=500px, top=300px";
        window.open(url, name, option);
    }
    document.getElementById("cancleBtn").onclick = function () {
        location.href = "/";
    }
</script>
</body>
</html>