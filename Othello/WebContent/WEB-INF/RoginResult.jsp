<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.Field.Field" %>
<%
	Field field =(Field)application.getAttribute("Field");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index2.css">
</head>
<body>

ログイン成功しました！！
<a href = "/Othello/OthelloMain">
<div class="room">
<div class="room-title"><%= field.getFieldTitle()%></div>
<div class="numver"><%=field.getNumber()%>/2</div>
</a>
</div>

<!--　フッター　-->
		<footer>
		<div class="name">Yamazaki Kaoru</div>
		<div class="mail">yamazakisoccer@icloud.com</div>
		</footer>

<a href = "/Othello/OthelloMain">オセロへ</a>
</body>
</html>