<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	#wrap{
		width:1000px; height:900px; margin:0 auto;
	}
	#header{
		width:1000px; height:100px; line-height:100px;
	}
	#nav{
		width:1000px; height:100px; line-height:100px;
	}
	#side{
		float:left; width:300px; height:600px; line-height:600px;
	}
	#contents{
		float:left; width:700px; height:600px; line-height:600px;
	}
	#footer{
		float:left; width:1000px; height:100px; line-height:100px;
	}

</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<p id="logo">
	    		<a href="/"><img src="resources/images/Logo.jpg" alt="Signal" width="150" height="130"/></a>
			</p>
			<div>
			<strong>${sessionScope.loginName}</strong>님 반갑습니다<br>
			<a href="">마이페이지</a> 
			<span>|</span>
			<a href="logout.do">로그아웃</a>
			</div>
			<input type="button" class="login" value="로그인" onclick="showPopup()"/>
	    <input type="button" class="join" value="회원가입" onclick="location.href='joinSelect.go'"/>	
		</div>
		<div id="nav">
			<ul class="nav">
			    <li><a href="#">채용공고</a></li>
			    <li><a href="/personList.go'">인재채용</a></li>
			</ul>
			<hr/>
		</div>
		<div id="side">
			<ul class="sidemenu">
					<li><a href="">개인정보관리</a></li>
	                <li><a href="/resumeList.go">이력서</a></li>
	                <li><a href="">회원추천</a></li>
	                <li><a href="">입사지원현황</a></li>
	                <li><a href="">입사제안현황</a></li>
	                <li><a href="">면접현황</a></li>
	                <li><a href="">이의제기현황</a></li>
	                <li><a href="">셀프평가</a></li>
				</ul>
		        <c:if test="${sessionScope.isCompany.equals('true')}">
		            <ul class="sidemenu">
		                <li><a href="">기업회원정보관리</a></li>
		                <li><a href="">기업정보관리</a></li>
		                <li><a href="">채용공고관리</a></li>
		                <li><a href="">입사지원관리</a></li>
		                <li><a href="">입사제안관리</a></li>
		                <li><a href="">면접관리</a></li>
		                <li><a href="">이의제기현황</a></li>
		            </ul>
		        </c:if>
		        <c:if test="${sessionScope.isAdmin.equals('true')}">
		            <ul class="sidemenu">
		                <li><a href="">관리자계정관리</a></li>
		                <li><a href="">직무분류관리</a></li>
		                <li><a href="">셀프평가관리</a></li>
		                <li><a href="">면접평가관리</a></li>
		                <li><a href="">이의제기관리</a></li>
		                <li><a href="">블라인드관리</a></li>
		                <li><a href="">일반회원관리</a></li>
		                <li><a href="">기업회원관리</a></li>
		            </ul>
		        </c:if>
		</div>
		<div id="contents">
			<div>
			<button onclick="#">등록</button>
			<button onclick="#">수정</button>
			<button onclick="#">삭제</button>
		</div>
			<table>
				<thead>
					<tr>
						<th></th>
						<th>이력서 제목</th>
						<th>직무 대분류</th>
						<th>직무 소분류</th>				
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="resume">
						<tr>
							<td><input type="radio" name="re_no" value="${resume.re_no}"/></td>
							<td><a href="resumeDetail.do?re_no=${resume.re_no}">${resume.re_title}</a></td>
							<td>${resume.jp_name}</td>
							<td>${resume.jc_name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="footer" style="background-color:black;"></div>
	</div>
</body>
