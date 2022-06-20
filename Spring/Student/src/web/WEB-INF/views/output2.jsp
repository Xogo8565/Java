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
    .cancel, .complete {
        display: none;
    }
</style>
<body>
    <table>
        <thead>
        <tr>
            <th>no</th>
            <th>name</th>
            <th>memo</th>
            <th></th>
        </tr></thead>
        <tbody>

        </tbody>
    </table>
    <script>
        

        let del = document.getElementsByClassName("delete");
        for(let i =0; i<del.length; i++){
            del[i].addEventListener("click", function (){
                let form = document.createElement("form");
                form.action = "/delete.stu";
                form.method = "post";

                let input = document.createElement("input");
                input.name = "no";
                input.value = this.value;
                input.type = "hidden";

                form.append(input);
                document.body.append(form);
                form.submit();
            });
        }

        let modify = document.getElementsByClassName("modify");
        for(let i =0; i<modify.length; i++){
            modify[i].addEventListener("click", function (){
                let del = this.parentElement.children[1];
                let complete = this.parentElement.children[2];
                let cancel = this.parentElement.children[3];

                this.style.display = "none";
                del.style.display = "none";
                complete.style.display = "inline-block";
                cancel.style.display = "inline-block";

                let input = this.parentElement.previousElementSibling.children[0];
                let input_val = input.value;
                input.readOnly = false;

                complete.addEventListener("click", function (){
                    let no = this.value;

                    let form = document.createElement("form");
                    form.action ="/modify.stu";
                    form.method ="post";

                    let input_no = document.createElement("input");
                    input_no.type = "hidden";
                    input_no.value = no;
                    input_no.name = "no";

                    let input_copy = input.cloneNode();
                    input_copy.type = "hidden";
                    input_copy.name = "memo";

                    form.append(input_no);
                    form.append(input_copy);
                    document.body.append(form);

                    form.submit();
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
        }
    </script>
</body>
</html>
