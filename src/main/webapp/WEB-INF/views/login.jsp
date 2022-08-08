<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<input type="button" value="로그인" onclick="showPopup()" />
	<input type="button" value="회원가입" onclick="location.href='joinSelect.go'"/>
</body>
<script>
	function showPopup() {
		window.open("loginPopup.go", "login", "width=400, height=300, left=100, top=50");
		
	}
</script>
</html>