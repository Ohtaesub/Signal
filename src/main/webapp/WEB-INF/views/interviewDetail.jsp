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
<form action="" method="get" >
    <table class="dto">
        
            <tr>
                <th>채용공고제목</th>
                <td>${dto.jpo_title} </td>
            </tr>
            <tr>
                <th>기업명</th>
                <td>${dto.com_name} </td>
            </tr>
            <tr>
                <th>면접일</th>
                <td>${dto.inter_date}</td>
            </tr>
            <tr>
                <th>면접현황</th>
                <td>${dto.inter_result}</td>
            </tr>
            <tr>
                <th>평점상세내역</th>
                <td>
                	<table>
	                	<c:forEach items="${interviewDetailResultList}" var="interviewDetailResultList" >
		                    <tr>
		                        <td align="center">${interviewDetailResultList.it_no} 번</td>
		                        <td align="center">${interviewDetailResultList.it_que}</td>
		                        <td align="center">${interviewDetailResultList.inter_score} 점</td> 
		                    </tr>
						</c:forEach>
                	</table>
                </td>
            </tr>
            <tr>
                <th>코멘트</th>
                <td>${dto.inter_comment}</td>
           </tr>
        </table>
        <input type="button" value="목록" onclick="location.href='/interviewList.go'"/>
    </form>		
</body>
<script>
</script>
</html>