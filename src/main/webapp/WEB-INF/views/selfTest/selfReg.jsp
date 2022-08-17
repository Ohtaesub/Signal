<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
<style></style>
</head>
<body>
<form action="selfReg.do" method="post">
	<table>
		<thead>
			<tr>
				<th>질문</th>
				<th>점수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="selfTest">
				<tr id="st_${selfTest.st_no}">
					<td>
						<input type="hidden" name="cl_id" id="cl_id" value="${cl_id}"/>
						<input type="hidden" name="st_no" id="st_no" value="${selfTest.st_no}"/>${selfTest.st_que}
					</td>
					<td id="hh">
						<select name="st_score" id="ss_${selfTest.st_no }">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">셀프코멘트</th>				
			</tr>
			<tr>
				<td colspan="2"><textarea name="st_comment"></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="완료"/>
					<input type="button" onclick="window.close()" value="닫기"/>
				</th>				
			</tr>
		</tbody>
	</table>	
</form>
</body>
<script>
	$('select[name="st_score"]').change(function(){
		$tr = $(this).parent().parent();
		console.log($tr);			
		var cl_id = $tr.find('#cl_id').val();
		var st_no = $tr.find('#st_no').val();
		var st_score = this.value;
		console.log(cl_id + '/' + st_no + '/' + st_score);
		location.href="scoreReg.do?cl_id="+cl_id+"&&st_no="+st_no+"&&st_score="+st_score;
	})
</script>
</html>