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
<form action="comInterviewList.do" method="get" id="form">
     	<select name="searchOption" id="searchOption">
			<option value="">전체</option>
			<option value="이름" ${searchOption == '이름'? 'selected="selected"' : ''}>이름</option>
			<option value="이력서제목" ${searchOption == '이력서제목'? 'selected="selected"' : ''}>이력서제목</option>
	 	</select>
			<input  type="text"  name="search" id="search" value="" required/>
			<button type="submit" >검색</button>
			<!-- 페이징  -->
		 	<input type="hidden" name="pageNum" value="1"/>
    </form>		
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
    <!--페이징 -->
    <div class="pageInfo_wrap" >
        <div class="pageInfo_area">
        		<ul id="pageInfo" class="pageInfo">
        		<!-- 이전페이지 버튼 -->
	                <c:if test="${pageMaker.prev}">
	                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
	                </c:if>
	        		
	        		
	 				<!-- 각 번호 페이지 버튼 -->
	                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	                    <li class='pageInfo_btn ${pageMaker.cri.pageNum == num ? "active": "" }'><a href="${num}">${num}</a></li>
	                </c:forEach>
	                
	                <!-- 다음페이지 버튼 -->
	                <c:if test="${pageMaker.next}">
	                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
	                </c:if> 
        		</ul>
        </div>
    </div>
  

	  <form id="moveForm" method="get">
	  	 <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	  </form>				
</body>
<script>
</script>
</html>