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
			<input type='radio' name='memberSelect' value='개인회원' />개인회원
   			<input type='radio' name='memberSelect' value='기업회원' />기업회원
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw" id="pw"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="login"/>
				</th>
			</tr>
		</table>
		<input type="button" value="ID 찾기" onclick="findId()"/>
		<input type="button" value="PW 찾기" onclick="findPw()"/>
	</form>
</body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>

	// 팝업창 닫기가 안대요..하...
	var loginId = "${loginId}";
	if(loginId=="true"){
		opener.document.location.reload();
		window.close();
	}
	
	function findId(){
		var memberSelect = $('[name=memberSelect]:checked').val();
		if(memberSelect=="개인회원"){
			window.opener.location.href="findClientId.go";
			window.close();
		}else if(memberSelect=="기업회원"){
			window.opener.location.href="findCompanyId.go";
			window.close();
		}else{
			alert("회원상태를 선택해주세요.");
			return false;
		}
	}
	
	function findPw(){
		var memberSelect = $('[name=memberSelect]:checked').val();
		if(memberSelect=="개인회원"){
			window.opener.location.href="findClientPw.go";
			window.close();
		}else if(memberSelect=="기업회원"){
			window.opener.location.href="findCompanyPw.go";
			window.close();
		}else{
			alert("회원상태를 선택해주세요.");
			return false;
		}
	}
	
</script>
</html>