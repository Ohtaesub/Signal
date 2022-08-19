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
			<c:forEach items="${list}" var="person">
				<tr>
					<td>${person.cl_age }</td>
					<td>${person.cl_gender }</td>
					<td>${person.avr_inter_grade }</td>
					<td>${person.cnt_inter }</td>
					<td>${person.avr_st_score }</td>
					<td><button onclick="popOpen('${person.cl_id }')">입사제안</button></td>
				</tr>
			</c:forEach>
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


//by태섭, 입사제안 클릭 시 팝업창으로 채용공고 리스트 팝업창 호출
/* function showJobPostingList() {
	var url = "jobPostingList.go"
	var name = "jpoListPopup";
	var option = "width=700, height=400, left=200, top=50, scrollbars = yes, location= no"
	
	<input type="button" value="입사제안" onclick="offer.do?re_no"'+item.re_no+'/>
	
	window.open(url, name, option);
} */

function popOpen(id){
	window.open("offer.go?cl_id="+id,"new","width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
}

</script>
</html>