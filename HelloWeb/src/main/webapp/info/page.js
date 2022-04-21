//page.js
console.log(member1);
//멤버는 변수 풀네임은 속성
let field = 'fullName';
console.log(member1.fullName)
//좋은 것은 아래의 형태가 가지고 있음 
console.log(member2['fullName'])
//아래는 공정을 한번 더 거쳐야함 위는 바로 가져옴 
//기억은 맨 아래의 것을 기억 변수 선언후 끌어오는 것으로 
console.log(member3[field])
//멤버즈의 배열만큼 반복을 도는데 그걸 멤버에 담겟음 
//for of 는 위의 설명쓰
//배열 요소를 반복적으로 for..of
for (let member of members) {
  console.log(`이름은 ${member['fullName']}이고 
  나이는 ${member['age']}이고 점수는 ${member['score']}`)
}
//오브젝트의 속성(필드)을 반복적으로 하면 for..in
for (let prop in member1) {
  console.log(`${prop} => ${member1[prop]}`);
}

//각 배열요소의 각 필드를 출력 //자주 쓰임 
//for..in은 모든 것을 반복함 
for (let member of members) {
  for (let prop in member) {
    console.log(`${prop} => ${member[prop]}`);
  }
  console.log(`========================`);

}
//선택적으로 가져오고 싶을떄 //순서를 바꾸고 싶을때는 배열의 순서를 바꾸면 됨 
let fields=['fullName','score'];
for (let member of members) {
  for (let prop of fields) {
    console.log(`${prop} => ${member[prop]}`);
  }
  console.log(`========================`);

}
//화면에 표시 
document.write('<table border=1>');
let fiel=['fullName','score','age'];
for (let member of members) {
  document.write('<tr>');
  for (let prop of fiel) {
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write('<td><button>클릭</button></td>')
  document.write('</tr>');
  console.log(`========================`);

}
document.write('</table>');