// input창 애니메이션
$(function() {
	'use strict';

	
  $('.form-control').on('input', function() {
	  var $field = $(this).closest('.form-group');
	  if (this.value) {
	    $field.addClass('field--not-empty');
	  } else {
	    $field.removeClass('field--not-empty');
	  }
	});

});


// 회원가입 페이지 유효성 검사
const username = document.querySelector("#name"); // const name은 내장 객체와 충돌이 나는 관계로 username 변수명을 사용함.
const pwd = document.querySelector("#pwd");
const rptPwd = document.querySelector("#rptPwd");
const hp = document.querySelector("#hp");
const bn = document.querySelector("#bn");
const addr = document.querySelector("#addr");
const button = document.querySelector("button");
const successMessage = document.querySelector(".success-message");
const failureMessageId = document.querySelector(".failure-message-id");
const failureMessagePw = document.querySelector(".failure-message-pw");
const mismatchMessage = document.querySelector(".mismatch-message");
const requiredMessage = document.querySelector(".required-message");


// username이 영어인지 체크
username.onkeyup = function(){
    if(engCheck(username.value)){
        failureMessageId.classList.add("hide");
    }
    else{
        failureMessageId.classList.remove("hide");
    }
}

// id 정규식
function engCheck(str) {
    // 영어만 사용 가능하며, 최소 1글자 이상이면 true를 리턴
    return /[a-zA-Z\d]+/.test(str);
  }


// password 유효성 검사
pwd.onkeyup = function(){
    if(strongPassword(pwd.value)){
        failureMessagePw.classList.add("hide");
    }
    else{
        failureMessagePw.classList.remove("hide");
    }
}

// password 정규식
function strongPassword(str) {
	// 소문자 알파벳과 대문자 알파벳이 각각 한 개 이상 포함
	// 최소한 하나의 숫자(0-9)가 포함
	// 하나의 특수문자(@, $, !, %, *, #, ?, &)가 포함
	// 총 8개 이상의 문자
	// 조건을 모두 충족해야지만 true를 리턴
	return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(str);
  }
  
// 패스워드 확인
rptPwd.onkeyup = function(){
    if(isMatch(pwd.value,rptPwd.value)){
        mismatchMessage.classList.add("hide");
    }
    else{
        mismatchMessage.classList.remove("hide");
    }
}

 // 패스워드 2개가 같다면 true를 리턴
function isMatch(password1, password2){
    if(password1===password2){
        return true;
    }
    return false;
}

function start() {
    var isUsernameValid = engCheck(username.value);
    var isPasswordStrong = strongPassword(pwd.value);
    var doPasswordsMatch = isMatch(pwd.value, rptPwd.value);

    if (username.value === "" || pwd.value === "" || rptPwd.value === "" || hp.value === "" || bn.value === "" || addr.value === "") {
        alert('All fields are required.');
        return false;
    }

    if (isUsernameValid && isPasswordStrong && doPasswordsMatch) {
        alert('Successful membership. Welcome aboard as a new member!');
        location.href = "dashboard.html";
    } else {
        alert('Please fill out all the columns according to the conditions.');
        return false;
    }
}

