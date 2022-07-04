<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/07/04
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<body>
<button id = "json">Json</button>
<button id = "xml">Xml</button>
<table>
    <thead>
    <tr><th>축제명</th><th>축제장소</th><th>시작일</th><th>종료일</th><th>홈페이지</th></tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>
<script>
    document.querySelector("#json").addEventListener("click", ()=>{
        $.ajax({
            url : "/public/getJson",
            success : function (data) {
                $("tbody").empty();

                let arr = data['FestivalBaseInfo'];
                arr.forEach((item)=>{
                    let tr = document.createElement("tr");
                    let td1 = document.createElement("td");
                    td1.innerText = item.festivalNm;
                    let td2 = document.createElement("td");
                    td2.innerText = item.festivalVenue;
                    let td3 = document.createElement("td");
                    td3.innerText = item.festivalBeginDate;
                    let td4 = document.createElement("td");
                    td4.innerText = item.festivalEndDate;
                    let td5 = document.createElement("td");
                    td5.innerText = item.homePage;
                    tr.append(td1, td2, td3, td4, td5);
                    document.querySelector("tbody").append(tr);
                });
            },
            error : function (e) {
                console.log(e)
            }
        });
    });

    document.querySelector("#xml").addEventListener("click", ()=>{
        $.ajax({
            url : "/public/getXml",
            success : function (data) {
                let items = data.querySelectorAll("item");

                $("tbody").empty();

                items.forEach((item)=>{
                    console.log(item);
                    let tr = document.createElement("tr");
                    let td1 = document.createElement("td");
                    td1.innerHTML = item.querySelector("festivalNm").innerHTML;
                    let td2 = document.createElement("td");
                    td2.innerHTML = item.querySelector("festivalVenue").innerHTML;
                    let td3 = document.createElement("td");
                    td3.innerHTML = item.querySelector("festivalBeginDate").innerHTML;
                    let td4 = document.createElement("td");
                    td4.innerHTML = item.querySelector("festivalEndDate").innerHTML;
                    let td5 = document.createElement("td");
                    td5.innerHTML = item.querySelector("homePage").innerHTML;
                    tr.append(td1, td2, td3, td4, td5);
                    document.querySelector("tbody").append(tr);
                });
            },
            error : function (e) {
                console.log(e)
            }
        });
    });
</script>
</html>
