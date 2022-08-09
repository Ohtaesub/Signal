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
<p>기업페이지 > 이의제기현황 <p>
<table>
    <colgroup>
       <col width="400"></col>
        <col width="250"></col>
        <col width="100"></col>
     
    </colgroup>
        <thead>
            <tr>
                <th>면접 및 지원자 정보</th>
                <th>이의내용</th>
                <th>처리상태</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${comObjectionList}" var="comObjectionList" >
                    <tr>
                        <td align="center">
                        	${comObjectionList.cl_photo} ${comObjectionList.cl_name} ${comObjectionList.cl_age}${comObjectionList.cl_gender}
                        <a href="comInterviewUpdate.go?inter_no=${comObjectionList.inter_no}">${comObjectionList.jpo_title}</a>
                        	${comObjectionList.inter_date} ${comObjectionList.inter_result}  평점 ${comObjectionList.inter_grade}
                        		
                        </td>
                        <td align="center">${comObjectionList.obj_cl_content}</td>
                        <td align="center">
                        	<c:choose>
									<c:when test="${comObjectionList.obj_state eq 0}">미처리</c:when>					
									<c:when test="${comObjectionList.obj_state eq 1}">${comObjectionList.obj_date}처리완료</c:when>					
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