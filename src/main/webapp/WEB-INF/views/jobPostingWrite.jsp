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
        	<h6>기업페이지 > 채용공고관리 > 등록</h6>
        	</br>
	        		<h2>채용공고 등록하기</h2></br>
	        	<form action="/jobPostingWrite.do" method="get" enctype="multipart/form-data" id="form">
		        	<div>
			        	<table id="PostingWrite">
							<input type="hidden" name="com_id" value="${dto.com_id}"/></td>
							<input type="hidden" name="jpo_state" value="진행중"/></td>
				    		<tr>
								<th>공고제목</th>
								<td><input type="text" name="jpo_title" required/></td>
							</tr>
				    		<tr>
								<th>근무형태</th>
								<td>
									<lable><input type="radio" name="jpo_type" value="정규직" required="required"/> 정규직</lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<lable><input type="radio" name="jpo_type" value="비정규직" required="required"/> 비정규직</lable>
								</td>
							</tr>
							<tr>
								<th>모집분야</th>
								<td>
									<lable><input type="radio" name="jpo_field" value="신입" required="required"/> 신입</lable>&nbsp;&nbsp;
									<lable><input type="radio" name="jpo_field" value="경력" required="required"/> 경력</lable>&nbsp;&nbsp;
									<lable><input type="radio" name="jpo_field" value="무관" required="required"/> 무관</lable>
							</tr>
				   			<tr>
								<th>직무분류</th>
								<td>	
							     <select name="jp_no" id="searchOption1" onchange="jobBigListShow();">
							                <option value="">직군</option>
							                   <c:forEach items="${jobBigList}" var="jobBigList">
							                  <option value="${jobBigList.jp_no}" ${jp_no == jobBigList.jp_no ? 'selected="selected"' : ''}>${jobBigList.jp_name}</option>
							               </c:forEach>
							            </select>
							            &nbsp;
							            <select name="jc_no" id="searchOption2" onchange="jobMidListShow();">
							                <option value="">직업</option>
							                   <c:forEach items="${jobMidList}" var="jobMidList">
							                  <option value="${jobMidList.jc_no}" ${jc_no == jobMidList.jc_no ? 'selected="selected"' : ''}>${jobMidList.jc_name}</option>
							               </c:forEach>
							            </select>
								</td>
							</tr>
				   			<tr>
								<th>근무지역</th>
								<td>	
									<select name="jpo_region" required="required">
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
									<input type="date" name="jpo_start" id="jpo_start" required/> ~
									<input type="date" name="jpo_deadline" id="jpo_deadline" required />
								</td>
							</tr>
				   			<tr>
								<th>최종학력</th>
								<td>
									<select name="jpo_education" required="required">
										<option value="고등학교 졸업">고등학교 졸업</option>
										<option value="전문대학교 졸업">전문대학교 졸업</option>
										<option value="대학교 졸업">대학교 졸업</option>
										<option value="대학원 졸업">대학원 졸업</option>
									</select> 이상
								</td>
							</tr>
				    		<tr>
								<th>급여</th>
								<td><input type="text" name="jpo_salary" required/></td>
							</tr>
							<tr>
								<th>담당자명</th>
								<td><input type="text" name="jpo_name" required/></td>
							</tr>
							<tr>
								<th>담당자 연락처</th>
								<td><input type="text" name="jpo_contact" required/></td>
							</tr>
							<tr>
								<th>복리후생</th>
								<td><input type="text" name="jpo_welfare" required/></td>
							</tr>
							<tr>
								<th>채용 내용</th>
								<td>       					
									<input type="file" name="jpo_photo" multiple="multiple" required="required"/>
                  				</td>
							</tr>														
			        	</table>
			        	<div class="find-btn">
		        			<input class="find-btn1" type="submit" value="등록하기"/>
		        			<input class="find-btn2" type="button" value="돌아가기" onclick="location.href='/jobPostingList.go'"/>
						</div>
	        		</div>
	        	</form>
        </div>
   </section>
</body>
<script>
	$(function(){ 
		$("#checkDate").submit(function(){
			var jpo_start = $('#jpo_start').val();
			var jpo_deadline = $('#jpo_deadline').val();        
			var startArray = jpo_start.split('-');         //-을 구분자로 연,월,일로 잘라내어 배열로 반환 
			var endArray = jpo_deadline.split('-');     
			       //배열에 담겨있는 연,월,일을 사용해서 Date 객체 생성         
			var start_date = new Date(startArray[0], startArray[1], startArray[2]);         
			var end_date = new Date(endArray[0], endArray[1], endArray[2]);   //날짜를 숫자형태의 날짜 정보로 변환하여 비교한다.         
			
			if(start_date.getTime() > end_date.getTime()) {
				 alert("종료날짜보다 시작날짜가 작아야합니다.");            
				 return false;
				}     
			}); 
		});
	
/* 	
	function jobBigListShow(){
		   $("#form").click();
		}

		function jobMidListShow(){
		   $("#form").append();
		}

	
	 */
	
	
	
/* 	
	var malls = false;

	function update_selected() {
		$("#jp_no").click(function(){
	  $("#jc_no").val(0);
	  $("#jc_no").find("option[value!=0]").detach();

	  $("#jc_no").append(malls.filter("#jp_no.val()" =  $(this).val()));
	}

	$(function() {
		malls= $("#jc_no").find("option[value!=0]");
		malls.detach();

	  $("#jp_no").change(update_selected);
	  $("#jp_no").trigger("change");
		}
	});  */

</script>
</html>