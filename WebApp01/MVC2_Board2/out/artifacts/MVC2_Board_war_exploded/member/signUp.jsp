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
        .container {
            width: 800px;
            height: 1000px;
        }

        .container * {
            margin: 5px
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
            color: white;
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
            color: white;
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
            color: white;
        }

        .footer #cancelBtn {
            flex-basis: 60px;
            border-radius: 10px;
            border: none;
            background-color: silver;
            color: white;
        }

        #phoneNum{
            display: none;
        }
    </style>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/signUp.member" method="post" id = "signUpForm">
        <div class="title">
            회원가입
        </div>
        <div class="contentContainer">
            <div id="content1">
                <div id="content1_title">ID(Email)</div>
                <div id="content1_content">
                    <input type="text" name='id' placeholder="id" id="idInput"readonly>
                    <button type="button" id="checkIdBtn">아이디 확인</button>
                </div>
            </div>
            <div id="content2">
                <div id="content2_title">PW</div>
                <div id="content2_content"><input type="password" name="pw" placeholder="pw" id="pwInput"></div>
            </div>
            <div id="content3">
                <div id="content3_title">Re-PW</div>
                <div id="content3_content"><input type="password" name="re_pw" placeholder="re_pw" id="re_pwInput"></div>
            </div>
            <div id="content4">
                <div id="content4_title">Nickname</div>
                <div id="content4_content"><input type="text" name="nickname" placeholder="nickname" id="nickname">
                </div>
            </div>
            <div id="content5">
                <div id="content5_title">Phone</div>
                <div id="content5_content">
                    <select name="phoneNum1" id = "phoneNum1">
                        <option value="010" selected>010</option>
                        <option value="011">011</option>
                        <option value="017">017</option>
                    </select>
                    <input type="number" name="phoneNum2" id="phoneNum2">
                    <input type="number" name="phoneNum3" id=phoneNum3>
                    <input type="text" name = "phoneNum" id = "phoneNum">
                </div>
            </div>
            <div id="content6">
                <div id="content6_content1">
                    <input type="text" name="postCode" placeholder="우편번호" id="postCode">
                    <button type="button" id="findAddressBtn">우편번호 찾기</button>
                </div>
                <div id="content6_content2"><input type="text" name="address_1" placeholder="도로명 주소" id="address_1">
                </div>
                <div id="content6_content3"><input type="text" name="address_2" placeholder="상세 주소" id = "address_2"><input type="text"
                                                                                                           name="address_3"
                                                                                                           placeholder="읍/면/동" id="address_3">
                </div>
            </div>
        </div>
        <div class="footer">
            <button type="button" id="cancelBtn">취소</button>
            <button type="button" id="signUpBtn">가입</button>
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

    document.getElementById("findAddressBtn").onclick = function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraRoadAddr !== '') {
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postCode').value = data.zonecode;
                document.getElementById("address_1").value = roadAddr;

                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if (roadAddr !== '') {
                    document.getElementById("address_2").value = extraRoadAddr;
                } else {
                    document.getElementById("address_2").value = '';
                }

            }
        }).open({autoClose : true});
    }

    document.getElementById("signUpBtn").onclick = function () {
        // 아이디 정규식 -> popup.jsp
        let id = document.getElementById("idInput");

        // 비밀번호 정규식 적용 ( 영문자 숫자 ~!@#$%^&* 포함하여 6 ~ 20자
        let pw = document.getElementById("pwInput");
        let pwRegex = /(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,12}/;
        // 비밀번호 확인 창 (비밀번호 창에 입력된 값과 일치여부)
        let re_pw = document.getElementById("re_pwInput");

        // 닉네임 정규식 적용 ( 영문자, 한글, 숫자 적용하여 4~8)
        let nickname = document.getElementById("nickname");
        let nicknameRegex = /[a-zA-Zㄱ-힣0-9]{4,8}/;
        // 휴대번호 정규식 적용
        let phoneNum = $("#phoneNum1 option:selected").val() + $("#phoneNum2").val() + $("#phoneNum3").val();
        document.getElementById("phoneNum").value = phoneNum;
        console.log(phoneNum);
        let phoneNumRegex = /[0-9]{11}/;

        //우편번호 , 도로명 주소
        let postCode = document.getElementById("postCode");
        let address = document.getElementById("address_1");

        if(id.value ===""){
            alert("아이디를 입력하세요");
        } else if(!pwRegex.test(pw.value)){
            alert("비밀번호 형식 불일치");
            return;
        } else if (pw.value !== re_pw.value){
            alert("재입력된 비밀번호 불일치");
            return;
        } else if (!nicknameRegex.test(nickname.value)){
            alert("넥네임 형식 불일치");
            return;
        } else if (!phoneNumRegex.test(phoneNum)){
            alert("전화번호 형식 불일치");
            return;
        } else if (postCode.value==="" || address.value ===""){
            alert("주소를 입력하세요");
            return;
        }
        document.getElementById("signUpForm").submit();
    }
</script>
</body>
</html>