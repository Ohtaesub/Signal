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
	
	.hidden {
		display : none;
	}
</style>
<body>
	<table id="section">
		<thead>
			<tr>
				<th class="hidden"></th>
				<th>질문</th>
				<th>키워드</th>
				<th>노출상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="inter">
				<tr>
					<td class="hidden">${inter.it_no }</td>
					<td>${inter.it_que }</td>
					<td>${inter.it_keyword }</td>
					<td>
						<select name="it_hidden">										
							<option value="0" ${inter.it_hidden==0?'selected="selected"':''}>숨김</option>
							<option value="1" ${inter.it_hidden==1?'selected="selected"':''}>노출</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
<script>


</script>
</html>