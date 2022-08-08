<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<body>
			<h1>회원가입</h1>
			<form action="clientJoin.do" method="post" onsubmit="return joinFormClient()">
			    <table>
			        <tr>
			            <th>아이디</th>
			            <td>
			            	<input type="text" id="cl_id" name="cl_id" maxlength="20"/>
			            	<button type="button" onclick="overlayId()">중복확인</button>
			            	※영문,숫자 조합으로 8~20자로 작성하세요.
			            </td>
			        </tr>
			        <tr>
			            <th>비밀번호</th>
			            <td>
			            	<input type="password" name="cl_pw" id="cl_pw"  maxlength="20"/>
			            	※영문,숫자 조합으로 8~20자로 작성하세요.
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
			            <th>나이</th>
			            <td>
			            	<input type="text" name="cl_age"  id="cl_age"/>&nbsp; 살
			            </td>
			        </tr>
			        <tr>
			        	<th>성 별</th>
  						<td>
  							<input type='radio' name='gender' value='남' />남성
			        		<input type='radio' name='gender' value='여' />여성
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
			            	<input type="button" value="파일업로드" onclick="fileUp()"/>
			            	<br>※ 파일은 PNG,JPEG/JFIF,Exif,GIF,BMP 형식만 가능합니다.
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
</body>
<script>

	//아이디 중복 체크
	var overChk= false;
	function overlayId(){
		var clId = $("#cl_id").val();
		console.log("중복된 아이디 확인 : "+clId);
		
		// 아이디 제한 기능
		var expId=/^[a-z]+[a-z0-9]{6,20}$/g;
		
		if(expId.test($("#cl_id").val())){
		
			//아이디 중복 또는 사용가능 유효성 검사
			$.ajax({
				type:'get',
				url:'overlayClientId.ajax',
				data:{chkclId:clId},
				datatype:"JSON",
				success:function(data){
					console.log(data);
					if(data.overlayClientId){
						alert("사용중인 아이디 입니다.");
						$("#cl_id").val("");
						$("#cl_id").focus();
					}else{
						alert("사용 가능한 아이디 입니다.");
						overChk = true;
					}
				},
				error:function(e){
					console.log(e);
				}
			});
			
		}else{
			alert("아이디는 영문 또는 영문숫자 조합으로 8~20자로 작성해주세요.");
			id.focus();
			return false;	
		}		
	}
	
	//이메일 중복체크
	var overChk2=false;
	
	function overlayEmail(){
		var email=$("#cl_email").val();
		
		//이메일 정규화 표현
		var expEmail = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/;
		//console.log("이메일중복체크 : "+email);
		if(email==""){
			alert("이메일을 입력해 주세요.");
			$("#cl_email").focus();
		}else if(!expEmail.test(email)){
			alert("이메일 형식이 아닙니다.");
			$("#cl_email").val("");
			$("#cl_email").focus();
			}else{
				$.ajax({
					type:'get',
					url:'overlayEmail.ajax',
					data:{
						chkEmail:email
					},
					datatype:"JSON",
					success:function(data){
						// true / false 리턴 console.log(data);
						if(data.overlayEmail){
							alert("사용중인 이메일 입니다.");
							$("#cl_email").val("");
							$("#cl_email").focus();
						}else{
							alert("사용가능한 이메일입니다.");
						}
					},
					error:function(e){
						console.log(e);
					}
				});
			}
	}	
		function joinFormClient(){
			var clId = $("#cl_id").val();
			var clPw = $("#cl_pw").val();
			var expPw = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/;
			var clPw2 = $("#pw2").val();
			var name = $("#cl_name").val();
			var birth = $("#cl_birth").val();
			var clAddress = $("#cl_address").val();
			var clCall= $("#cl_call").val();
			var Email = $("#cl_email").val();
			
			if(clId==""){
				alert("아이디를 입력해주세요.");
				$("#cl_id").focus();
				return false;
			}
			
			if(clPw==""){
				alert("비밀번호를 입력해주세요.");
				$("#cl_pw").focus();
				return false;
			}
			
			 if(!expPw.test(clPw)){
	        	alert("비밀번호는 8 ~ 20자 영문,숫자 조합으로 만들어주세요.");
	        	$("#cl_pw").val("");
	        	$("#pw2").val("");
	        	$("#cl_pw").focus();
	        	return false;
		    }
			 
			 if(clPw2==""){
	           alert("비밀번호 확인을 입력해주세요.");
	           $("#pw2").val("");
	           $("#pw2").focus();
	           return false;	
		    }
			 
			 if(clPw!==clPw2){
	        	alert("비밀번호가 일치하지 않습니다.");
        	 	$("#pw2").val("");
	            $("#pw2").focus();
	        	return false;
	        }
			 
			 if(name==""){
				 alert("이름을 입력해주세요.");
				 $("#cl_name").focus();
				 return false;
			 }
			
			
		}
		
	

</script>