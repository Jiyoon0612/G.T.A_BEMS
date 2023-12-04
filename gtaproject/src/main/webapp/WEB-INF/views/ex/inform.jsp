<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 게시판</title>
<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

</head>
<body>

	<section class="page-section" id="contact">
		<div class="container" style="margin-top: 100px;">
			<div class="d-flex justify-content-end" style="height: 40px">
				<!-- 검색 폼 -->
				<select class="form-select me-1" id="searchOption"
					aria-label="Default select example" style="width: 100px">
					<option value="전체" selected>전체</option>
					<option value="공지">공지</option>
					<option value="고장">고장</option>
				</select> <input class="form-control me-1" type="text" value="" id="keyword"
					style="width: 200px">
				<!-- 비동기로 요청을 보내는 버튼 -->
				<button class="btn btn-primary" type="button"
					onclick="searchInform()">검색</button>
			</div>
			<table class="table table-hover" id="informTable">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>직책</th>
						<th>제목</th>
						<th>작성시간</th>
					</tr>
				</thead>
				<tbody>
					<!-- 검색 결과가 표시될 부분 -->
					<c:forEach items="${informList}" var="inform">
						<tr>
							<td>${inform.iNum}</td>
							<td>${inform.iName}</td>
							<td>${inform.iRank}</td>
							<td><a
								href="<c:url value='/inform/detail?iNum=${inform.iNum}'/>">${inform.iTitle}</a></td>
							<td>${inform.iDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/inform/write" />
			<button type="button" class="btn btn-primary">글쓰기</button>
			</a>
		</div>
	</section>
<script>
	// 비동기 요청 함수
	function searchInform() {
		var searchOption = $("#searchOption").val();
		var keyword = $("#keyword").val();

		$.ajax({
			type : "GET",
			url : "/inform/search",
			data : {
				searchOption : searchOption,
				keyword : keyword
			},
			success : function(data) {
				// 성공적으로 데이터를 받았을 때 처리
				var tableBody = $("#informTable tbody");
				tableBody.empty(); // 기존 행을 모두 지워줍니다.

				// 받은 데이터로 행을 추가합니다.
				$.each(data, function(index, inform) {
					var row = "<tr>" + "<td>" + inform.iNum + "</td>" + "<td>"
							+ inform.iName + "</td>" + "<td>" + inform.iRank
							+ "</td>" + "<td><a href='/inform/detail?iNum="
							+ inform.iNum + "'>" + inform.iTitle + "</a></td>"
							+ "<td>" + inform.iDate + "</td>" + "</tr>";

					tableBody.append(row);
				});
			},
			error : function() {
				// 에러 발생시 처리
				alert("검색에 실패했습니다.");
			}
		});
	}
</script>
</body>
</html>
