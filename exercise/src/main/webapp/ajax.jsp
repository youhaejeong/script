<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax.jsp 실습</title>
</head>
<body>
	<!-- 학생번호 이름 영어점수 국어점수 조회 입력 수정 삭제 -->
	<form name="fr" action="studentGetServlet" method="post">
		<input type='hidden' name='cmd' value='search'>
		NO   : <input type='number' name='stu_no' value='1234'>
		Name : <input type='text' name='stu_name' value='나의파랑새'>
		Eng  : <input type='number' name='eng_score' value='50'>
		Kor  : <input type='number' name='kor_score' value='80'>
		<input type='submit' value='조회'>
		<input type='button' name='addBtn' value='입력'>
		<input type='button' name='modBtn' value='수정'>
		<input type='button' name='delBtn' value='삭제'>
		</form>
		<hr>
		<a href="studentList.jsp">학생목록</a>
</body>
</html>