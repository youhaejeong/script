<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult / memberInsertOutput</title>
</head>
<body>
	<h3>${name }님 가입이 완료되었습니다.</h3> <!-- 표현식 --> <!-- 위 아래 같은 뜻 위;쪽이 더 간단함 -->
	<!--  <h3><%//=(String) request.getAttribute("name")%>님 가입이 완료되었습니다.</h3>-->
	<jsp:include page="home.jsp"></jsp:include>
	<%//@include file="home.jsp"%>


</body>
</html>