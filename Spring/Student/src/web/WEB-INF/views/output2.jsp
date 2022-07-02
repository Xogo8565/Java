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
    <style>
        .cancel, .complete {
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>no</th>
            <th>name</th>
            <th>memo</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <script>
        function show(){
            $.ajax({
                url : "/output.stu2",
                success : function (data){
                    $.each(data, function (index,item){
                        let td1 = $("<td>").append(item.no);
                        let td2 = $("<td>").append(item.name);
                        let td3 = $("<td>").append($("<input>").val(item.memo).attr("readonly", true));
                        let modifyBtn = $("<button>").attr({ "class" : "modify"}).append("modify");
                        let delBtn = $("<button>").attr({ "class" : "delete", "value" : item.no}).append("delete");
                        let completeBtn = $("<button>").attr({ "class" : "complete", "value" : item.no}).append("complete");
                        let cancel = $("<button>").attr({ "class" : "cancel"}).append("cancel");
                        let td4 = $("<td>").append(modifyBtn, delBtn, completeBtn, cancel);
                        let tr = $("<tr>").append(td1,td2,td3,td4);
                        $("tbody").append(tr);
                    });
                },
                error : function (error){
                    console.log(error);
                }
            })
        }

        $(show);

        $("tbody").on("click", ".delete", function (event){
            let check = confirm("정말로 삭제하시겠습니까");
            let val = this.value;
            if(check){
                $.ajax({
                    url : "/delete.stu2",
                    data : { no : val },
                    success : function (data) {
                        if(data === "success"){
                            $("tbody").empty();
                            show();
                        } else {
                            alert("데이터 삭제에 실패했습니다.")
                        }
                    },
                    error : function (e) {
                        console.log(e);
                    }

                });
            }
        })


        $("tbody").on("click", ".modify", function (){
            let del = this.parentElement.children[1];
            let complete = this.parentElement.children[2];
            let cancel = this.parentElement.children[3];

            this.style.display = "none";
            del.style.display = "none";
            complete.style.display = "inline-block";
            cancel.style.display = "inline-block";

            let input = this.parentElement.previousElementSibling.children[0];
            input.readOnly = false;

            complete.addEventListener("click", function (){
                let no = this.value;
                let input_val = input.value;

                $.ajax({
                    url : "/modify.stu2",
                    data : { no : no, memo : input_val },
                    success : function (data){
                        if(data === "success"){
                            $("tbody").empty();
                            show();
                        } else {
                            alert("데이터 수정에 실패했습니다.")
                        }
                    },
                    error : function (e){
                        console.log(e)
                    }
                });
            });

            cancel.addEventListener("click", function (){
                input.value = input_val;
                input.readOnly = true;
                this.parentElement.children[0].style.display = "inline-block";
                del.style.display = "inline-block";
                complete.style.display = "none";
                cancel.style.display = "none";
            })
        });

    </script>
</body>
</html>
