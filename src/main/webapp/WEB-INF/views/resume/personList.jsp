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
</style>

<body>

	<table id="section">
		<tr>
			<td>
				<select id="searchCondition" name="">
					<option value="basic">기본</option>
					<option value="grade">면접평점순</option>						
				</select>
			</td>
			<td>나이검색</td>
			<td><input type="text" id="startAge" value=""/></td>
			<td>~</td>
			<td><input type="text" id="endAge" value=""/></td>
			<td><button type="button" id="personSearch">검색</button></td>
		</tr>
	</table>
	<table id="section">
		<thead>			
			<tr>
				<th>나이</th>
				<th>성별</th>
				<th>면접평점</th>
				<th>면접코멘트수</th>
				<th>셀프평점</th>
				<th>입사제안</th>				
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
		<tr>
			<td colspan="6" id="paging">
			<!-- twbspagination 플러그인 -->
				<div >
					<nav arial-label="Page navigation" style="text-align:center">
						<ul class="pagination" id="pagination"></ul>
					</nav>
				</div>
			</td>
		</tr>
	</table>	
</body>
<script>
var currPage = 1;

listCall(currPage);

function listCall(page){	
	var pagePerNum = 10;
	//console.log("param page : " + page);	
	$.ajax({
		type:'get',
		url:'personList.ajax',
		data:{
			cnt : pagePerNum,
			page : page
		},
		dataType:'JSON',
		success:function(data){
			//console.log(data);
			drawList(data.personList);
			currPage=data.currPage;
			
			//플러그인 사용 페이징
			$("#pagination").twbsPagination({
				startPage:data.currPage, //시작페이지
				totalPages:data.pages, //총 페이지(전체게시물 / 한 페이지에 보여줄 게시물 수)
				visiblePages: 10, // 한번에 보여줄 페이지 수
				onPageClick:function(e,page){
					console.log(page);
					currPage=page;
					listCall(page);
				}
			});			
		},
		error:function(e){
			console.log(e);
		}
	});	
}

$('#personSearch').on('click',function(){
	$("#pagination").twbsPagination('destroy');
	personSearch(currPage);
});

function personSearch(page){
	
	var pagePerNum = 10;
	
	 var searchCondition = $("#searchCondition option:selected").val();
	 console.log(searchCondition);
		 
	 var startAge = $("#startAge").val();
	 console.log(startAge);
	 
	 var endAge = $("#endAge").val();
	 console.log(endAge);
	 
	 $.ajax({
		 type:'get',
		 url:'personSearch.ajax',
		 data:{
			 cnt : pagePerNum,
			 page : page,
			 searchCondition : searchCondition,			 
			 startAge : startAge,
			 endAge : endAge 
		 },
		dataType:'json',
		success:function(data){
			console.log(data);
			drawList(data.personList);
			currPage = data.currPage;
			
			//플러그인 사용 페이징
			$("#pagination").twbsPagination({
				startPage:data.currPage, //시작페이지
				totalPages:data.pages, //총 페이지(전체게시물 / 한 페이지에 보여줄 게시물 수)
				visiblePages: 10, // 한번에 보여줄 페이지 수
				onPageClick:function(e,page){
					console.log(page);
					currPage=page;
					personSearch(page);
				}
			});
		},
		error:function(e){
			console.log(e);
		}
	 });

	}

function drawList(personList){
	
	var content="";
	
	personList.forEach(function(item){
				
		//console.log(item);
		content += '<tr>';
		content += '<td>'+item.cl_age+'</td>';
		content += '<td>'+item.cl_gender+'</td>';
		content += '<td>'+item.avr_inter_grade+'</td>';
		content += '<td>'+item.cnt_inter+'</td>';
		content += '<td>'+item.avr_st_score+'</td>';
		content += '<td><button onclick="#">입사제안</button></td>';
		content += '</tr>';
	});
	
	$('#list').empty();
	$('#list').append(content);
}

</script>
</html>