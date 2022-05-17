<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=request.getAttribute("Hello")%>
	<h4>${ Hello }</h4>
	<h3>등록결과페이지</h3>
	<a href="../addBook.do?title=text&author=hong&press=yedam">링크...</a>
	<a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>
</html>