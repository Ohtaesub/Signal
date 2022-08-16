<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>

	textarea {
	   	width:100%;
	   	resize: none;
	   	height: 500px;
   }
   	table,h2,h6{
   		width: 60%;
   		margin: 0 auto;
   }
   	table,th,td{
	   	border: 1px solid gray;
	   	border-collapse: collapse;
   }
   td{
   		padding: 3px;
   }
   	th{
   		font-size: 15px;
   		font-weight: bold;
   		height: 30px;
   		width: 20%;
   		text-align: center;
   	}
   	input[type="text"],[type="url"]{
   		width: 100%;
   		padding: 3px;
   	}
	h2{
		margin-bottom: 10px;
		text-align: center;
	}
	.find-btn{
		text-align: center;
		margin-top: 10px;
	}
	.find-btn1,.find-btn2{
		display :inline-block;
		color: #fff;
		border-radius: 5px;
		width: 100px;
		height: 30px;
		
	}
	.find-btn1{
		background-color: #1f3864ff;
	}
	.find-btn2{
		background-color: #7f7f7fff;
	}

</style>
</head>
<body>
<section>
    <div id="jp-list">
        	<h6>기업페이지 > 채용공고관리 > 수정</h6>
        	<br/>
	        		<h2>채용공고 수정하기</h2><br/>
	        	<form action="/jobPostingUpdate.do?jpo_no='${dto.jpo_no}'" method="post" enctype="multipart/form-data">
		        	<div>
			        	<table id="postingUpdate">
			        		<tr>
								<td><input type="hidden" name="com_id" value="${dto.com_id}"/></td>
								<td><input type="hidden" name="jpo_state" value="${dto.jpo_state}"/></td>
							</tr>
				    		<tr>
								<th>공고제목</th>
								<td><input type="text" name="jpo_title" value="${dto.jpo_title}" required/></td>
							</tr>
				    		<tr>
								<th>근무형태</th>
								<td><input type="text" name="jpo_type" value="${dto.jpo_type}" required /></td>
							</tr>
							<tr>
								<th>모집분야</th>
								<td><input type="text" name="jpo_field" value="${dto.jpo_field}" required /></td>
							</tr>
				   			<tr>
								<th>직무분류</th>
								<td>	
									<select name="jp_no" required="required" value="${dto.jp_no}" >
										<option value="none">대분류</option>
										<option value="2">IT</option>
										<option value="3">건축</option>
										<option value="4">항공</option>																				
										<option value="5">전기</option>
										<option value="6">축산</option>
									</select> 
									<select name="jc_no" required="required" value="${dto.jc_no}">
										<option value="none">중분류</option>									
										<option value="6">퍼블리셔</option>
										<option value="2">SI개발</option>
										<option value="3">데이터분석가</option>
										<option value="4">건설관리</option>
										<option value="5">토목설계</option>
										<option value="7">내진설계</option>
										<option value="10">승무원</option>
										<option value="8">항공운송</option>
										<option value="9" >항공정비</option>
										<option value="11">전기설계</option>
										<option value="12">전기기사</option>
										<option value="13">조경설계</option>
										<option value="14">축산식품가공</option>
										<option value="15">축산식품유통</option>
										<option value="16">도축</option>																																						
									</select>
								</td>
							</tr>
				   			<tr>
								<th>근무지역</th>
								<td>	
									<select name="jpo_region" required="required" value="${dto.jpo_region}">
										<option value="전체">전체</option>
										<option value="서울">서울</option>
										<option value="경기">경기</option>
										<option value="인천">인천</option>
										<option value="대전">대전</option>
										<option value="강원">강원</option>
										<option value="충남">충남</option>
										<option value="충북">충북</option>
										<option value="경남">경남</option>
										<option value="경북">경북</option>
										<option value="세종">세종</option>
										<option value="전남">전남</option>
										<option value="전북">전북</option>
										<option value="대구">대구</option>
										<option value="부산">부산</option>
										<option value="울산">울산</option>
										<option value="광주">광주</option>
										<option value="제주">제주</option>
									</select>
								</td>
							</tr>
				    		<tr>
								<th>모집기간</th>
								<td>
									<input type="date" name="jpo_start" value="${dto.jpo_start}" required/> ~
									<input type="date" name="jpo_deadline" value="${dto.jpo_deadline}" required/>
								</td>
							</tr>
				   			<tr>
								<th>최종학력</th>
								<td>
									<select name="jpo_education" value="${dto.jpo_education}" required="required">
										<option value="고등학교 졸업">고등학교 졸업</option>
										<option value="전문대학교 졸업">전문대학교 졸업</option>
										<option value="대학교 졸업">대학교 졸업</option>
										<option value="대학원 졸업">대학원 졸업</option>
									</select> 이상
								</td>
							</tr>
				    		<tr>
								<th>급여</th>
								<td><input type="text" name="jpo_salary" value="${dto.jpo_salary}" required/></td>
							</tr>
							<tr>
								<th>담당자명</th>
								<td><input type="text" name="jpo_name" value="${dto.jpo_name}" required/></td>
							</tr>
							<tr>
								<th>담당자 연락처</th>
								<td><input type="text" name="jpo_contact" value="${dto.jpo_contact}" required/></td>
							</tr>
							<tr>
								<th>복리후생</th>
								<td><input type="text" name="jpo_welfare" value="${dto.jpo_welfare}" required/></td>
							</tr>
							<tr>
								<th>채용 내용</th>
								<td>       	
								<input type="file" name="jpo_photo" multiple="multiple" required="required" src="/photo/${dto.jpo_photo}" value="${dto.jpo_photo}"/>				
                  				</td>
							</tr>														
			        	</table>
			        	<div class="find-btn">
		        			<input class="find-btn1" type="submit" value="수정하기"/>
		        			<input class="find-btn2" type="button" value="돌아가기" onclick="location.href='/jobPostingDetail.do?jpo_no=${dto.jpo_no}'"/>
						</div>
	        		</div>
	        	</form>
        </div>
   </section>
</body>
<script>


</script>
</html>