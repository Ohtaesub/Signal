<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
</head>
<body>
		<input type="hidden" name="cl_id" value="${clientState.ad_id}"/>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>상태</th>
					<th>상태변경날짜</th>
					<th>탈퇴사유</th>
					<th>상태변경사유</th>
				</tr>
			</thead>
			<tbody>
			<tr>
	            <td>${clientState.cl_id}</td>
	            <td>${clientState.cl_state}</td>
	            <td>${clientState.cl_break_date}</td>
	            <td>${clientState.cl_break_re}</td>
	            <td>${clientState.cl_admin_re}</td>
	        </tr>
			</tbody>
		</table>
</body>
<script>
</script>
</html>