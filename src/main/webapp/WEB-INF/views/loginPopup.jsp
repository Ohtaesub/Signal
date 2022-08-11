<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<form action="login.do" method="post">
		<h1>Login</h1>
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="com_id"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="com_pw"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="login"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>

</script>
</html>