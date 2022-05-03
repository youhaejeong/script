<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response2.jsp</title>
</head>
<body>
	<%
	
	String id = (String) session.getAttribute("id");
	String pw = (String) session.getAttribute("pass");

	out.print("<h3>아이디: " + id + "</h3>");
	out.print("<h3>비밀번호: " + pw + "</h3>");
	
	//String id = (String) request.getAttribute("id");
	//out.print("<h3>id : " + id + "</h3>");
	//리퀘스트를 쓴다고해서 무조건 값을 가져오는것은 아님 
	%>
</body>
</html>