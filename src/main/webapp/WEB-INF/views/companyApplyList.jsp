<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
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
</style>
</head>
<body>

	<table>
		<thead>
			<tr>
			    <th colspan="4">지원자정보</th>
			    <th>면접평점(수)</th>
			    <th>셀프평점</th>
			    <th>열람여부</th>
			    <th>지원날짜</th>
			    <th>면접날짜</th>
			    <th>면접상태</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${companyApplyList.size()>0}">
					<c:forEach items="${companyApplyList}" var="item">
						<tr>
						    <td rowspan="2">${item.cl_photo}</td>
						    <td>${item.cl_name}</td>
						    <td>${item.cl_age}</td>
						    <td>${item.cl_gender}</td>
						    <td rowspan="2">${item.inter_grade_avg}(${item.gradeCnt})</td>
						    <td rowspan="2">${item.st_score_avg}</td>
						    <td rowspan="2">${item.reading_state}</td>
						    <td rowspan="2">${item.apply_date}</td>
						    <td rowspan="2">
						    		<c:choose>
										<c:when test="${empty item.inter_date}">
												<button type="button" onclick="pop1(${item.inter_no});">날짜등록</button>
										</c:when>					
										<c:otherwise>
													${item.inter_date}<br>
											      <button type="button" onclick="pop2(${item.inter_no});">날짜수정</button>
										</c:otherwise>
									</c:choose>
						    </td>
						    <td rowspan="2">${item.inter_result}<br>
						    	<c:choose>
						    		<c:when test="${empty item.inter_comment && empty item.inter_date}">
											
										</c:when>
										<c:when test="${empty item.inter_comment}">
												<button type="button" onclick="pop3(${item.inter_no});">결과등록</button>
										</c:when>							
										<c:otherwise>
											     <button type="button" onclick="pop4(${item.inter_no});">결과수정</button>
										</c:otherwise>
						    	</c:choose>
						    </td>
						</tr>
						<tr>
					    	<td colspan="3">${item.re_title}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="10" style="text-align: center">지원자가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	<!-- //by태섭, 페이징 작업_2022_08_17 -->
	<!-- '페이지 인터페이스'를 작업을 위한 <div> 태그를 작성 -->
	<div class="pageInfo_wrap" >
        <div class="pageInfo_area">
 			<ul id="pageInfo" class="pageInfo">
 				<!-- 이전페이지 버튼 -->
                <c:if test="${pageMaker.prev}">
                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
                </c:if>
 				<!-- 각 번호 페이지 버튼 -->
                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <li class="pageInfo_btn" ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
                </c:forEach>
                <!-- 다음페이지 버튼 -->
                <c:if test="${pageMaker.next}">
                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
                </c:if>
 			</ul>
        </div>
    </div>	
	<!-- value값은 현재 페이지의 정보가 저장되도록 하였습니다. 
	이는 현 페이지에서 '조회, 수정 페이지'로 이동하였다가 다시 현 페이지로 이동하기 위해 작성한 것인데 이에 대해 선 다음 포스팅에서 알아봅니다. -->
	<form id="moveForm" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
        <input type="hidden" name="amount" value="${pageMaker.cri.amount }">   
	</form>
	
</body>
<script>
//by태섭, 페이징 작업_2022_08_17
//form 태그 값 가져와서 moveForm 변수에 담기
let moveForm = $("#moveForm");

//출력시킨 '페이지 이동 번호'가 동작시키기 위해 JS코드 작업
$(".pageInfo a").on("click", function(e){
	
	e.preventDefault();
	moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	moveForm.attr("action", "/companyApplyList.go");
	moveForm.submit();    

});


//by태섭, 팝업창_2022_08_17
/* function interviewPopup(){
	var child;
	var url = 'companyApplyPopup.go?cl_id='+$("#cl_id").val()+'&inter_no='+$("#inter_no").val();
	child = window.open(url, "popup_child", "width=300, height=300, left=300, top=300");	
}
 */
 
 
 
 
 function pop1(inter_no){
		
	 window.open("companyApplyPopup.go?inter_no="+inter_no, '',  'width=500, height=300, left=100, top=50'); 
	 
	 return false;

}
 function pop2(inter_no){
		
	 window.open("comInterviewDate.go?inter_no="+inter_no, '', 'width=550, height=300, left=100, top=50'); 
	 
	 return false;

}
 
 function pop3(inter_no){
		
	 window.open("comInterview.go?inter_no="+inter_no, '', 'width=800, height=450, left=100, top=50'); 
	 
	 return false;

}
 
 function pop4(inter_no){
		
	 window.open("comInterviewUpdate.go?inter_no="+inter_no, '', 'width=800, height=450, left=100, top=50'); 
	 
	 return false;

}
 
 

</script>
</html>