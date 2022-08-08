<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../../resources/css/common.css" type="text/css"/>
</head>
<body>
	<jsp:include page="../../resources/inc/header_b.jsp"></jsp:include>
	<table>
		<thead>
			<tr>
				<th>나이</th>
				<th>성별</th>
				<th>면접평점</th>
				<th>면접코멘트수</th>
				<th>셀프평점</th>
				<th>입사제안</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="person">
				<tr>
					<td>${person.cl_age}</td>
					<td>${person.cl_gender}</td>
					<td>${person.avr_inter_grade}</td>
					<td>${person.cnt_inter}</td>
					<td>${person.avr_st_score}</td>
					<td><button onclick="#">입사제안</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script></script>
</html>