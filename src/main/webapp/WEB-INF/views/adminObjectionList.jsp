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
<p>관리자페이지 > 이의제기관리 <p>
<input  type="search" name="ib_keyword" value="${pageMaker.ib_keyword}" id="ib_keyword">
<input type="submit" value="SEARCH" onclick="javascript:form.action='adminInquiryList.go';">
<table>
    <colgroup>
        <col width="90"></col>
        <col width="70"></col>
        <col width="150"></col>
        <col width="80"></col>
        <col width="90"></col>
        <col width="100"></col>
    
    </colgroup>
        <thead>
            <tr>
                <th>일반회원 </br>블라인드</th>
                <th>기업회원</th>
                <th>기업명</th>
                <th>면접번호</th>
                <th>처리여부</th>
                <th>블라인드</th>          
        </thead>
        <tbody>
            
                <c:forEach items="${adminObjectionList}" var="adminObjectionList" >
                    <tr>
                        <td align="center">${adminObjectionList.cl_id}</td>
                        <td align="center">${adminObjectionList.com_id}</td>
                        <td align="center">${adminObjectionList.com_name}</td>
                        <td align="center">${adminObjectionList.inter_no}</td>
                        <td align="center">
                        	<c:choose>
                        		<c:when test="${adminObjectionList.obj_state eq 0}">미처리</c:when>
                        		<c:when test="${adminObjectionList.obj_state eq 1}">처리완료</c:when>
                        	</c:choose>
                        </td>
                        <td align="center">
                        	<c:choose>
									<c:when test="${adminObjectionList.inter_blind eq 0}"></c:when>					
									<c:when test="${adminObjectionList.inter_blind eq 1}">
										<button type="button" onclick="location.href='adminSubjectManagementRevice.do?su_idx=${dto.su_idx}'">블라인드</button>
									</c:when>					
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