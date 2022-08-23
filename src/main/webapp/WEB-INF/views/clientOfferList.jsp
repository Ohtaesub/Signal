<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>개인 마이페이지 입사제안현황</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
/* 메인 섹션 영역 */
#section {
	width : 800px;
	position: relative;
	top : -380px;
	left : 350px;
}
button {
	  	padding:5px 10px;
	  	font-size:12px;
	  	outline:none;
	  	border:none;
	  	color:#fff;
	  	background-color:#333;
}

</style>
</head>
<body>
	<div id="section">
	<h5>마이페이지 > 입사제안현황</h5>
	<br>
	<form action="deleteOffer.do" method="post">
	<button>삭제</button>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"/></th>
				<th>공고 제목</th>
				<th>기업명</th>
				<th>제안날짜</th>
				<th>열람여부</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${clientOfferList.size() >0}">
					<c:forEach items="${clientOfferList}" var="item">
						<tr>
							<td><input type="checkbox" name="chkArr" class="chkArr" value="${item.offer_no}" /></td>
							<td><a href="/jobPostingDetail.go?offer_no=${item.offer_no}&jpo_no=${item.jpo_no}&com_id=${item.com_id}&curState=0">${item.jpo_title}</a></td>
							<td>${item.com_name}</td>
							<td>${item.offer_date}</td>
							<td>${item.reading_state}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
	     			<tr>
	     				<td colspan="10" style="text-align: center">받은 입사제안이 없습니다.</td>
	     			</tr>
	     		</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	</form>
	
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
	</div>
</body>
<script>
$("#checkAll").on("click",function(){
	$("input:checkbox").prop("checked",$(this).prop("checked"));
});


$(".chkArr").on("click",function(){
	if($(".chkArr").length == $(".chkArr:checked").length){
		$("#checkAll").prop("checked",true);
	}else {
		$("#checkAll").prop("checked",false);
	}
});
//by태섭, 페이징 작업_2022_08_12
//form 태그 값 가져와서 moveForm 변수에 담기
let moveForm = $("#moveForm");

//출력시킨 '페이지 이동 번호'가 동작시키기 위해 JS코드 작업
$(".pageInfo a").on("click", function(e){
	
	e.preventDefault();
    moveForm.find("input[name='pageNum']").val($(this).attr("href"));
    moveForm.attr("action", "/clientOfferList.go");
    moveForm.submit();    
    
});


</script>
</html>