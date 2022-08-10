<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
<style>
.hidden{display:none;}
</style>
</head>
<body>
	<form action="socialUp.do" method="post">	
	<table>	
		<thead>
			<tr>
				<th class="hidden"></th>	
				<th>분류</th>
				<th>이름</th>
				<th>기간</th>
				<th>내용</th>
				<th></th>
			</tr>
		</thead>		
		<tbody>
			<c:forEach items="${socialDto}" var="social">
				<tr>
					<td class="hidden"><input type="text" name="soc_no" value="${soc_no}"></td>	
					<td><input type="text" name="soc_field" value="${social.soc_field}}"/></td>
					<td><input type="text" name="soc_name" value="${social.soc_name}"/></td>
					<td><input type="text" name="soc_period" value="${social.soc_period}"/></td>
					<td><input type="text" name="soc_content" value="${social.soc_content}"/></td>
					<td><input type="submit" value="수정"/><button onclick="licenseDelete()">삭제</button></td>
				</tr>
			</c:forEach>			
		</tbody>	
		<tr>
			<th colspan="5"><button onclick="window.close()">닫기</button></th>
		</tr>	
	</table>
	</form>
</body>
<script></script>
</html>