<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/07/05
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<style>
    *{
        box-sizing: border-box;
    }
    .container {
        height: 600px;
        width: 300px;
    }
    .chatLog {
        height: 85%;
        border:1px solid black;
        display: flex;
        flex-direction: column;
        gap:10px;
    }
    .chatInput {
        height: 15%;
        display: flex;
    }
    .chat {
        width: 90%;
        border : 1px solid black;
    }
    #chat {
        flex-basis: 80%;
        resize : none;
    }
    #send {
        flex-basis: 20%;
        border : none;
        background-color: gold;
        color: white;
    }


</style>
<body>
<div class="container">
    <div class="chatLog">

    </div>
    <div class="chatInput">
        <textarea name="chat" id="chat"></textarea>
        <button type="button" id = "send">send</button>
    </div>
</div>
</body>
<script>
    // home이 로드 됐을 때 바로 webSocket 접속이 이뤄져 스트림이 생성되고
    //작성된 메서지가 요청이 되거나 다른 접속자가 보낸 메세지를 응답받을 수 있게 만듦

    // 웹소켓을 생성할 때 서버의 ip는 반드시 실제 ip 를 입력
  const websocket = new WebSocket("ws://192.168.1.2:8081/");
  document.querySelector("#send").addEventListener("click", ()=>{
      let message = document.querySelector("#chat").value;
      if(message !== "") {
          document.querySelector("#chat").value = "";
          websocket.send(message);
      }
  });
  // 메세지 받기
    websocket.onmessage = (e) => {
        let chat = document.createElement("div");
        chat.innerHTML = e.data.substr(37);
        chat.classList.add("chat");
        document.querySelector(".chatLog").append(chat);
    }
</script>
</html>
