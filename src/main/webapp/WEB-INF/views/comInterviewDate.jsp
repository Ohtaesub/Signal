<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style></style>
</head>
<body>
<form action="comInterviewDate.do" method="get" >
	<table class="dto">
		<colgroup>
			<col width="150"></col>
			<col width="150"></col>
		</colgroup>
		<tr>
			<th>해당 면접일</th>
			<td> ${dto.inter_date} </td>
		</tr> 
        <tr>
			<th>변경 면접일</th>
			<td>
				<input type="date" id="start" name="inter_date" value="inter_date"
                    min="2022-01-01" max="2024-12-31">
			</td>
		</tr>

		
	
	
    </table>
    
		 <input type="submit" value="변경"/>
        <input type="button" value="닫기" onclick="location.href='problemList.do'"/>
		
	</form>
</body>
<script>
</script>
</html>