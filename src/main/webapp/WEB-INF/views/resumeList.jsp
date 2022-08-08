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
	<div>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이력서 제목</th>
				<th>직무 대분류</th>
				<th>직무 소분류</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="resume">
				<tr>
					<td>${resume.re_no}</td>
					<td><a href="#">${resume.re_title}</a></td>
					<td>${resume.jp_name}</td>
					<td>${resume.jc_name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
<script></script>
</html>