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
<form action="clentobjection.do" method="get" >
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
                <th>평점</th>
                <td>${dto.inter_grade}</td>
            </tr>
            <tr>
                <th>이의제기</th>
                <td><textarea rows="5" cols="30" name="pc_explan" id="pc_explan"></textarea></td>
           </tr>
        </table>
        <input type="submit" value="등록"/>
        <input type="button" value="목록" onclick="location.href='/interviewList.go'"/>
    </form>		
</body>
<script>
</script>
</html>