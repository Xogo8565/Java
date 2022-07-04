<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/07/04
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr><th>축제명</th><th>축제장소</th><th>시작일</th><th>종료일</th><th>홈페이지</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${data.FestivalBaseInfo}" var="i">
        <tr>
            <td>${i.festivalNm}</td>
            <td>${i.festivalVenue}</td>
            <td>${i.festivalBeginDate}</td>
            <td>${i.festivalEndDate}</td>
            <td>${i.homePage}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
