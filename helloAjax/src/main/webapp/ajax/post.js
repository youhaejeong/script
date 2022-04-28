/**
 * post.js
 */


document.addEventListener('DOMContentLoaded', init);

//리스트.
function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json');
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
		let tbodyList = document.getElementById('list');
		data.forEach(function(elem) {
			let newTr = makeTr(elem);
			tbodyList.appendChild(newTr);

		})
	}//end of onload

	let modBtn = document.querySelector('input[type=button]')
	modBtn.addEventListener('click', function() {
		let no = document.querySelector('input[name=sno]').value;
		let name = document.querySelector('input[name=sname]').value;
		let eScore = document.querySelector('input[name=eScore ]').value;
		let kScore = document.querySelector('input[name=kScore]').value;

		let xhtp = new XMLHttpRequest();
		xhtp.open('get', `modStudnetServlet?a=${no}&b=${name}&c=${eScore}&d=${kScore}`);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				//결과값으로 받은 학생 번호 이름 국어값은 새로운 tr로 변경
				let obj = {
					studentNo: result.studentNo,
					studentName: result.studentName,
					engScore: result.engScore,
					korScore: result.korScore
				}
				let newTr = makeTr(obj)
				let oldTr = document.getElementById(result.studentNo);
				document.getElementById('list').replaceChild(newTr, oldTr); //반드시 부모요소가들어가야함
				//이전 tr을 새로운 tr 로 대체
			} else {
				alert('수정변경중 오래 ㄴㄴㅁㅇㅁㅋㅌㄴ')
			}
		}
	})
} //end of init()
//변경 처리
function modStudent() {

}



//한건 추가!!!!!
function addStudent(e) {
	e.preventDefault(); //subMit =>차단
	console.log(e);
	let xhtp = new XMLHttpRequest(); //비동기방식으로 서버에 파일 요청 

	let no = document.querySelector('input[name=sno]').value;
	let name = document.querySelector('input[name=sname]').value;
	let eng = document.querySelector('input[name=eScore]').value;
	let kor = document.querySelector('input[name=kScore]').value;
	//위 변수들을 아래의 addStudentServlet?안으로 넣어줌 
	//이렇게 해서 AddStudentServ안에 기능이 또있음 
	//불러와야할 필드의 이름이 일치하지않으면 언디파인 임 
	xhtp.open('get', `addStudentServlet?sno=${no}&sname=${name}&eScore=${eng}&kScore=${kor}`);
	xhtp.send();
	xhtp.onload = function() {  //로드후 정보를 받아오고나서 실행할 기능 
		console.log(xhtp.responseText); //{"retCode" : "Success"}
		let result = JSON.parse(xhtp.responseText);//{"retCode" : "Success"}
		if (result.retCode == 'Success') {
			//성공시 리스트 새로운 값 추가 
			successCallBack2(result); //result=>{retCode:?, stuNo:?,studName:?, escore:?,kscore:?}
		} else if (result.retCode == 'Fail') {
			//실패시 처리중 에러 발생 메시지 출력 \
			failCallBack();
		}
	}//end of function()
}//end of addStudent(e)


function makeTr(student) {
	console.log(student);
	let tr = document.createElement('tr');
	tr.setAttribute('id', student.studentNo);
	//라인삭제를 id로 지정하여 getElemtById(id).remove(); 함
	for (let field in student) { //student
		let td = document.createElement('td');
		td.innerHTML = student[field];
		tr.appendChild(td);
	}
	//삭제버튼 생성 
	let delBtn = document.createElement('button'); //<button></button>
	delBtn.innerHTML = '삭제';

	//이벤트 등롱
	delBtn.addEventListener('click', function() {
		//삭제(id파익 =>ajax호출) :this => 이벤트를 클릭한것의 대상 delBtn
		let id = this.parentElement.parentElement.firstChild.innerHTML;
		console.log(id);
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'delStudentServlet?delId=' + id);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				alert(result.retVal + '번이 삭제되었습니다.');
				document.getElementById(result.retVal).remove();
			} else {
				console.log(result.retVal);
			}
		}
	});


	let td = document.createElement('td'); //<td></td>
	td.appendChild(delBtn); //<td><button>삭제</button></td>
	tr.appendChild(td);


	return tr;
} //end of makeTr(student)

//정상적으로 실행되면 실행되는 콜백 함수
function successCallBack2(retObj) {
	console.log(retObj);
	//가져올때도 필드 이름이 같아야만 가져올수있음 
	let obj = {
		studentNo: retObj.studentNo,
		studentName: retObj.studentName,
		engScore: retObj.engScore,
		korScore: retObj.korScore

	}
	document.getElementById('list').appendChild(makeTr(obj));

} //end of successCallBack2()

//정상적으로 실행되면 실행되는 콜백 함수
function successCallBack() {
	//사용자가 입력햇던 값을 id='list' 하위에 추가 
	let no = document.querySelector('input[name=sno]').value;
	let name = document.querySelector('input[name=sname]').value;
	let eng = document.querySelector('input[name=eScore]').value;
	let kor = document.querySelector('input[name=kScore]').value;




	let obj = { no, name, eng, kor };
	let row = makeTr(obj);

	document.getElementById('list').appendChild(row)



}

function failCallBack() {
	alert('처리중 에러 발생 ')
}