<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
table {
	width:100%;
	border:1px solid #787878;
	border-collapse:collapse;
}

table tr th {
	padding:10px;
	border:1px solid #787878;
	background-color:#efefef;
}
table tr td {
	padding:10px;
	border:1px solid #787878;
}
/* 페이지 이동 CSS 작업 */
.pageInfo{
      list-style : none;
      display: inline-block;
    margin: 50px 0 0 100px;      
  }
  .pageInfo li{
      float: left;
    font-size: 20px;
    margin-left: 18px;
    padding: 7px;
    font-weight: 500;
  }
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
 .active{
      background-color: #cdd5ec;
  }
/* 메인 섹션 영역 */  
#section {
	width : 800px;
	position: relative;
	top : -380px;
	left : 350px;
}


</style>
</head>
<body>
<div id="section">
<p>관리자페이지 > 이의제기관리 <p>
<form action="adminObjectionList.do" method="get" id="form">
     	<select name="searchOption" id="searchOption">
			<option value="">전체</option>
			<option value="개인회원" ${searchOption == '개인회원'? 'selected="selected"' : ''}>개인회원</option>
			<option value="기업회원" ${searchOption == '기업회원'? 'selected="selected"' : ''}>기업회원</option>
			<option value="기업명" ${searchOption == '기업명'? 'selected="selected"' : ''}>기업명</option>
	 	</select>
			<input  type="text"  name="search" id="search" value="${search}" required/>
			<button type="submit" >검색</button>
			<!-- 페이징  -->
		 	<input type="hidden" name="pageNum" value="1"/>
 </form>
<table>
    <colgroup>
        <col width="90"></col>
        <col width="70"></col>
        <col width="150"></col>
        <col width="80"></col>
        <col width="90"></col>
        <col width="100"></col>
    
    </colgroup>
        <thead>
            <tr>
                <th>일반회원 <br>블라인드</th>
                <th>기업회원</th>
                <th>기업명</th>
                <th>면접번호</th>
                <th>처리여부</th>
                <th>블라인드</th>          
        </thead>
        <tbody>
            
                <c:forEach items="${adminObjectionList}" var="adminObjectionList" >
                    <tr>
                        <td align="center">${adminObjectionList.cl_id}</td>
                        <td align="center">${adminObjectionList.com_id}</td>
                        <td align="center">${adminObjectionList.com_name}</td>
                        <td align="center"><a href="interviewDetail.go?inter_no=${adminObjectionList.inter_no}">${adminObjectionList.inter_no}</a></td>
                        <td align="center">
                        	<c:choose>
                        		<c:when test="${adminObjectionList.obj_state eq 0}">미처리</c:when>
                        		<c:when test="${adminObjectionList.obj_state eq 1}">처리완료</c:when>
                        	</c:choose>
                        </td>
                        <td align="center">
                        	<c:choose>
									<c:when test="${adminObjectionList.inter_blind eq 0}"></c:when>					
									<c:when test="${adminObjectionList.inter_blind eq 1}">
										<button type="button" onclick="blind(${adminObjectionList.inter_no})">블라인드</button>
									</c:when>					
							</c:choose>
                          	</td>
                    </tr>
                </c:forEach>
        </tbody>
    </table>
       <!--페이징 -->
    <div class="pageInfo_wrap" >
        <div class="pageInfo_area">
        		<ul id="pageInfo" class="pageInfo">
        		<!-- 이전페이지 버튼 -->
	                <c:if test="${pageMaker.prev}">
	                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
	                </c:if>
	        		
	        		
	 				<!-- 각 번호 페이지 버튼 -->
	                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	                    <li class='pageInfo_btn ${pageMaker.cri.pageNum == num ? "active": "" }'><a href="${num}">${num}</a></li>
	                </c:forEach>
	                
	                <!-- 다음페이지 버튼 -->
	                <c:if test="${pageMaker.next}">
	                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
	                </c:if> 
        		</ul>
        </div>
    </div>	
    	  <form id="moveForm" method="get">
	  	 <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	  </form>
</div>		
</body>
<script>
function blind(inter_no) {
		var chk = confirm("이의제기를 블라인드 처리 하겠습니까?");
		if (chk ==true) {
			location.href='adminBlind?inter_no='+inter_no;
		}else{
			
		}
	}	
	
$(".pageInfo a").on("click", function(e){
    e.preventDefault();
        if($("#searchOption").val()=="" && $("#search").val()==""){
    		$("#moveForm").find("input[name='pageNum']").val($(this).attr("href"));
        	$("#moveForm").attr("action", "/adminObjectionList.go");
    		$("#moveForm").submit();
        } else {
        	$("#form").find('input[name="pageNum"]').val($(this).attr("href"));
        	$("#form").submit();
        }
        
});

</script>
</html>