<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<body>
	<div id="join">
			<h1>회원가입</h1>
			<form action="clientJoin.do" method="post" onsubmit="return joinFormClient()">
			    <table>
			        <tr>
			            <th>아이디</th>
			            <td>
			            	<input type="text" id="cl_id" name="cl_id" maxlength="20"/>
			            	<button type="button" onclick="overlayId()">중복확인</button>
			            </td>
			        </tr>
			        <tr>
			            <th>비밀번호</th>
			            <td>
			            	<input type="password" name="cl_pw" id="cl_pw"  maxlength="20"/>
			            	영문,숫자 조합으로 8~20자로 작성하세요.
			            </td>
			        </tr>
			             <tr>
			            <th>비밀번호 확인</th>
			            <td>
			            	<input type="password"  id="pw2" maxlength="20"/>
			            </td>
			        </tr>
			        <tr>
			            <th>이름</th>
			            <td>
			            	<input type="text" name="cl_name" id="cl_name"/>
			            </td>
			        </tr>
			        <tr>
			            <th>생년월일</th>
			            <td>
			            	<input type="text" name="cl_birth"  id="cl_birth" placeholder="예)YYYY-MM-DD" />
			            </td>
			        </tr>
			        <tr>
			        	<th>성 별</th>
  						<td>
  							<input type='radio' name='gender' value='male' />남성
			        		<input type='radio' name='gender' value='female' />여성
			        	</td>
			        </tr>
			        <tr>
			            <th>주 소</th>
			            <td>
			            	<input type="text" name="cl_address" id="cl_address"/>
			            	<button type="button" onclick="overlayEmail()">주소찾기</button>
			            </td>
			        </tr>
			        <tr>
			            <th>핸드폰 번호</th>
			            <td>
			            	<input type="text" name="cl_call" id="cl_call" placeholder="예)010-1234-5678"/>
			            </td>
			        </tr>
			        <tr>
			            <th>이메일</th>
			            <td>
			            	<input type="text" name="cl_email"  id="cl_email" placeholder="예)cbt@example.com" />
			            	<button type="button" onclick="overlayEmail()">중복확인</button>
			            </td>
			        </tr>
			        <tr>
			            <th>사진등록</th>
			            <td>
			            	<input type="text" name="cl_photo"  id="cl_photo" readonly/>
			            	※ 파일은 PNG,JPEG/JFIF,Exif,GIF,BMP 형식만 가능합니다.
			            </td>
			        </tr>
			        <tr>
			            <th colspan="2">
			                <input type="submit" value="회원가입"/>
				         	<input type="button" value="취소" onclick="location.href='login'"/>
			            </th>
			        </tr>
			    </table>
			</form>
		</div>
</body>
<script>
var overChk= false;

	//아이디 중복 체크
	function overlayId(){
		var clId = $("#cl_id").val();
		console.log("중복된 아이디 확인 : "+clId);
		
		// 아이디 제한 기능
		var expId=/^[a-z]+[a-z0-9]{6,20}$/g;
		
		if(expId.test($("#cl_id").val())){
			
			$.ajax({
				type:'get',
				url:'overlayClientId.ajax',
				data:{chkclId:clId},
				datatype:"JSON",
				success:function(data){
					//console.log(data);
					alert("사용중인 아이디 입니다.");
					$("#cl_id").val("");
					$("#cl_id").focus();
				}else{
					alert("사용 가능한 아이디 입니다.");
					overChk = true;
				}
			});
			
		}
		
		
	}


</script>