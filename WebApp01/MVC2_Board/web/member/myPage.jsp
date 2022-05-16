<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        #content2_content {
            display: flex;
        }

        #content3_content select {
            flex-grow: 1;
            height: 20px;
        }

        #content3_content input {
            flex-grow: 1;
            height: 20px;
        }

        #content4_content1 {
            display: flex;
        }

        #content4_content1 input {
            flex-basis: 50%;
            height: 20px;
        }

        #content4_content1 button {
            flex-basis: 50%;
            border-radius: 10px;
            border: none;
            background-color: gold;
            color: white;
        }

        #content4_content2 {
            display: flex;
        }

        #content4_content2 input {
            height: 20px;
            flex-grow: 1;
        }

        #content4_content3 {
            display: flex;
        }

        #content4_content3 input {
            height: 20px;
            flex-grow: 1;
        }

        .footer {
            display: flex;
            justify-content: center;
        }

        .footer #modifyBtn {
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

        #phoneNum {
            display: none;
        }
    </style>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="" method="post" id="modifyForm">
        <div class="title">
            정보수정
        </div>
        <div class="contentContainer">
            <div id="content1">
                <div id="content1_title">ID(Email)</div>
                <div id="content1_content">
                    <input type="text" name='id' placeholder="id" id="idInput" value="${memberDTO.getId()}" readonly>
                </div>
            </div>
            <div id="content2">
                <div id="content2_title">Nickname</div>
                <div id="content2_content">
                    <input type="text" name="nickname" placeholder="nickname" id="nickname"
                           value="${memberDTO.getNickname()}">
                </div>
            </div>
            <div id="content3">
                <div id="content3_title">Phone</div>
                <div id="content3_content">
                    <select name="phoneNum1" id="phoneNum1">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="017">017</option>
                    </select>
                    <input type="number" name="phoneNum2" id="phoneNum2">
                    <input type="number" name="phoneNum3" id=phoneNum3>
                    <input type="text" name="phoneNum" id="phoneNum" value = "${memberDTO.getPhone()}">
                </div>
            </div>
            <div id="content4">
                <div id="content4_content1">
                    <input type="text" name="postCode" placeholder="우편번호" id="postCode"
                           value="${memberDTO.getPostcode()}">
                    <button type="button" id="findAddressBtn">우편번호 찾기</button>
                </div>
                <div id="content4_content2">
                    <input type="text" name="address_1" placeholder="도로명 주소" id="address_1"
                           value="${memberDTO.getAddress_1()}">
                </div>
                <div id="content4_content3">
                    <input type="text" name="address_2" placeholder="상세 주소" id="address_2"
                           value="${memberDTO.getAddress_2()}">
                    <input type="text" name="address_3" placeholder="읍/면/동" id="address_3"
                           value="${memberDTO.getAddress_3()}">
                </div>
            </div>
        </div>
        <div class="footer">
            <button type="button" id="cancelBtn">취소</button>
            <button type="button" id="modifyBtn">수정</button>
        </div>
    </form>
</div>
<script>
    window.onload = function () {
        let phone = document.getElementById("phoneNum").value;
        console.log(phone);
        let phoneNum1 = phone.substr(0, 3);
        let phoneNum2 = phone.substr(3, 4);
        let phoneNum3 = phone.substr(7, 4);


        document.getElementById("phoneNum2").value = phoneNum2;
        document.getElementById("phoneNum3").value = phoneNum3;
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
        }).open({autoClose: true});
    }
</script>
</body>
</html>