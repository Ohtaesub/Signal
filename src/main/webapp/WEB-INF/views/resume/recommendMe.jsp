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
	<table id="section" class="recommendMe">
		<thead>
			<tr>
				<th>추천인ID</th>
				<th>관계</th>
				<th>추천날짜</th>
				<th>추천내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="recoMe">
				<tr>
					<td>${recoMe.reco_cl_id}</td>
					<td>${recoMe.reco_relation}</td>
					<td>${recoMe.reco_date}</td>
					<td>${recoMe.reco_req_memo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table id="section" class="recommendYou">
		<thead>
			<tr>
				<th>ID</th>
				<th>추천날짜</th>
				<th>요청메모</th>
				<th>추천내용</th>
				<th>응답여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listB}" var="recoYou">
				<tr>
					<td>${recoYou.cl_id}</td>
					<td>${recoYou.reco_date}</td>
					<td>${recoYou.reco_content}</td>
					<td>${recoYou.reco_req_memo}</td>
					<td>${recoYou.reco_state}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
<script>


</script>
</html>