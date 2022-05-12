<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath }/login.do" method="get">
	<p>아이디 : <input type="email" name="email"></p><br>
	<p>비밀번호 : <input type="password" name="pw"></p><br>
	<input type="submit" value="로그인">
	<input type="button" value="회원가입">



	</form>



</body>
</html>