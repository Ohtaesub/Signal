<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<body>
		<h1>ID 찾기 - 개인</h1>
		<form action="findClientId.do" method="post" onsubmit="return findId()">
			<table>
			   <tr>
					<th>이름</th>
						<td>
							<input type="text" name="cl_name" id="cl_name"/>
						</td>
				</tr>
			     <tr>
					<th>이메일</th>
					<td>
						<input type="text" name="cl_email" id="cl_email" placeholder="예)admin@naver.com"/>
					</td>
				</tr>
			     <tr>
					<th colspan="2">
						<input type="submit" value="아이디 찾기"/>
			         	<input type="button" value="취소" onclick="location.href='/'"/>
					</th>
				</tr>
			</table>
		</form>
	</body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>
	function findId(){
		var name = $("#cl_name").val();
		var email = $("#cl_email").val();
		var expEmail = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/;
		
		if(name==""){
			 alert("이름을 입력해주세요.");
			 $("#cl_name").focus();
			 return false;
		}
		
		if(email==""){
   			alert("이메일을 입력해주세요");
   			$("#cl_email").focus();
   			return false; 
       	}
		
		if(!expEmail.test(email)){
        	alert("이메일 형식이 아닙니다.");
        	$("#cl_email").val('');
        	$("#cl_email").focus();
        	return false;
		}

	}
</script>