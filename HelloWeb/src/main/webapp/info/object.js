// object.js
// 변수 선언
//{key:value},{key:value} 맵타입과 비슷
let member1 = {
  fullName: 'Hong',
  age: 20,
  score: 80
};
let member2 = {
  fullName: 'Hwang',
  age: 22,
  score: 88
}
let member3 = {
  fullName: 'Park',
  age: 25,
  score: 92
}
member1.fullName = '홍';
console.log(member1.fullName);
console.log(member2.age);
console.log(member1.age + member2.age);

const members = [member1, member2, member3];
//홍의 나이는 20 이고 점수는 80입니다.
for (let i = 0; i < members.length; i++) {
  console.log(members[i].fullName + '의 나이는 ' + members[i].age +
    '이고 점수는' + members[i].score + '입니다')
}
document.write('<h1>즐거운 자바</h1>')
document.write('<ul>')
for(i = 0; i < members.length; i++){
document.write (
'<li>'+members[i].fullName+','+members[i].age+','+members[i].score+'</li>')
document.write (`<li>${members[i].fullName},${members[i].age},${members[i].score}`)
}
document.write('</ul>')
let welcome=`안녕하세요
              반갑습니다.`;