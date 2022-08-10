<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
<style>
.hidden {display:none;}
</style>
</head>
<body>
	<form action="licenseUp.do" method="post">	
	<table>	
		<thead>
			<tr>				
				<th class="hidden"></th>
				<th>분류</th>
				<th>이름</th>
				<th>취득일</th>
				<th>발행기관</th>
				<th></th>
			</tr>
		</thead>		
		<tbody>
			<c:forEach items="${licenseDto}" var="license">
				<tr>					
					<td class="hidden"><input type="text" name="li_no" value="${license.li_no }"></td>
					<td><input type="text" name="li_field" value="${license.li_field}"/></td>
					<td><input type="text" name="li_name" value="${license.li_name}"/></td>
					<td><input type="text" name="li_org" value="${license.li_org}"/></td>
					<td><input type="text" name="li_date" value="${license.li_date}"/></td>
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