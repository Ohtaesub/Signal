<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<html>
<body>
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

</body>
<script></script>
</html>