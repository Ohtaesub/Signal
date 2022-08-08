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
        <col width="70"></col>
        <col width="80"></col>
        <col width="90"></col>
        <col width="70"></col>
        <col width="70"></col>
        <col width="250"></col>
     	<col width="100"></col>
        <col width="80"></col>
    </colgroup>
        <thead>
            <tr>
                <th>면접번호</th>
                <th>사진</th>
                <th>이름</th>
                <th>나이</th>
                <th>성별</th>
                <th>이력서제목</th>
                <th>면접일</th>
                <th>면접결과</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${comInterviewList}" var="comInterviewList" >
                    <tr>
                    	 <td align="center">${comInterviewList.inter_no}</td>
                    	  <td align="center">${comInterviewList.cl_photo}</td>
                    	  <td align="center">${comInterviewList.cl_name}</td>
                    	  <td align="center">${comInterviewList.cl_age}</td>
                    	  <td align="center">${comInterviewList.cl_gender}</td>
                    	  <td align="center">${comInterviewList.re_title}</td>
                    	  <td align="center">${comInterviewList.inter_date}
                    	  <button type="button" onclick="location.href='comInterviewDate.go?inter_no=${comInterviewList.inter_no}'">일정 변경</button>
                    	  </td>
                    	  <td align="center">${comInterviewList.inter_result}
                    	  <button type="button" onclick="location.href='comInterviewUpdate.go?inter_no=${comInterviewList.inter_no}'">결과 수정</button>
                    	  </td>
                    </tr>
                </c:forEach>
        </tbody>
    </table>		
</body>
<script>
</script>
</html>