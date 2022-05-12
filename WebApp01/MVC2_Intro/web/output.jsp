<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/11
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
EL(Expression Language) : servlet(controller)로 부터 넘겨받은 request 안에 있는 값을 꺼내서 사용하기 위해 필요한 언어
        ${key} : controller 에서 setting 한 key 값을 ${}안에 넘기면
        -> 그 key 값에 해당하는 값이 반환
--%>
<%--
<input type="text" value="${temp}">
<input type="text" value="${number}">
---%>
<%--
${msgDTO}
${msgDTO.getNo()}
${msgDTO.getNickname()}
${msgDTO.getMsg()}
--%>
<!--
배열, 리스트 for 문을 돌리기 위해서 라이브러리 추가
JSTL(JSP/Java Tag Library)
-> Script 영역이 아닌 곳에서 for 문 / If 문을 사용할 수 있게 해줌
-->
<%--
items -> for 문을 돌릴
var ->
--%>
<table border="1" align="center">
    <thead>
    <tr>
        <th>No</th>
        <th>Nickname</th>
        <th>Message</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${arrayList}" var="msgDTO">
        <tr>
            <td>${msgDTO.getNo()}</td>
            <td>${msgDTO.getNickname()}</td>
            <td>${msgDTO.getMsg()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
