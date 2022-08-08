<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../../resources/inc/header.jsp" %>

<style>
	#section {
		width : 800px;
		position: relative;
		top : -380px;
		left : 350px;
	}
</style>

<body>

	<table id="section">
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