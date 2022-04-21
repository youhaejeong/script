//variable.js
//변수 선언할때 var 
var myName = '유해정'; //string
var yourName; //undefined //선언이 안된시점의 타입도 알수 있음 
myName = 100; //number
myName = true; //boolean
myName = null; //object

console.log(typeof yourName);
var yourName = "홍길동";
console.log(typeof yourName);

//전역 변수(스크립트 변수 ) /지역변수 (함수안에서 변수)
//함수가 실행하는동안에는 
//함수가 끝나는시점에서 사라짐 
function checkInfo() {
  var myName = 'youhaejeong';
  console.log(myName);
}
checkInfo();
console.log(myName);

//ES6 (ES2015) =>let, const
//let 블럭레벨 변수 선언 
// let myName="you";
function info() {
  let myName = "you";
  console.log(myName);
}
info(); {
  let myName = "you";
  console.log(myName);
} {
  let myName = "hwanh";
  console.log(myName);
}

const otherName = 'hong';
// otherName = 'hong';

//var,let =>변수 선언
// const =>상수선언