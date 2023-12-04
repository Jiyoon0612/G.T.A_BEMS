<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div id="container">
        <h2>로그인</h2>
        <!-- 추가된 부분: 에러 메시지 출력 -->
        <c:if test="${not empty loginError}">
            <div style="color: red;">
                ${loginError}
            </div>
        </c:if>
        <form method="post" action="<c:url value="/login.do" />">
            <div class="form-floating mb-3">
                <input class="form-control" name="memId" type="text" value="${cookie.rememberId.value }" placeholder="아이디를 입력해주세요 ">
                <label for="memId">아이디</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" name="memPw" type="password" placeholder="비밀번호를 입력해주세요 ">
                <label for="memPw">비밀번호</label>
            </div>
            <!-- 아이디 기억하기 -->
            
            <button id="loginButton" class="btn btn-primary btn-xl" type="submit">로그인</button>
            
            <!-- 가입하기 버튼 추가 -->
            <a class="nav-link py-3 px-0 px-lg-3 rounded" href="/join">회원가입</a>
            
        </form>
    </div>
</body>
</html>
