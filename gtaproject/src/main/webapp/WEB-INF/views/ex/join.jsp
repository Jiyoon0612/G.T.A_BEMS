<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>

    <!-- 추가된 부분: 중복된 아이디 에러 메시지 출력 -->
    <c:if test="${not empty joinError}">
        <div style="color: red;">
            ${joinError}
        </div>
    </c:if>

    <form action="/joinDo" method="post">
        <label for="bId">아이디:</label>
        <input type="text" id="bId" name="bId" required><br>

        <label for="bPwd">비밀번호:</label>
        <input type="password" id="bPwd" name="bPwd" required><br>

        <label for="bName">이름:</label>
        <input type="text" id="bName" name="bName" required><br>
        
        <label for="bAddr">주소:</label>
        <input type="text" id="bAddr" name="bAddr" required><br>
        
        <label for="bHp">전화번호:</label>
        <input type="text" id="bHp" name="bHp" required><br>
        
        <input type="submit" value="가입하기">
    </form>
</body>
</html>
