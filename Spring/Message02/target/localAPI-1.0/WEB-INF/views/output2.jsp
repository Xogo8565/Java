<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/16
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Output</title>
    <style>

        .hidden {
            display: none;
        }

    </style>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>No</th>
        <th>닉네임</th>
        <th>메시지</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="messageDTO">
        <tr>
            <td>${messageDTO.no}</td>
            <td>${messageDTO.nickname}</td>
            <td><input type="text" readonly value="${messageDTO.message}"></td>
            <td>
                <button class='modify'>modify</button>
                <button class='complete hidden' value="${messageDTO.no}">complete</button>
            </td>
            <td>
                <input type="checkbox" value="${messageDTO.no}" class="deleteNum">
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <button id="delete">삭제</button>
        </td>
    </tr>
    </tbody>
</table>
<div class="search1">
    <label for="search1">
        <span>nickname : </span>
        <input type="text" id="search1" name="search">
        <button type="button" id="searchBtn1">search</button>
    </label>
</div>
<div class="search2">
    <label for="search2">
        <form action="/search2" id="form2">
            <select name="category" id="category">
                <option value="all">all</option>
                <option value="nickname">nickname</option>
                <option value="message">message</option>
            </select>
            <input type="text" id="search2" name="keyword">
            <button type="button" id="searchBtn2">search</button>
        </form>
    </label>
</div>
<div class="search3">
    <form id="form3">
        <input type="checkbox" id="all" class="category"> all
        <input type="checkbox" name="no" value="no" class="category"> no
        <input type="checkbox" name="nickname" value="nickname" class="category"> nickname
        <input type="checkbox" name="message" value="message" class="category"> message
        <input type="text" id="search3" name="keyword">
        <button type="button" id="searchBtn3">search</button>
    </form>
</div>
<script>
    const del = document.querySelector("#delete")

    del.addEventListener("click", function () {
        const arr = [];
        const check = confirm("정말로 삭제하시겠습니까?");
        const delNum = document.querySelectorAll(".deleteNum:checked");

        delNum.forEach((i)=>{
            arr.push(i.value);
        });

        if(delNum.length===0) alert("선택된 항목이 없습니다.");

        if (check && arr.length!==0) {
            $.ajax({
                url : "/delete",
                data : { "no[]" : arr },
                success : function() {
                    location.href ="/outputList";
                },
                error : function (e) {
                    console.log(e)
                }
            })
        }
    })


    let modify = document.getElementsByClassName("modify");
    for (let i = 0; i < modify.length; i++) {
        modify[i].addEventListener("click", function () {

            this.classList.add("hidden");
            this.nextElementSibling.classList.remove("hidden");

            let input = this.parentElement.previousElementSibling.children[0];
            input.readOnly = false;

            let complete = this.nextElementSibling;

            complete.addEventListener("click", function () {

                let form = document.createElement("form");
                form.method = "post";
                form.action = "/modify";

                let method_input = document.createElement("input");
                method_input.type = "hidden";
                method_input.name = "_method";
                method_input.value = "put";

                let no_input = document.createElement("input");
                no_input.type = "hidden";
                no_input.name = "no";
                no_input.value = this.value;

                let message_input = input.cloneNode();
                message_input.type = "hidden";
                message_input.name = "message";

                form.appendChild(method_input);
                form.appendChild(no_input);
                form.appendChild(message_input);

                document.body.appendChild(form);
                form.submit();
            });

        });
    }

    document.querySelector("#searchBtn1").addEventListener("click", () => {
        $.ajax({
            url: "/search1",
            type: "get",
            data: {keyword: document.querySelector("#search1").value},
            success: function (data) {
                show(data);
            },
            error: function (e) {
                console.log(e);
            }
        })
    })

    function show(data) {
        console.log(data);
        document.querySelector("tbody").remove();
        const tbody = document.createElement("tbody");

        if (data.length === 0) {
            const tr = document.createElement("tr");
            const td = document.createElement("td");
            td.setAttribute("colspan", "5");
            tr.append(td);
            tbody.append(tr);

        } else {
            data.forEach(function (e) {
                const tr = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                td3.setAttribute("colspan", "2");

                td1.innerText = e.no;
                td2.innerText = e.nickname;
                td3.innerText = e.message;
                tr.append(td1);
                tr.append(td2);
                tr.append(td3);
                tbody.append(tr);
            })
        }
        document.querySelector("table").append(tbody);
    }

    document.querySelector("#searchBtn2").addEventListener("click", () => {
        $.ajax({
            url: "/search2",
            data: {
                category: document.querySelector("#category").value,
                keyword: document.querySelector("#search2").value
            },
            success: function (data) {
                show(data);
            },
            error: function () {
                console.log(e);
            }
        });
    });


    document.querySelector("#all").addEventListener("click", function (e) {
        if (this.checked) {
            category.forEach((e) => {
                e.checked = true;
            });
        } else {
            category.forEach((e) => {
                e.checked = false;

            });
        }
    });

    const category = document.querySelectorAll(".category");

    for (let i = 0; i < category.length; i++) {
        category[i].addEventListener("click", () => {
            const checked = document.querySelectorAll(".category:checked");
            if (category.length !== checked.length) {
                document.querySelector("#all").checked = false;
            } else {
                document.querySelector("#all").checked = true;
            }
        })
    }


    document.querySelector("#searchBtn3").addEventListener("click", () => {
        $.ajax({
            url: "/search3",
            data: $("#form3").serialize(),
            success: function (data) {
                show(data);
            },
            error: function () {
                console.log(e);
            }
        });
    });

</script>
</body>
</html>
