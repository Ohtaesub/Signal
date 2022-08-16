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
<p>이의제기처리 <p>
<form action="comObjectionUpdate.do" method="get" >
    <table class="dto">
        
           <tr>
				<th style="float:left">처리내용</th>
			</tr>
			<tr>
				<td>
					<textarea rows="10" cols="40" name="obj_content" id="obj_content"></textarea>
				</td>
			<tr>
            <tr>
                <th>	
	                <select style="float:center" name="obj_state" id="obj_state">
						<option value="0" ${dto.obj_state == '0' ? 'selected="selected"' : ''}>미처리</option>
						<option value="1" ${dto.obj_state == '1' ? 'selected="selected"' : ''}>처리완료</option>
					</select>
   				     <input type="submit" value="저장하기" />
   					<input type="hidden" name="obj_no" value="${dto.obj_no}">
				</th>
  				</tr>
        </table>
    </form>		
</body>
<script>
</script>
</html>