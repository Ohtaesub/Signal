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
<p>마이페이지 > 면접현황 <p>
<form action="comInterviewUpdate.do" method="get" >
    <table class="dto">
           <tr>
				<th>면접결과선택</th>
				<td>
					<select name="inter_result" id="inter_result">
					<option value=""${dto.inter_result == '' ? 'selected="selected"' : ''}>결과선택</option>
	                <option value="불합격"${dto.inter_result == '불합격' ? 'selected="selected"' : ''}>불합격</option>
	                <option value="면접합격"${dto.inter_result == '면접합격' ? 'selected="selected"' : ''}>면접합격</option>
	                <option value="최종합격"${dto.inter_result == '최종합격' ? 'selected="selected"' : ''}>최종합격</option>   	
	                </select>
				</td>
			</tr>
            <tr>
                <th>질문별 점수 선택</th>
                <td>
                	<table>
	                	<c:forEach items="${que}" var="que" >
		                    <tr>
		                        <td align="center">${que.it_no}
		                        <input type="hidden" name="it_no" value="${que.it_no}">
		                        </td>
		                        <td align="center">${que.it_que}</td>
		                        <td align="center">
			                        <select name="inter_score" id="inter_score">
				                        <option value=""${que.inter_score == '' ? 'selected="selected"' : ''}>점수선택</option>
										<option value="1"${que.inter_score == '1' ? 'selected="selected"' : ''}>1</option>
										<option value="2"${que.inter_score == '2' ? 'selected="selected"' : ''}>2</option>
										<option value="3"${que.inter_score == '3' ? 'selected="selected"' : ''}>3</option>
										<option value="4"${que.inter_score == '4' ? 'selected="selected"' : ''}>4</option>
										<option value="5"${que.inter_score == '5' ? 'selected="selected"' : ''}>5</option>
										<option value="6"${que.inter_score == '6' ? 'selected="selected"' : ''}>6</option>
										<option value="7"${que.inter_score == '7' ? 'selected="selected"' : ''}>7</option>
										<option value="8"${que.inter_score == '8' ? 'selected="selected"' : ''}>8</option>
										<option value="9"${que.inter_score == '9' ? 'selected="selected"' : ''}>9</option>
										<option value="10"${que.inter_score == '10' ? 'selected="selected"' : ''}>10</option>
					                </select>
		                        </td> 
		                    </tr>
						</c:forEach>
                	</table>
                </td>
            </tr>
         
              <tr>
                <th>코멘트작성</th>
                <td>
               		 <textarea rows="10" cols="40" name="inter_comment" >${dto.inter_comment}</textarea>
                </td>
           </tr>
        </table>
        	<input type="hidden" name="inter_no" value="${dto.inter_no}">
        <input type= "submit" value="등록/수정">
        <input type="button" value="목록" onclick="location.href='/comInterviewList.go'"/>
    </form>		
</body>
<script>
</script>
</html>