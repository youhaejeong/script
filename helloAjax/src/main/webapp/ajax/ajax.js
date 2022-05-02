``/**
 * ajax.js
 */

let val = 10;
setTimeout(function() {
	val += 5;
	console.log('hello1->' + val);
	setTimeout(function() {
		val += 3;
		console.log('hello2->' + val);
		setTimeout(function() {
			val += 3;
			console.log('hello3->' + val);
		}, 1000)
	}, 1000)
}, 2000)
setTimeout(function() {
	val += 3;
	console.log('hello->' + val);
}, 1000);


let success = true;
//성공하면 첫번쨰 함수를 실패하면 두번째 함수를 싱행 
let promise = new Promise(function(resolve, reject) {
	if (success) {
		resolve('seuccess');
	} else {
		reject('error');
	}
});
//정상실행되면 덴
promise.then(function(result) {
	console.log(result)
})
	.then(function(result) {
		console.log(result)
	})
	.then(function(result) {
		console.log(result)
	})
	//실패하면 캐치
	.catch(function(err) {
		console.log(err)
	});

