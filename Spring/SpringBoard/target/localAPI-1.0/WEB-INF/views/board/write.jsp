<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/06/24
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .container {
        width: 100%;
        height: 100%;
    }
    .header {
        display: flex;
        justify-content: flex-end;
        height: 30px;
    }
    .content {
        height: 90%;
    }
    .board_header {
        height: 30px;
        font-size: 1.2rem;
        display: flex;
        justify-content: center;
        font-weight: bold;
    }
    .board_content {
        height: 90%;
    }

    .board_content input {
        width: 100%;
    }

    .board_content textarea {
        resize: none;
        width: 100%;
        height: 90%;
    }
    .board_footer {
        height: 30px;
        display: flex;
        justify-content: center;
    }

    #logout {
        color: white;
        background-color: red;
        border-radius: 10px;
        border: none;
    }

    #logout:hover {
        background-color: #ec6464;
    }

    #write {
        color: white;
        background-color: gold;
        border-radius: 10px;
        border: none;
    }
    #write:hover {
        color: white;
        background-color: #ffeb89;
        border-radius: 10px;
        border: none;
    }
    #cancel {
        color: white;
        background-color: silver;
        border-radius: 10px;
        border: none;
    }
    #cancel:hover {
        color: white;
        background-color: #d9c8c8;
        border-radius: 10px;
        border: none;
    }


</style>
<body>
<div class="container">
    <div class="header">
        <button id ="logout">logout</button>
    </div>
    <div class="content">
        <div class="board_header">
            글쓰기
        </div>
        <div class="board_content">
            <form action="/board/write" method="post" enctype="multipart/form-data" id="form">
                <input type="hidden" name ="writer_nickname" value="${loginSession.nickname}">
                <input type="hidden" name ="writer_id" value="${loginSession.id}">
                <label> 제목 :
                    <input type="text" id="title" name="title" placeholder="제목을 입력하세요">
                </label>
                <label> 파일 :
                    <input type="file" id ="file" name = "multipartFile" multiple>
                </label>
                <label>
                    <textarea name="content" id="content"></textarea>
                </label>
                <div class="board_footer">
                    <button type="button" id="cancel">cancel</button><button type="submit" id="write">write</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    document.querySelector("#cancel").addEventListener("click", ()=>{
        location.href = "/board/toBoard?curPage=1";
    });

    document.querySelector("#form").addEventListener("submit",(e)=>{
        if(document.querySelector("#title").value===""){
            e.preventDefault();
            alert("제목을 입력하세요");
        }
        if(document.querySelector("#content").value===""){
            e.preventDefault();
            alert("내용을 입력하세요");
        }
    });
</script>

</body>
</html>
