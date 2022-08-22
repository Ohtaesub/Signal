<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
<style></style>
</head>
<body>	
	<table>
	<thead>
		<tr>
			<th>기업명</th>			
			<th>공고제목</th>			
			<th>직무 대분류</th>			
			<th>직무 중분류</th>			
			<th>시작일</th>			
			<th>마감일</th>			
			<th>코멘트 작성율</th>			
		</tr>
	</thead>
	<tbody>
		<tr>
			
		</tr>
	</tbody>
		<tr>
			<th colspan="6"><input type="submit" value="등록"/><input type="button" onclick="window.close()" value="닫기"/></th>
		</tr>
	</table>	
</body>
<script>
	var msg = "${success}";
	if(msg){
		alert("등록이 완료되었습니다");
		window.opener.location.reload();
		window.close(); 
	}

</script>
</html>