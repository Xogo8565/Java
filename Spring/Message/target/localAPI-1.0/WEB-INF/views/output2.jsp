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
        .complete {
            display: none;
        }
        .cancel {
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>No</th>
        <th>닉네임</th>
        <th>메시지</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${arrayList}" var="messageDTO">
        <tr>
            <td>${messageDTO.seq_msg}</td>
            <td>${messageDTO.nickname}</td>
            <td><input type="text" readonly value="${messageDTO.message}"></td>
            <td>
                <button class ='modify'>modify</button>
                <button class ='delete' value="${messageDTO.seq_msg}">delete</button>
                <button class ='complete' value="${messageDTO.seq_msg}">complete</button>
                <button class= "cancel" >cancel</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    let del = document.getElementsByClassName("delete");
    for(let i =0; i<del.length; i++){
        del[i].addEventListener("click", function (){
            let check = confirm("정말로 삭제하시겠습니까?")
            let val = this.value;
            let that = this;

            if(check) {
                // let form = document.createElement("form");
                // form.action = "delete";
                // form.method = "post";
                //
                // let input = document.createElement("input");
                // input.type = "hidden"
                // input.name = "seq_msg";
                // input.value = val;
                //
                // form.appendChild(input);
                // document.body.appendChild(form);


                $.ajax({
                    url : "/deleteAjax",
                    type : "post",
                    data : { seq_msg : val },
                    success : function (data) {
                        if(data === "success"){
                            that.parentElement.parentElement.remove();
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            }
        })
    }

    let modify = document.getElementsByClassName("modify");
    for(let i = 0; i<modify.length; i++){
        modify[i].addEventListener("click",function () {
            let sibling = this.parentElement.children;
            for(let j = 0; j<sibling.length; j++){
                sibling[j].style.display = "inline-block";
            }
            this.style.display = "none";
            this.nextElementSibling.style.display = "none";

            let input = this.parentElement.previousElementSibling.children[0];
            let defaultVal = input.value;
            input.readOnly = false;

            let complete = this.nextElementSibling.nextElementSibling;
            let cancel = this.parentElement.lastElementChild;

            complete.addEventListener("click", function (){
                let no = this.value;
                let that = this;

                $.ajax({
                    url : "/modifyAjax",
                    data : { seq_msg : no, message : input.value },
                    type : "post",
                    success : function (data) {
                        input.value = data;
                        for(let i = 0; i< sibling.length; i++){
                            sibling[i].style.display = "inline-block";
                        }
                        that.style.display = "none";
                        that.nextElementSibling.style.display = "none";

                    },
                    error : function (e) {
                        console.log(e);
                    }

                });
            });

            cancel.addEventListener("click",function () {
                input.value = defaultVal;
                input.readOnly = true;
                for(let i = 0; i< sibling.length; i++){
                    sibling[i].style.display = "inline-block";
                }
                this.style.display = "none";
                this.previousElementSibling.style.display = "none";
            })
        });
    }
</script>
</body>
</html>
