<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="StudentGetServlet" method="get">
		<!-- get방식과  post방식에 차이가 있음 post는 전송값이 보이지 않음  -->
		<input type="hidden" name="cmd" value="search"> ID: <input
			type="number" name="user_id" value="1234"><br> Name : <input
			type="text" name="user_name" value="홍길동"><br> Eng: <input
			type="number" name="eng_score"><br> Kor: <input
			type="number" name="kor_score"><br> <input type="submit"
			value="조회"> <input id="addBtn" type="button" value="입력">
		<input id="modBtn" type="button" value="수정"> <input
			id="delBtn" type="button" value="삭제">

	</form>
	<hr>
	<a href="studentList.jsp">학생목록</a>
	<script>
	let modBtn= document.getElementById('modBtn');
	modBtn.addEventListener('click', function() {
		let frm = document.forms.frm;
		//console.log(frm);
		//frm.action = "StudentGetServlet";
		frm.method = "post";
		frm.cmd.value = "mod";

		frm.submit();//form의 submit 버튼tById('delBtn');
	});
		let dekBtn= document.getElementById('delBtn');
		delBtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value="del"; //삭제의 기능의 이름을 del이라고 하고 다른곳에서 기능을 설정함  
			
			frm.submit();
			
		});

		let addbtn = document.querySelector('#addBtn');
		addbtn.addEventListener('click', function() {
			let frm = document.forms.frm;
			//console.log(frm);
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add";

			frm.submit();//form의 submit 버튼
		});
			//	frm.onsubmit = function() {
			//event.preventDefault();
			//	console.log(hhh);
			//	frm.action ="StudentGetServlet";
			//	frm.cmd.value = "add";
			//	frm.user_id.value = "1234";
			//	frm.user_name.value = "황길동";
			//	frm.submit(); //form의 submit 버튼
			//		}
			//	console.log(frm);
			//	frm.addEventListener('submit', function() {
			//	console.log(hhh);
			//	frm.cmd.value = "add";
			//	frm.user_id.value ="hwang";
			//	frm.user_name.value ="황길동";
			//	frm.submit(); //form의 submit 버튼

			//	}) //on과 관련딘건 다 이벤트 속성입 
		
	</script>
</body>
</html>