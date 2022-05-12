<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/12
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            width: 500px;
            border: 1px solid black;
        }

        .head {
            display: flex;
        }

        .head div {
            flex-basis: 100px;
        }

        .result {
            display: flex;
        }

        .result div {
            flex-basis: 100px;
        }
    </style>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="head">
        <div>No</div>
        <div>ID</div>
        <div>Msg</div>
        <div></div>
    </div>
    <div class="resultContainer">
        <%--<c:if test="${arrayList == null}">--%>
        <%--
        eq : 같다 / neq : 같지 않다
        --%>
        <%--<c:if test="${arrayList.size() == 0}">--%>
        <%--<c:if test="${arrayList[0] eq null}">--%>
        <%--<c:if test="${empty arrayList}">
               <div> 등록된 게시글이 없습니다.</div>
        </c:if>
        <c:if test="${not empty arrayList}">
            <c:forEach items="${arrayList}" var="postDTO">
                <div class="result">
                    <span>${postDTO.getNo()}</span><span>${postDTO.getId()}</span><span>${postDTO.getMsg()}</span></div>
            </c:forEach>
        </c:if>--%>
        <%--
        <c:choose>
            <c:when test=""> // if

            </c:when>
            <c:when test=""> // else if

            </c:when>
            <c:otherwise> // else

            </c:otherwise>
        </c:choose>
        --%>

        <c:choose>
            <c:when test="${empty arrayList}">
                <div> 등록된 게시글이 없습니다.</div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${arrayList}" var="postDTO">
                    <div class="result">
                        <div>${postDTO.getNo()}</div>
                        <div>${postDTO.getId()}</div>
                        <div>${postDTO.getMsg()}</div>
                        <div>
                            <button class="modifyBtn" value="${postDTO.getNo()}">수정</button>
                            <button class="deleteBtn" value="${postDTO.getNo()}">삭제</button>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="footer">
        <button id="backBtn">Back</button>
    </div>
</div>
<script>
    $(".container").on("click", ".deleteBtn", function () {
        let no = $(this).val();
        console.log(no);
        //form 동적 생성
        let deleteForm = $("<form id ='deleteForm'></form>");
        // form 속성 부여
        deleteForm.attr("action", "/Delete.post");
        deleteForm.attr("method", "post");
        //데이터를 전송하기 위해 form 에 input 태그를 추가
        deleteForm.append($("<input>", {type: "text", name: "no", value: no}));
        //deleteForm 추가
        //$("body").append(deleteForm);
        //$("#deleteForm").css("display", none);
        $(deleteForm).appendTo("body").css("display", "none");
        // script 영역에서 작성한 form 을 즉시 submit
        deleteForm.submit();
    });
    $(".container").on("click", ".modifyBtn", function () {
        let no = $(this).val();
        console.log(no);
        // no 를 /modify url 로 get 방식을 통해 전송
        location.href = "/ToModify.post?no=" + no;
    })

    document.getElementById("backBtn").onclick = function () {
        location.href = 'index.jsp';
    }
</script>
</body>
</html>
