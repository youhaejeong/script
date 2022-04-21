// refernece.js

const names =['조수연','황진주','권가희','이유빈'];

for(let i=0; i<names.length; i++){
  console.log(name[i]);
}
for(let i=0; i<names.length; i++){
  console.log((i+1)+'번째 이름 : '+names[i]);
}
//enhanced for , for(Strnig name : names){}
for(let name of names){
  console.log(name);
}

const numbers = [23, 44, 38, 12, 56];
for(let num of numbers){
  if(num>40){
    console.log(num);
  }
}
//자바의 스캐너 같은 것 
const inputs =[];
//배열 선언
for(let i=0; i<numbers.length; i++){
var inputVal = prompt('값을 입력하세요...');
console.log(typeof inputVal, inputVal);
inputs[i] = parseInt(inputVal);
}
//parseInt 문자를 숫자로 변환 시키는 함수 
//합계를 구하는 , 평균:
//변수를 선언하고 초기값을 줌 
let sum=0, avg;

for(let i=0; i<numbers.length; i++){
  sum +=inputs[i];
  }
  avg = sum/inputs.length;
  console.log(sum,avg);