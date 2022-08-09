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
<p>마이페이지 > 이의제기현황 <p>
<table>
    <colgroup>
       <col width="400"></col>
        <col width="250"></col>
        <col width="100"></col>
     
    </colgroup>
        <thead>
            <tr>
                <th>면접 및 기업 정보</th>
                <th>처리내용</th>
                <th>처리상태</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${clientObjectionList}" var="clientObjectionList" >
                    <tr>
                        <td align="center"><a href="interviewDetail.go?inter_no=${clientObjectionList.inter_no}">${clientObjectionList.jpo_title}</a>
                        		${clientObjectionList.com_name}<br/> ${clientObjectionList.inter_date} ${clientObjectionList.inter_result}  평점  ${clientObjectionList.inter_grade}
                        </td>
                        <td align="center">${clientObjectionList.obj_content}</td>
                        <td align="center">
                        	<c:choose>
									<c:when test="${clientObjectionList.obj_state eq 0}">미처리</c:when>					
									<c:when test="${clientObjectionList.obj_state eq 1}">${clientObjectionList.obj_date}처리완료</c:when>					
									
							</c:choose>
                        </td>
                    	
                    </tr>
                </c:forEach>
        </tbody>
    </table>		
</body>
<script>
</script>
</html>