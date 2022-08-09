<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../../resources/inc/header.jsp" %>
<style>
	#section {
		width : 800px;
		position: relative;
		top : -380px;
		left : 350px;
	}
	
	.hidden {
		display : none;
	}
</style>
<body>
	<form action="resumeReg.do" method="post">
	<table id="section">
		 <tr>
		    <th>제목</th>
		    <td colspan="6"><input type="text" name="re_title"/></td>
		  </tr>
		  <tr>
		    <th colspan="7">인적사항</th>
		  </tr>
		  <tr class="hidden">
		    <th colspan="7"><input type="text" name="cl_id" value="${cl_id}"></th>
		  </tr>
		  <tr>
		    <td rowspan="3"></td>
		    <th>이름</th>
		    <td>${dto.cl_name}</td>
		    <th>생년월일</th>
		    <td>${dto.cl_birth}</td>
		    <th>성별</th>
		    <td>${dto.cl_gender}</td>
		  </tr>
		  <tr>
		    <th>주소</th>
		    <td colspan="5">${dto.cl_address}</td>
		  </tr>
		  <tr>
		    <th>연락처</th>
		    <td colspan="2">${dto.cl_call}</td>
		    <th>이메일</th>
		    <td colspan="2">${dto.cl_email}</td>
		  </tr>
		  <tr>
		    <th colspan="7">희망직무</th>
		  </tr>
		  <tr>
		    <th>대분류</th>
		    <td colspan="3"><input type="text" name="jp_no"/></td>
		    <th>중분류</th>
		    <td colspan="2"><input type="text" name="jc_no"/></td>
		  </tr>
		  <tr>
		    <th colspan="5">최종학력</th>
		    <td colspan="2"><input type="text" name="re_fn_status"/></td>
		  </tr>
		  <tr>
		    <th>학교명</th>
		    <td colspan="3"><input type="text" name="re_sch_name"/></td>
		    <th>재학기간</th>
		    <td colspan="4"><input type="text" name="re_sch_period"/></td>		    
		  </tr>
		  <tr>
		    <th>전공</th>
		    <td ><input type="text" name="re_major"/></td>
		    <th>학점</th>
		    <td><input type="text" name="re_average"/></td>
		    <td><input type="text" name="re_total"/></td>
		    <th>학적상태</th>
		    <td><input type="text" name="re_register"/></td>
		  </tr>
		  <tr>
		    <th colspan="7">자기소개서</th>
		  </tr>
		  <tr>
		    <td colspan="7"><input type="text" name="re_intro"/></td>
		  </tr>
		  <tr>
		    <th colspan="2">포트폴리오</th>
		    <td colspan="5"><input type="text" name="re_portfolio"/></td>
		  </tr>
		  <tr>
		  	<td>
		  		<input type="submit" value="기본정보등록">
				<input type="button" value="취소" onclick="location.href='resumeList.go'">
				
		  	</td>
		  </tr>	
		</table>
		
</form>
</body>
</html>