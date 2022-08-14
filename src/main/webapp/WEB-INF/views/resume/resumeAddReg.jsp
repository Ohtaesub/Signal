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
	<span id="re_no" class="hidden">${re_no}</span>
	<table id="section">
		<thead>
			<tr>
				<th colspan="4">경력사항 <button onclick="careerAdd()">추가</button> <button onclick="careerUp()">수정/삭제</button></th>
			</tr>
			<tr>
				<th>기업명</th>
				<th>근무기간</th>
				<th>직무</th>
				<th>근무내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${careerDto}" var="career">
				<tr>
					<td>${career.ca_com_name}</td>
					<td>${career.ca_period}</td>
					<td>${career.ca_job}</td>
					<td>${career.ca_content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<br/>
	<table id="section">
		<thead>
			<tr>
				<th colspan="4">그 외 활동 <button onclick="socialAdd()">추가</button> <button onclick="socialUp()">수정/삭제</button></th>
			</tr>
			<tr>
				<th>분류</th>
				<th>이름</th>
				<th>기간</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${socialDto}" var="social">
				<tr>
					<td>${social.soc_field}</td>
					<td>${social.soc_name}</td>
					<td>${social.soc_period}</td>
					<td>${social.soc_content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<br/>
	<table id="section">
		<thead>
			<tr>
				<th colspan="4">자격증/수상내역 <button onclick="licenseAdd()">추가</button> <button onclick="licenseUp()">수정/삭제</button></th>
			</tr>
			<tr>
				<th>분류</th>
				<th>이름</th>
				<th>취득일</th>
				<th>발행기관</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${licenseDto}" var="license">
				<tr>
					<td>${license.li_field}</td>
					<td>${license.li_name}</td>
					<td>${license.li_org}</td>
					<td>${license.li_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<script>
function careerAdd(){
	var re_no = $("#re_no").val();
	 window.open("careerReg.go?re_no="+re_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }

function careerUp(){
	var re_no = $("#re_no").val();
	 window.open("careerUp.go?re_no="+re_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }
	 
function socialAdd(){
	var re_no = $("#re_no").val();
	 window.open("socialReg.go?re_no="+re_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }

function socialUp(){
	var re_no = $("#re_no").val();
	 window.open("socialUp.go?re_no="+re_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }
	 
function licenseAdd(){
	var re_no = $("#re_no").val();
	 window.open("licenseReg.go?re_no="+re_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }

function licenseUp(){
	var re_no = $("#re_no").val();
	 window.open("licenseUp.go?re_no="+re_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }
	 
</script>
</html>