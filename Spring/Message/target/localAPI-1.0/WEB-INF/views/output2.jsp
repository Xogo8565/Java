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

    </tbody>
</table>
<script>
    //output2.jsp 가 로드 되면 ajax 요청을 보내서 데이터를 가져온 후 동적으로 뿌려주기
    function show(){
        $.ajax({
            url : "/outputAjax",
            success : function (data){
                $.each(data, function (index,item){
                    let td1 = $("<td>").append(item.seq_msg);
                    let td2 = $("<td>").append(item.nickname);
                    let td3 = $("<td>").append($("<input>").val(item.message).attr("readonly", true));
                    let modifyBtn = $("<button>").attr({ "class" : "modify"}).append("modify");
                    let delBtn = $("<button>").attr({ "class" : "delete", "value" : item.seq_msg}).append("delete");
                    let completeBtn = $("<button>").attr({ "class" : "complete", "value" : item.seq_msg}).append("complete");
                    let cancel = $("<button>").attr({ "class" : "cancel"}).append("cancel");
                    let td4 = $("<td>").append(modifyBtn, delBtn, completeBtn, cancel);
                    let tr = $("<tr>").append(td1,td2,td3,td4);
                    $("tbody").append(tr);
                })
            },
            error : function (error){
                console.log(error);
            }
        })
    }

    $(show);

    $("tbody").on("click", ".delete", function (){
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
                        $("tbody").empty();
                        show();
                    } else if (data === "fail"){
                        alert("데이터 삭제에 실패했습니다");
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    })

    $("tbody").on("click", ".modify", function (){
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
                    $("tbody").empty();
                    show();
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
    })
</script>
</body>
</html>
