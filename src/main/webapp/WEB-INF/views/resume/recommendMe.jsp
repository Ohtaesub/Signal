<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../../resources/inc/header.jsp" %>
<style>
	.section {
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
	<div class="section">
		<input type="radio" name="recommend" value="recommendMe" checked/> 나를 추천
		<input type="radio" name="recommend" value="recommendYou"/> 내가 추천
	</div>
	<table class="section" id="recommendMe">
		<thead>
			<tr>
				<th colspan="4"><button onclick="recommendReg()">추천요청</button></th>
			</tr>
			<tr>
				<th class="hidden">ID</th>
				<th>추천인ID</th>
				<th>관계</th>
				<th>추천날짜</th>
				<th>추천내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="recoMe">
				<tr>
					<td class="hidden" id="cl_id">${recoMe.cl_id }</td>
					<td>${recoMe.reco_cl_id}</td>
					<td>${recoMe.reco_relation}</td>
					<td>${recoMe.reco_date}</td>
					<td>${recoMe.reco_req_memo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table class="section" id="recommendYou" style="display:none;">
		<thead>
			<tr>
				<th>ID</th>
				<th>추천날짜</th>
				<th>요청메모</th>
				<th>추천내용</th>
				<th></th>
				<th>응답여부</th>
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
	</table>
	
</body>
<script>
listCall();
function listCall(){
	$.ajax({
		type:'get',
		url:'recommendYou.ajax',
		data:{},
		dataType:'JSON',
		success:function(data){
			// console.log(data);
				console.log('테이블 그리기');
				drawList(data.list);							
		},
		error:function(error){
			console.log(error);
		}
	})
}

function drawList(list){
	var content ='';
	list.forEach(function(item,idx){
		console.log(item);
		content += '<tr id="cl_'+item.reco_no+'">';		
		content += '<td>'+item.cl_id+'</td>';
		content += '<td>'+item.reco_date+'</td>';
		content += '<td>'+item.reco_content+'</td>';
		content += '<td>'+item.reco_req_memo+'</td>';
		content += '<td>'+item.reco_no+'</td>';
		content += '<td class="state">'+item.reco_state+'</td>';
		content += '</tr>';		
	});
	$('#list').empty();
	$('#list').append(content);		
	
	list.forEach(function(item,idx){
		console.log(item.reco_state);
		if($('#cl_'+item.reco_no+' .state').html()=='무응답'){
			$('#cl_'+item.reco_no+' .state').html("<button onclick='recommendU("+item.reco_no+")'>응답하기</button>");			
		}
	});	
}
	
function recommendU(reco_no){
	window.open("recommendYouPop.go?reco_no="+reco_no,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
}	


function recommendReg(){
	var cl_id = $("#cl_id").html();
	 window.open("recommendMePop.go?cl_id="+cl_id,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	 
	 }



$("input:radio[name='recommend']").change(function(){
	recommend();	
});

function recommend(){
	var chk = $("input:radio[name='recommend']:checked").val();
	console.log(chk);
	if(chk == "recommendMe"){
		$("#recommendYou").css("display","none");
		$("#recommendMe").css("display","");
	}else{
		$("#recommendMe").css("display","none");
		$("#recommendYou").css("display","");
	}
}	
</script>
</html>