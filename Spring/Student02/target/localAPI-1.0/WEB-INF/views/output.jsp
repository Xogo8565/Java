<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/16
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<style>
    .hidden {
        display: none;
    }
</style>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<table>
    <thead>
    <tr>
        <th>no</th>
        <th>name</th>
        <th>memo</th>
        <th>modify</th>
        <th>delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="studentDTO">
        <tr>
            <th>${studentDTO.no}</th>
            <td>${studentDTO.name}</td>
            <td><input type="text" value="${studentDTO.memo}" readonly></td>
            <td>
                <button class="modify">modify</button>
                <button class="complete hidden" value="${studentDTO.no}">complete</button>
            </td>
            <td>
                <input type="checkbox" value="${studentDTO.no}" class="delNum">
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <button type="button" id="delete">delete</button>
        </td>
    </tr>
    </tbody>
</table>
<script>
    document.querySelector("#delete").addEventListener("click", function () {
        let delNum = document.querySelectorAll(".delNum:checked");
        let arr = [];

        if(delNum.length===0) {
            alert("선택된 내용이 없습니다");
            return;
        }

        let check = confirm("정말로 삭제하시겠습니까?");

        delNum.forEach(
            e => {
                arr.push(e.value);
            }
        )

        if(check){
            $.ajax({
                url: "/output",
                method : "delete",
                data: {
                    "no[]": arr
                },
                success: function () {
                    location.href = "/output"
                },
                error: function (e) {
                    console.log(e)
                }
            })
        }
    })

    let modify = document.getElementsByClassName("modify");
    for (let i = 0; i < modify.length; i++) {
        modify[i].addEventListener("click", function () {
            let complete = this.nextElementSibling;

            this.classList.add("hidden");
            complete.classList.remove("hidden");

            let input = this.parentElement.previousElementSibling.children[0];
            input.readOnly = false;

            complete.addEventListener("click", function () {
                $.ajax({
                    url : "/output",
                    method : "put",
                    data : {
                        "no" : this.value,
                        "memo" : this.parentElement.previousElementSibling.children[0].value
                    },
                    success : function () {
                        location.href = "/output"
                    },
                    error : function (e) {
                        console.log(e);
                    }
                })

                this.classList.remove("hidden");
                this.previousElementSibling.classList.add("hidden");
            });

        });
    }
</script>
</body>
</html>
