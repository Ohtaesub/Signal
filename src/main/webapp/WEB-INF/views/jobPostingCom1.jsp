<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<style>
			#create{
			width: 250px;
			height: 100px;
			border: 1px solid lightgray; 
			border-radius: 10px;
			text-align: center;
			color: white;
			font-size:22px;
			font-weight: bold;
			background-color: gray;
		}
		textarea {
		   	width:100%;
		   	resize: none;
		   	height: 500px;
	   }
	   	table,h2,h6{
	   		width: 60%;
	   		margin: 0 auto;
	   }
	   	table,th,td{
		   	border: 1px solid gray;
		   	border-collapse: collapse;
	  		padding: 3px;
	   }
	   	th{
	   		font-size: 15px;
	   		font-weight: bold;
	   		height: 30px;
	   		width: 20%;
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
		
	</style>
</head>
<body>
   <section>
    <div id="jp-list">
       	<h6>기업페이지 > 채용공고관리</h6>
       	</br> 
       	<div>
       		<table id="infoList">
       			<tr>
       				<th rowspan="4">
       					<c:forEach items="${list}" var="path">
                  				<p><img src="/photo/${dto.ci_photo}" width="150" alt="로고"></p>
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
     	  	</br>
     	  	
       		<div class="find-btn">
       			<input class="find-btn1" type="button" value="신규 공고 등록" onclick="location.href='/jobPostingWrite.go'">
			</div>
       	</div>
       	</br>
       	
       	<form>
			<select name="sel" >
				<option value="all">채용공고 상태</option>
				<option value="진행중">진행중</option>
				<option value="마감">마감</option>
			</select>
			
		</form>
		
		<div>
			<table>
				<tr>
					<td colspan="5">공고제목</td>
					<th rowspan="5">
						<label><input type="radio" name="search_type" value="ing" checked />진행중</label></br>
						<label><input type="radio" name="search_type" value="end" />마감</label>   
					</th>										
				</tr>
				<tr>
					<td>모집분야</td>
					<td>학력</td>
					<td>지역</td>
					<td>근무형태</td>
				</tr>
				<tr>
					<td colspan="2">직무대분류</td>
					<td colspan="2">직무소분류</td>
				</tr>
				<tr>
					<td>모집시작일 : </td>
					<td>2022.08.11</td>
					<td>모집마감일 : </td>
					<td>2022.08.24</td>
				</tr>
				<tr>
					<td>조회수 : </td>
					<td colspan="4">500</td>
				</tr>
			</table>
		</div>
      	</br>
		
		
		
	</div>
	</section>
	   
</body>
<script>
/* 
 var currPage = 1;

listCall(currPage);

$('#pagePerNum').on('change',function(){
	console.log("currPage: " + currPage);
  //페이지당 보여줄 수를 변경시 계산된 페이지 적용이 안된다.(플러그인의 문제)
  //페이지당 보여줄 수를 변경시 기존 페이지 요소를 없애고 다시 만들어 준다.
  $("#pagination").twbsPagination('destroy');   
  listCall(currPage);    
});

 function listCall(page){
    
    var pagePerNum = $('#pagePerNum').val();
    console.log("param page : " +page);
    $.ajax({
       type:'GET',
       url:'recruitHistory.ajax',
       data:{
          cnt : pagePerNum,
          page : page,
          id : "${sessionScope.loginId}"
          },
       dataType:'JSON',
       success:function(data){
          console.log(data);
          drawList(data.list);
          currPage = data.currPage;
          //불러오기가 성공되면 플러그인을 이용해 페이징 처리
          $("#pagination").twbsPagination({
            startPage: data.currPage,//시작 페이지
            totalPages: data.pages,//총 페이지(전체 게시물 수 / 한 페이지에 보여줄 게시물 수)
             visiblePages: 5,//한번에 보여줄 페이지 수[1][2][3][4][5]
             onPageClick:function(e,page){
                //console.log(e);//클릭한 페이지와 관련된 이벤츠 객체
                console.log(page);//사용자가 클릭한 페이지
                currPage = page;
                listCall(page);
             }
          });
          
       },
       error:function(e){
          console.log(e);
       },
       beforeSend: function(xhr) {
    	 	// before : 전
     		// send : 전송
     		// ajax 를 전송하기 전에 실행할 함수
     		// xhr.setRequestHeader : 요청헤더를 설정한다. AJAX를 true로!

	   xhr.setRequestHeader("AJAX", true); //session 유지 도움 코드
   	   }
    });
 }
 
 function drawList(list){
    var content = '';
    list.forEach(function(item){
       
       var dateStart1 = new Date(item.recruit_start);
       var dateEnd1 = new Date(item.recruit_end);
       var writedate = new Date(item.recruit_date); 
       
       // 1. 마감여부(recruit_close)가 0(false)이면 "마감"이라는 표시가 나타난다. (1 = "모집중")
       // 2. 공고글을 작성 시, 마감여부(recruit_close)는 1(true / "모집중")이 기본값으로 들어간다.
       // 3. 모집공고 리스트를 보여줄 때, 모집마감일(recruit_end)이 시스템의 '오늘날짜(recruit_curdate)'보다 이전이라면 마감여부(recruit_close)는 0(false)로 변경된다(update).
       var closeYn = item.recruit_close;
       
       if(closeYn == 1) {
    	   closeYn = "모집중";
       } else
    	   closeYn = "마감";
       
       
       console.log(item);
       content += '<tr>';
       content += '<td>'+item.recruit_idx+'</td>';
       content += '<td><a href="recruit/detail.do?idx='+item.recruit_idx+'&field=all">'+item.recruit_title+'</a></td>';
       content += '<td>'+dateStart1.toLocaleDateString("ko-KR").replace(/\.$/, '')+' ~ '+dateEnd1.toLocaleDateString("ko-KR").replace(/\.$/, '')+'</td>';
       content += '<td>'+closeYn+'</td>';
       content += '<td>'+item.recruit_hits+'</td>';
       content += '<td>'+writedate.toLocaleDateString("ko-KR").replace(/\.$/, '')+'</td>';
       content += '</tr>';
    });
    $('#list').empty();
    $('#list').append(content);
 }
  */
</script>
</html>