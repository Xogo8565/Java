<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/11
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- get : 서버에 데이터를 전송해서 그 데이터를 이용해서 서버 DB의 데이터에 영향을 주지 않는 경우
    ex_select 문 / 간단한 데이터  -> 쿼리 스트링으로 이줘질 수 있기 때문에

     post : 서버에 데이터를 전송해서 서버 DB에 영향을 주는 경우(삽입, 수정, 삭제 / 보안이 필요한 데이터 / 길이가 긴 데이터 )

     -->
    <form action="/Insert" method="post">
        <input type="text" name = "nickname" placeholder="nickname">
        <input type="text" name = "msg" placeholder="message">
        <button type="submit">Send</button>
    </form>
</body>
</html>
