<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<body>
	<h3>기업회원 정보관리</h3>
        <input type="hidden" name="com_state" id="com_state" value="기업회원"/>   
	    <table>
	        <tr>
	            <th>아이디</th>
	            <td>${sessionScope.loginId}</td>
	        </tr>
	        <tr>
	            <th>사업자 번호</th>
	            <td>${companyInfo.com_business_no}</td>
	        </tr>
	        <tr>
	            <th>기업명</th>
	            <td>${companyInfo.com_name}</td>
	        </tr>
	        <tr>
	            <th>기업주소</th>
	            <td>${companyInfo.com_address}</td>
	        </tr>
	        <tr>
	        	<th>연락처</th>
				<td>${companyInfo.com_call}</td>
	        </tr>
	        <tr>
	            <th>이메일</th>
	            <td>${companyInfo.com_email}</td>
	        </tr>
	        <tr>
	            <th>사업자 등록증 사본</th>
	            <td>${companyInfo.com_photo}</td>
	        </tr>
	        <tr>
	            <th colspan="2">
	                <input type="button" value="수정하기" onclick="location.href='companyInfoUpdateForm.go'"/>
		         	<input type="button" value="회원탈퇴" onclick="location.href='companyBreakForm.go'"/>
	            </th>
	        </tr>
	    </table>
</body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>

</script>