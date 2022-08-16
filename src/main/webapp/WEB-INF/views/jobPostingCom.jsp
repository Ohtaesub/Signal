<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<style>


	   	table,h2,h6{
	   		width: 60%;
	   		margin: 0 auto;
	   }
	   h3{
   	   		width: 60%;
	   		margin: 0 auto;
	   		text-align: left;
	   		margin-bottom: 10px;
	   }
	   	table,th,td{
		   	border: 1px solid gray;
		   	border-collapse: collapse;
	  		padding: 3px;
	   }
	   	th{
	   		font-size: 15px;
	   		font-weight: bold;
	   		text-align: center;
	   	}
		h2{
			margin-bottom: 10px;
			text-align: center;
		}
		.find-btn{
			text-align: right;
			margin-top: 10px;
		}
		.find-btn1{
			display :inline-block;
			color: #fff;
			border-radius: 5px;
			width: 100px;
			height: 30px;
			background-color: #1f3864ff;
		}

		table#comList < td{
			text-align: left;
			border-collapse : collapse;
		}
		table#comList {
			width: 60%;
	   		margin: 0 auto;
		}
		.cen{
			text-align: center;
		}
		img{
			width: 200px;
			height: 160px;
		}
		
	</style>
</head>
<body>
   <section>
    <div id="jp_list">
       	<h6>기업페이지 > 채용공고관리</h6>
       	<br/>
       	<h3>기업정보</h3>
       	<div>
       		<table id="infoList">
       			<tr>
       				<th rowspan="4">
       					<c:forEach items="${list}" var="path">
                  				<p><img src="/photo/${dto.ci_photo}" alt="로고"></p>
                  		</c:forEach>
               		</th>
       			</tr>
       			<tr>
       				<td colspan="5">${dto.com_name}</td>
       			</tr>
   			    <tr>
       				<td>기업주소 : </td>
       				<td colspan="4">${dto.com_address}</td>
       			</tr>
   			    <tr>
       				<td colspan="2">면접 코멘트 작성률 : </td>
       				<td>${dto.comment_a}%</td>
      					<td>코멘트 수: </td>
       				<td>${dto.comment}/${dto.apply}개</td>
       			</tr>
       		</table>
     	  	<br/>	
       		<div class="find-btn">
       			<input class="find-btn1" type="button" value="신규 공고 등록" onclick="location.href='/jobPostingWrite.go'">
			</div>
       	</div>
       	<br/>
       	
       	
			<div>
			<select id="pagePerNum" >
				<option value="all">채용공고 상태</option>
				<option value="진행중">진행중</option>
				<option value="마감">마감</option>
			</select>


			<table id="postingList">
				<thead>
			   		<tr>
						<th width="10px">번호</th>
					    <th width="150px">채용공고 제목</th>
						<th width="100px">모집기간</th>
						<th width="30px">조회수</th>
						<th width="50px">마감여부</th>
			         </tr>
		    	</thead>
		    	
		     	<tbody>
   				<c:forEach items="${jpoList}" var="jpoList">
   					<tr>
						<td class="cen">${jpoList.jpo_no}</td>
						<td><a href="jobPostingDetail.do?jpo_no=${jpoList.jpo_no}" >${jpoList.jpo_title}</a></td>
						<td class="cen">${jpoList.jpo_start} ~ ${jpoList.jpo_deadline}</td>
						<td class="cen">${jpoList.jpo_views}</td>
						<td class="cen">${jpoList.jpo_state}</td>
					</tr>
			</c:forEach>
	     		</tbody>
     		</table>
            	<input id="button1" type="button" value="삭제하기" onclick="cstDel()"/>
	            <!-- plugin 사용법(twbspagination) , 이렇게 쓰라고 명시되어있음. -->
	            <div class="container">
	               <nav arial-label="Page navigation">
	              	 <ul class="pagination" id="pagination"></ul>
	               </nav>
				</div>
			</div>
		</div>
	</section>
	<br/>   
</body>
<script>
var currPage = 1;

eduListCall(currPage);
//페이징 처리
$('#pagePerNum').on('change',function(){
	console.log("currPage: " + currPage);
  //페이지당 보여줄 수 변경시 계산된 페이지 적용이 안된다.(플러그인의 문제)
  //페이지당 보여줄 수 변경시 기존 페이지 요소를 없애고 다시 만들어 준다.
  $("#pagination").twbsPagination('destroy');   
  eduListCall(currPage);
});

function eduListCall(jp_list){
	
   var pagePerNum = $('#pagePerNum').val();
   console.log("param page : " +jp_list);
   $.ajax({
      type:'GET',
      url:'jobPosting.ajax',
      data:{
         cnt : pagePerNum,
         page : jp_list
			},
      dataType:'JSON',
      success:function(data){
         console.log(data);
         drawList(data.eduList);
         currPage = data.currPage;
         //불러오기가 성공되면 플러그인을 이용해 페이징 처리
         $("#pagination").twbsPagination({
       		startPage: data.currPage,//시작 페이지
           	totalPages: data.pages,//총 페이지(전체 게시물 수 / 한 페이지에 보여줄 게시물 수)
           	visiblePages: 5,//한번에 보여줄 페이지 수[1][2][3][4][5]
           	onPageClick:function(e,page){
               //console.log(e);//클릭한 페이지와 관련된 이벤츠 객체
             	console.log(jp_list);//사용자가 클릭한 페이지
               	currPage = jp_list;
               	eduListCall(jp_list);
            }
         });		         
      },
      error:function(e){
         console.log(e);
      }
   });
}



 
</script>
</html>