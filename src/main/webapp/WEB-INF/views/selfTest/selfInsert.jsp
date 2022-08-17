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
		<h1>나를 판단하는 힘</h1>
		<h4>'그날의 분위기' 셀프평가</h4>
	</div>
	
	<div class="selfTestReg" id="section">
		<button onclick="selfTestReg()">셀프평가 등록</button>
		<input type="hidden" id="cl_id" value="${cl_id}"/>
	</div>
	
	<table class="selfResult" id="section">
		<thead>
			<tr><th><button onclick="selfTestUp()">셀프평가 수정</button></th></tr>
			<tr>
				<th>키워드</th>
				<th>점수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="self">
				<tr>					
					<td>${self.st_keyword}</td>
					<td>${self.st_score}</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">셀프 코멘트</th>				
			</tr>
			<tr>
				<td colspan="2">${st_comment }</td>
			</tr>
		</tbody>
	</table>
	
</body>
<script>
var result="${result}";
if(result=="true"){
	$('.selfTestReg').hide();
	$('.selfResult').show();	
}else{
	$('.selfTestReg').show();
	$('.selfResult').hide();	
}

function selfTestReg(){
	var cl_id=$('#cl_id').val();
	console.log(cl_id);
	 window.open("selfReg.go?cl_id="+cl_id,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
}


</script>
</html>