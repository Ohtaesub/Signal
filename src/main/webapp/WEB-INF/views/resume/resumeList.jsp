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
	
	.hidden {
		display : none;
	}
</style>
<body>
	
	<div id="section">
		<div>
			<button onclick="#">등록</button>
			<button onclick="#">수정</button>
			<button onclick="#">삭제</button>
		</div>
	<table>
		<thead>
			<tr>
				<th></th>
				<th>이력서 제목</th>
				<th>직무 대분류</th>
				<th>직무 소분류</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="resume">
				<tr>
					<td><input type="radio" name="re_no" value="${resume.re_no}"/></td>
					<td><a href="resumeDetail.do?re_no=${resume.re_no}">${resume.re_title}</a></td>
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