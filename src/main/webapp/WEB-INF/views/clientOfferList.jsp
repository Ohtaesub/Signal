<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>개인 마이페이지 입사제안현황</title>
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
</style>
</head>
<body>
	<h5>마이페이지 > 입사제안현황</h5>
	<form action="deleteOffer.do" method="post">
	<button>삭제</button>
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
							<td><a href="#">${item.jpo_title}</a></td>
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

//<td><input type="button" value="삭제" onclick="location.href='deleteOffer.do?offer_no=${item.offer_no}'"/></td>
//<td>삭제</td>
</script>
</html>