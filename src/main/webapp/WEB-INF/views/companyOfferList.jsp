<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>입사제안관리</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
table {
	width:100%;
	border:1px solid #787878;
	border-collapse:collapse;
}

table tr th {
	padding:10px;
	border:1px solid #787878;
	background-color:#efefef;
}
table tr td {
	padding:10px;
	border:1px solid #787878;
}
</style>
</head>
<body>
	<h5>기업페이지 > 입사제안관리</h5>
	<table>
		<thead>
			<tr>
				<th>이력서제목</th>
				<th>성별</th>
				<th>나이</th>
				<th>면접평점(수)</th>
				<th>셀프평점</th>
				<th>제안날짜</th>
			</tr>
		</thead>
		<tbody>		
			<c:choose>
				<c:when test="${offerList.size() > 0}">
					<c:forEach items="${offerList}" var="item">
						<tr>
							<td align="center">${item.re_title}</td>
							<td align="center">${item.cl_gender}</td>
							<td align="center">${item.cl_age}</td>
							<td align="center">${item.inter_grade_avg}(${item.gradeCnt})</td>
							<td align="center">${item.st_score_avg}</td>
							<td align="center">${item.offer_date}</td>
						</tr>
					</c:forEach>
				</c:when>
			<c:otherwise>
				<tr>
					<td>입사제안한 인재가 없습니다.</td>
				</tr>
			</c:otherwise>
			</c:choose>
		</tbody>		
	</table>
</body>
<script>

</script>
</html>