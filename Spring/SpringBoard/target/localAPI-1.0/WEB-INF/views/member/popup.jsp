<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/21
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            width : 450px;
            height : 300px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap : 20px;
        }

        #check, #use {
            color: white;
            background-color: gold;
            border-radius: 10px;
            border: none;
        }

        #cancel {
            color: white;
            background-color: gold;
            border-radius: 10px;
            border: silver;
        }
        .footer {
            display: flex;
            justify-content: center;
            gap: 20px;
        }

    </style>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<body>
  <div class="container">
      <div class="content">
          <input type="text" name="id" id = "id"> <button id = "check"> check </button>
          <div>
            <span>결과 : </span> <span id ="result"></span>
          </div>
      </div>
      <div class="footer">
          <button id ="use" disabled>use</button> <button id = "cancel">cancel</button>
      </div>
  </div>
</body>
    <script>
        document.querySelector("#id").value = opener.document.querySelector("#id").value;

        document.querySelector("#check").addEventListener("click", ()=>{

            let idRegex = /[a-zA-Z0-9]{6,12}/;

            if(!idRegex.test(document.querySelector("#id").value)){
                alert("ID는 영문(대소문자), 숫자 포함 6 ~ 12자로 작성해주세요");
                return;
            }

            $.ajax({
                url : "/member/checkId",
                data : { id : document.querySelector("#id").value },
                success : function (data) {
                    if(data===1){
                        document.querySelector("#result").innerHTML="중복된 아이디 입니다";
                    } else {
                        document.querySelector("#result").innerHTML="사용가능한 아이디 입니다";
                        document.querySelector("#use").disabled = false;
                    }
                },
                error : function (e) {
                    console.log(e);
                }
            })
        });

        document.querySelector("#use").addEventListener("click",()=>{
            opener.document.querySelector("#id").classList.remove("unchecked");
            opener.document.querySelector("#id").value = document.querySelector("#id").value;
            self.close();
        })

        document.querySelector("#cancel").addEventListener("click", ()=>{
            self.close();
        })
    </script>
</html>
