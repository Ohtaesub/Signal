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
				<th>	대분류	<button onclick="jpReg()" style="float:right;">등록</button></th>				
			</tr>
		</thead>
		<tbody id="jobClass">
			<c:forEach items="${jpList}" var="jp">
				<tr>									
					<td>
						<input type="hidden" class="jp_no" value="${jp.jp_no}"/>
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
				<th>중분류	<button onclick="jcReg(${jp_no})" style="float:right;">등록</button></th>				
			</tr>
		</thead>
		<tbody id="jobClass">
			<c:forEach items="${jcList}" var="jc">
				<tr>								
					<td>
						<input type="hidden" class="jp_no" value="${jp_no}"/>
						<input type="hidden" class="jc_no" value="${jc.jc_no}"/>						
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
</div>
</body>
<script>
function jpClick(no){
	location.href="jobchList.go?jp_no="+no;		
}

function jpReg(){
	window.open("jpReg.go","new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
}

function jcReg(no){	
	window.open("jcReg.go?jp_no="+no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
}

$('select[name="jp_hidden"]').change(function(){
	var jp_no = $(this).parent().parent().find('.jp_no').val();
	var jp_hidden = $(this).val();
	console.log(jp_no + '/' + jp_hidden);
	location.href="jp_hiddenUp.do?jp_no="+jp_no+"&&jp_hidden="+jp_hidden;
});

$('select[name="jc_hidden"]').change(function(){
	console.log($('select[name="jp_hidden"]').val());
	if($('select[name="jp_hidden"]').val()==0){
	var jc_no = $(this).parent().parent().find('.jc_no').val();
	var jc_hidden = $(this).val();
	var jp_no = $(this).parent().parent().find('.jp_no').val();
	console.log(jc_no + '/' + jc_hidden);
	location.href="jc_hiddenUp.do?jc_no="+jc_no+"&&jc_hidden="+jc_hidden+"&&jp_no="+jp_no;
	} else{
		var jp_no = $(this).parent().parent().find('.jp_no').val();
		alert("직무대분류 노출현황을 확인해주세요");
		location.href="jobchList.go?jp_no="+jp_no;
	}
});

</script>
</html>