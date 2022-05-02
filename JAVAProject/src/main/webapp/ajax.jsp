<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax.jsp</title>
</head>
<body>
	<script>
		//Asynchronous Javascript And Xml 비동기 방식 
		let url = 'StudentGetServlet';
		fetch(url)
		.then(result =>{
			return result.json(); //{"id":23,"name":"hong"} json 타입임 
		})
		.then(result =>{  //두번 작업한거임 
			console.log(result);
		})
		.catch(error =>{
			console.log(error)
		}) //return값이 promise 타입
	</script>
</body>
</html>