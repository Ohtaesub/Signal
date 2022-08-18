<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
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
	<table style="width:49.5%; float:left;">
		<thead>
			<tr>
				<th>	대분류	<button style="float:right;">등록</button></th>				
			</tr>
		</thead>
		<tbody id="jobClass">
			<c:forEach items="${jpList}" var="jp">
				<tr>									
					<td>
						<button onclick="jpClick(${jp.jp_no})">${jp.jp_name}</button>
						<select style="float:right;" name="jp_hidden">
							<option value="0" ${jp.jp_hidden==0?'selected="selected"':''}>숨김</option>
							<option value="1" ${jp.jp_hidden==1?'selected="selected"':''}>노출</option>
						</select>
					</td>					
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	<table style="width:49.5%; float:right;">
		<thead>
			<tr>
				<th>	중분류	<button style="float:right;">등록</button></th>				
			</tr>
		</thead>
		<tbody id="jobClass">
			<c:forEach items="${jcList}" var="jc">
				<tr>								
					<td>
						<input type="hidden" value="${jc.jc_no}"/>
						${jc.jc_name}
						<select style="float:right;" name="jc_hidden">
							<option value="0" ${jc.jc_hidden==0?'selected="selected"':''}>숨김</option>
							<option value="1" ${jc.jc_hidden==1?'selected="selected"':''}>노출</option>
						</select>
					</td>				
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	<table class="hidden">
		<c:forEach items="${finList}" var="fin">
			<tr id="fin_${fin.jc_no}">									
				<td id="jp_no">${fin.jp_no}</td>
				<td id="jp_name">${fin.jp_name}</td>
				<td id="jc_no">${fin.jc_no}</td>
				<td id="jc_name">${fin.jc_name}</td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
<script>
function jpClick(no){
	location.href="jobchList.go?jp_no="+no;		
}
</script>
</html>