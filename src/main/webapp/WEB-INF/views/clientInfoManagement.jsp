<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<body>
	<h3>개인정보관리</h3>
        <input type="hidden" name="cl_state" id="cl_state" value="개인회원"/>
        <input type="hidden" name="cl_id" id="cl_id" value="${clientInfo.cl_id}"/>
	    <table>
	        <tr>
	            <th>아이디</th>
	            <td>${sessionScope.loginId}</td>
	        </tr>
	        <tr>
	            <th>이름</th>
	            <td>${clientInfo.cl_name}</td>
	        </tr>
	        <tr>
	            <th>생년월일</th>
	            <td>${clientInfo.cl_birth}</td>
	        </tr>
	        <tr>
	            <th>나이</th>
	            <td>${clientInfo.cl_age} 세</td>
	        </tr>
	        <tr>
	        	<th>성 별</th>
				<td>${clientInfo.cl_gender}</td>
	        </tr>
	        <tr>
	            <th>주 소</th>
	            <td>${clientInfo.cl_address}</td>
	        </tr>
	        <tr>
	            <th>핸드폰 번호</th>
	            <td>${clientInfo.cl_call}</td>
	        </tr>
	        <tr>
	            <th>이메일</th>
	            <td>${clientInfo.cl_email}</td>
	        </tr>
	        <tr>
	            <th>사진</th>
	            <td><img src="/photo/${clientInfo.cl_photo}" width="100" height="100"/></td>
	        </tr>
	        <tr>
	            <th colspan="2">
	                <input type="button" value="수정하기" onclick="location.href='clientInfoUpdateForm.go'"/>
		         	<input type="button" value="회원탈퇴" onclick="clientBreakForm()"/>
	            </th>
	        </tr>
	    </table>
</body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>

function clientBreakForm(){
	var cl_id = $("#cl_id").val();
	window.open("clientBreakFormPopup.go?cl_id="+cl_id,"", "width=600, height=400, left=100, top=50");	
}


</script>