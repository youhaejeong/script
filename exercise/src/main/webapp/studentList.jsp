<%@page import="com.exercise.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.exercise.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.jsp</title>
<style>
table {
	margin: 0 auto;
}
</style>
</head>
<body>
	<table border='1'>
		<caption>list</caption>
		<thead>
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>영 어</th>
				<th>국 어</th>
			</tr>
		</thead>
		<tbody>
			<%
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.studentList();
			for(Student student : list){
				out.print("<tr><td><a href='StudentGetServlet?cmd=search&stu_no="
						+student.getStudentNo()+">"
						+student.getStudentNo()+"</a></td><td>"
						+student.getStudentName() +"</td><td>"
						+student.getEngScore() +"</td><td>"
						+student.getKorScore()+"</td></tr>");
			}
			

			%>
		</tbody>
	</table>
	<hr>
	<a href='ajax.jsp'>폼화면</a>
</body>
</html>