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



//login 페이지 input창 공백일시 다음 페이지로 넘어가지 않음
function loginCheck() {
    var name = document.querySelector('#name');
    var pwd = document.querySelector('#pwd');

    if (name.value == "" || pwd.value == "") {
        alert("Please check your ID and password.");
        return false;
    }else{
		location.href = "dashboard.html";
	}
}


//로그인 페이지 체크박스 id 저장(쿠키)
$(document).ready(function(){
	var key = getCookie("idChk");
	if(key!=""){
		$("#name").val(key); 
	}
	 
	if($("#name").val() != ""){ 
		$("#idSaveCheck").attr("checked", true); 
	}
	 
	$("#idSaveCheck").change(function(){ 
		if($("#idSaveCheck").is(":checked")){ 
			setCookie("idChk", $("#name").val(), 7); 
		}else{ 
			deleteCookie("idChk");
		}
	});
	 
	$("#name").keyup(function(){ 
		if($("#idSaveCheck").is(":checked")){
			setCookie("idChk", $("#name").val(), 7); 
		}
	});
});
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
	var expireDate = new Date();
	expireDate.setDate(expireDate.getDate() - 1);
	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
	 
function getCookie(cookieName) {
	cookieName = cookieName + '=';
	var cookieData = document.cookie;
	var start = cookieData.indexOf(cookieName);
	var cookieValue = '';
	if(start != -1){
		start += cookieName.length;
		var end = cookieData.indexOf(';', start);
		if(end == -1)end = cookieData.length;
		cookieValue = cookieData.substring(start, end);
	}
	return unescape(cookieValue);
}