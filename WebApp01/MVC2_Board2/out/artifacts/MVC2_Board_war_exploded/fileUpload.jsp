<%--
  Created by IntelliJ IDEA.
  User: jangseoksu
  Date: 2022/05/24
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
 파일 업로드
 1. input type file, name 필수
 2. form 태그에 enctype = "multipart/form-date"
--%>

<form action="/upload1.file" enctype="multipart/form-data" method="post">
    <h2>파일 업로드1</h2>
    <input type="file" name="file">
    <button type="submit">파일 업로드 1</button>
</form>
<form action="/upload2.file" method="post" enctype="multipart/form-data">
    <h2>파일 업로드2</h2>
    <input type="file" name='file1'><input type="file" name='file2'>
    <button class="subtmit">파일 업로드 2</button>
</form>

<form action="/upload3.file" enctype="multipart/form-data" method="post">
    <h2>파일 업로드3</h2>
    <input type="text" name="title">
    <input type="text" name="msg">
    <input type="file" name="file">
    <button type="submit">파일 업로드 3</button>
</form>
</body>
</html>
