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
	<form action="companyStateChange.do" method="post" onsubmit="companyStateUpdate()">
		<input type="hidden" name="com_id" value="${companyState.com_id}"/>
		<table>
			<tr>
	            <th>아이디</th>
	            <td>${companyState.com_id}</td>
	        </tr>
	        <tr>
	            <th>이름</th>
	            <td>${companyState.com_name}</td>
	        </tr>
	        <tr>
	            <th>회원상태</th>
	            <td>
	            	<select name="com_state" id="com_state">
	            		<option ${companyState.com_state == '기업회원' ? 'selected="selected"' : ''}>기업회원</option>
	            		<option ${companyState.com_state == '탈퇴회원' ? 'selected="selected"' : ''}>탈퇴회원</option>
	            	</select>
	            </td>
	        </tr>
	        <tr>
	            <th>수정사유</th>
	            <td>
	            	<input type="text"  name="com_admin_re" id="com_admin_re" value="${companyState.com_admin_re}"/>
	            </td>
	        </tr>
		</table>
		<input type="submit" value="수정"/>
	</form>
</body>
<script>
	function companyStateUpdate(){
		confirm("정말로 수정하시겠습니까?");
		var msg = "${msg}";
		if(msg){
			opener.document.location.href="redirect:/companyManagementList.do";
			self.close();
		}
	}
</script>
</html>