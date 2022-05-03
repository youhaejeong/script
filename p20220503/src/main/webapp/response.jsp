<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.jsp</title>
</head>
<body>
	<%
		String id = (String) request.getAttribute("id"); //내장객체의 정보를 불러옴 이떄 리퀘스트는 요청단위당 반환 하는것으로 또다른 jsp페이지에서 불러올수없음 
		String name = (String) request.getAttribute("name");
		Student student = (Student) request.getAttribute("result");
	%>

	<h3>
		id:
		<%=id%></h3>
	<h3>
		name
		<%=name%></h3>
	<h3>
		no:
		<%=student.getStudentNo()%></h3>
	<h3>
		name:
		<%=student.getStudentName()%></h3>
</body>
</html>