<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../../resources/inc/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>입사 제안</title>
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
	<h3>인재현황 제안하기</h3>
	<form action="offer.do" method="get">
	<input type="hidden" name="re_no" value="${re_no}"/>
	<table>		
		<thead>
			<tr>
				<th>나이</th>
				<th>성별</th>
				<th>면접평점</th>
				<th>면접코멘트수</th>
				<th>셀프평점</th>
				<th>채용공고명</th>
				<th>입사제안</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${personInfo}" var="item">
				<tr>
					<td>${item.cl_age}</td>
					<td>${item.cl_gender}</td>
					<td>${item.avr_inter_grade}</td>
					<td>${item.cnt_inter}</td>
					<td>${item.avr_st_score}</td>
					<td>
						<select name="jpo_no">
	                    	<option value="">채용공고명</option>
	                   		<c:forEach items="${jobPostingList}" var="jobPostingList">
	                   			<option value="${jobPostingList.jpo_no}" ${jpo_no eq jobPostingList.jpo_no ? 'selected' : ''}>${jobPostingList.jpo_title}</option>                   		
	                   		</c:forEach>       
                   		</select>
					</td>
					<td><button>제안하기</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" onclick="location.href='/personList.go'" value="목록"/>
	</form>
</body>
<script>

</script>
</html>