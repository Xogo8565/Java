<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        height: 22px;
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
    #back {
        color: white;
        background-color: silver;
        border-radius: 10px;
        border: none;
    }
    #back:hover {
        color: white;
        background-color: #d9c8c8;
        border-radius: 10px;
        border: none;
    }
    #nickname {
        width: 40%;
    }

    .hidden {
        display: none;
    }

    .board_view {
        display: flex;
        justify-content: space-around;
        gap: 20px;
    }


</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<body>
<div class="container">
    <div class="header">
        <button id ="logout">로그아웃</button>
    </div>
    <div class="content">
        <div class="board_header">
            글쓰기
        </div>
        <div class="board_content">
            <form action="/board/modify" method="post" enctype="multipart/form-data" id="form">
                <input type="hidden" name ="seq_board" value="${map['boardDTO'].seq_board}">
                <label> 제목 :
                    <input type="text" id="title" name="title" value="${map['boardDTO'].title}" readonly>
                </label>
                <label> 글쓴이 :
                    <input type="text" id="nickname" name = "nickname" value="${map['boardDTO'].writer_nickname}" readonly>
                </label>
                <div class="board_view">
                    <span>날짜 : ${map["boardDTO"].date}</span><span>조회수 : ${map['boardDTO'].view_count}</span>
                </div>
                <div> 파일 :
                    <c:forEach items="${map['fileList']}" var="file">
                        <div class="fileLi">
                            <a class="file" href="/board/download?file_name=${file.file_name}">${file.file_name}</a><button type="button" class="deleteFile hidden" value="${file.file_name}">delete</button>
                        </div>
                    </c:forEach>
                    <input type="file" class="hidden" name = "multipartFile" id ="file" multiple>
                    <input type="text" class="hidden" name = "files[]" id = "deleteFile">
                </div>
                <label>
                    <textarea name="content" id="content" readonly>${map['boardDTO'].content}</textarea>
                </label>
                <div class="board_footer">
                    <button type="button" id ="back">back</button>

                    <c:if test="${loginSession.id eq map['boardDTO'].writer_id}">
                        <button type="button" id ="modify">modify</button>
                        <button type="button" id ="delete">delete</button>
                        <button type="submit" id ="complete" class="hidden">complete</button>
                        <button type="button" id ="cancel" class="hidden">cancel</button>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    document.querySelector("#back").addEventListener("click", ()=>{
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
        document.querySelector("#deleteFile").value = deleteFileList;
    });

    document.querySelector("#modify").addEventListener("click",()=>{
        modifySelect();
    });

    document.querySelector("#cancel").addEventListener("click",()=>{
        modifyCancel();
    });

    function modifySelect () {
        document.querySelector("#title").readOnly = false;
        document.querySelector("#content").readOnly = false;
        document.querySelector("#modify").classList.add("hidden");
        document.querySelector("#delete").classList.add("hidden");
        document.querySelector("#complete").classList.remove("hidden");
        document.querySelector("#cancel").classList.remove("hidden");
        document.querySelector("#file").classList.remove("hidden");

        let delFile = document.getElementsByClassName("deleteFile");
        for(let i =0; i<delFile.length; i++){
            delFile[i].classList.remove("hidden");
        }

    }

    function modifyCancel() {
        document.querySelector("#title").readOnly = true;
        document.querySelector("#content").readOnly = true;
        document.querySelector("#complete").classList.add("hidden");
        document.querySelector("#cancel").classList.add("hidden");
        document.querySelector("#modify").classList.remove("hidden");
        document.querySelector("#delete").classList.remove("hidden");
        document.querySelector("#file").classList.add("hidden");

        let delFile = document.getElementsByClassName("deleteFile");
        for(let i =0; i<delFile.length; i++){
            delFile[i].classList.add("hidden");
        }
    }

    document.querySelector("#delete").addEventListener("click",()=>{
        let check = confirm("정말로 삭제하시겠습니까?");
        if(check) {
            let deleteForm = document.createElement("form");
            deleteForm.action = "/board/delete";
            deleteForm.method = "post";

            let seq_board = document.createElement("input");
            seq_board.type = "hidden";
            seq_board.value = "${map['boardDTO'].seq_board}";
            seq_board.name = "seq_board";

            deleteForm.appendChild(seq_board);

            document.body.appendChild(deleteForm);
            deleteForm.submit();
        }
    });



    const delFile = document.querySelectorAll(".deleteFile");
    const deleteFileList = [];

    delFile.forEach((a)=>{
        a.addEventListener("click", deleteFile);
    });

    function deleteFile (){
        this.parentElement.remove();
        deleteFileList.push(this.value);
    }
</script>

</body>
</html>
