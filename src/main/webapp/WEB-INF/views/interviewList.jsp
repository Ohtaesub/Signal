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
<table>
    <colgroup>
        <col width="170"></col>
        <col width="120"></col>
        <col width="100"></col>
        <col width="70"></col>
        <col width="70"></col>
        <col width="80"></col>
     
    </colgroup>
        <thead>
            <tr>
                <th>채용공고제목</th>
                <th>기업명</th>
                <th>면접일</th>
                <th>면접현황</th>
                <th>평점</th>
                <th>비고</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${interviewList}" var="interviewList" >
                    <tr>
                        <td align="center"><a href="clientObjectionReg.go?inter_no=${interviewList.inter_no}">${interviewList.jpo_title}</a></td>
                        <td align="center">${interviewList.com_name}</td>
                        <td align="center">${interviewList.inter_date}</td>
                        <td>${interviewList.inter_result}</td>
                        <td align="center">${interviewList.inter_grade}</td>
                        <td align="center">
	                         	<button type="button" onclick="location.href='clientObjectionReg.go?inter_no=${interviewList.inter_no}'">이의제기</button>
	                            <button type="button" onclick="location.href='interviewDetail.go?inter_no=${interviewList.inter_no}'">상세보기</button>
                         </td>
                         <td >
                    </tr>
                </c:forEach>
        </tbody>
    </table>		
</body>
<script>
</script>
</html>