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

        .footer1 {
            display: flex;
            justify-content: center;
        }

        .footer1 #modifyBtn {
            flex-basis: 60px;
            border-radius: 10px;
            border: none;
            background-color: gold;
            color: white;
        }

        .footer1 #backBtn {
            flex-basis: 60px;
            border-radius: 10px;
            border: none;
            background-color: silver;
            color: white;
        }
        .footer2 {
            display: none;
            justify-content: center;
        }

        .footer2 #completeBtn {
            flex-basis: 60px;
            border-radius: 10px;
            border: none;
            background-color: gold;
            color: white;
        }

        .footer2 #cancelBtn {
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
    <form action="/modify.member" method="post" id="modifyForm">
        <div class="title">
            ?????? ?????????
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
                           value="${memberDTO.getNickname()}" readonly>
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
                    <input type="number" name="phoneNum2" id="phoneNum2" readonly>
                    <input type="number" name="phoneNum3" id=phoneNum3 readonly>
                    <input type="text" name="phoneNum" id="phoneNum"  readonly>
                </div>
            </div>
            <div id="content4">
                <div id="content4_content1">
                    <input type="text" name="postCode" placeholder="????????????" id="postCode"
                           value="${memberDTO.getPostcode()}" readonly>
                    <button type="button" id="findAddressBtn" disabled>???????????? ??????</button>
                </div>
                <div id="content4_content2">
                    <input type="text" name="address_1" placeholder="????????? ??????" id="address_1"
                           value="${memberDTO.getAddress_1()}" readonly>
                </div>
                <div id="content4_content3">
                    <input type="text" name="address_2" placeholder="?????? ??????" id="address_2"
                           value="${memberDTO.getAddress_2()}" readonly>
                    <input type="text" name="address_3" placeholder="???/???/???" id="address_3"
                           value="${memberDTO.getAddress_3()}" readonly>
                </div>
            </div>
        </div>
        <div class="footer1">
            <button type="button" id="backBtn">????????????</button>
            <button type="button" id="modifyBtn">??????</button>
        </div>
        <div class="footer2">
            <button type='button' id='cancelBtn'>??????</button>
            <button type='button' id='completeBtn'>??????</button>

        </div>
    </form>
</div>
<script>

    let phone = "${memberDTO.getPhone()}";
    console.log(phone);
    let phoneNum1 = phone.slice(0, 3);
    let phoneNum2 = phone.slice(3, 7);
    let phoneNum3 = phone.slice(7);

    $("#phoneNum1").val(phoneNum1).prop("selected", true);
    $("#phoneNum2").val(phoneNum2);
    $("#phoneNum3").val(phoneNum3);

    $("#modifyBtn").on("click", function () {
        $("input").not("#idInput").prop("readonly", false); // id ??? ????????? input -> readonly ??????
        $("#findAddressBtn").prop("disabled", false); // ???????????? disabled ??????
        $(".footer1").css("display","none");
        $(".footer2").css("display","flex");
    });
    $("#backBtn").on("click", function (){
        location.href = "/";
    });
    $("#cancelBtn").on("click", function () {
        location.href = "/myPage.member";
    });
    $("#completeBtn").on("click", function (){
        // ????????? ????????? ?????? ( ?????????, ??????, ?????? ???????????? 4~8)
        let nickname = document.getElementById("nickname");
        let nicknameRegex = /[a-zA-Z???-???0-9]{4,8}/;
        // ???????????? ????????? ??????
        let phoneNum = $("#phoneNum1 option:selected").val() + $("#phoneNum2").val() + $("#phoneNum3").val();
        document.getElementById("phoneNum").value = phoneNum;
        let phoneNumRegex = /[0-9]{11}/;

        //???????????? , ????????? ??????
        let postCode = document.getElementById("postCode");
        let address = document.getElementById("address_1");

        if (!nicknameRegex.test(nickname.value)){
            alert("????????? ?????? ?????????");
            return;
        } else if (!phoneNumRegex.test(phoneNum)){
            alert("???????????? ?????? ?????????");
            return;
        } else if (postCode.value==="" || address.value ===""){
            alert("????????? ???????????????");
            return;
        }
        document.getElementById("modifyForm").submit();
    });

    document.getElementById("findAddressBtn").onclick = function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
                // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

                // ????????? ????????? ?????? ????????? ?????? ????????? ????????????.
                // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
                var roadAddr = data.roadAddress; // ????????? ?????? ??????
                var extraRoadAddr = ''; // ?????? ?????? ??????

                // ??????????????? ?????? ?????? ????????????. (???????????? ??????)
                // ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
                if (data.bname !== '' && /[???|???|???]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }
                // ???????????? ??????, ??????????????? ?????? ????????????.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
                if (extraRoadAddr !== '') {
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // ??????????????? ?????? ????????? ?????? ????????? ?????????.
                document.getElementById('postCode').value = data.zonecode;
                document.getElementById("address_1").value = roadAddr;

                // ???????????? ???????????? ?????? ?????? ?????? ????????? ?????????.
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