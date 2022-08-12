<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>개인 마이페이지 입사지원현황</title>
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
	<h5>마이페이지 > 입사지원현황</h5>
	<table>
		<thead>
			<tr>
				<th>공고 제목</th>
				<th>기업명</th>
				<th>지원날짜</th>
				<th>지원결과</th>
				<th>면접날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${clientApplyList.size() >0}">
					<c:forEach items="${clientApplyList}" var="item">
						<tr>
							<td><a href="#">${item.jpo_title}</a></td>
							<td>${item.com_name}</td>
							<td>${item.apply_date}</td>
							<td>${item.inter_result}</td>
							<td>${item.inter_date}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
	     			<tr>
	     				<td colspan="10" style="text-align: center">지원한 회사가 없습니다.</td>
	     			</tr>
	     		</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
<script>

</script>
</html>