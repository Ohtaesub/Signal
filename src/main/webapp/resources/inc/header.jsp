<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
</head>
<body>
	<div id="header">
	<p id="logo">
	    <a href="/"><img src="resources/images/Logo.jpg" alt="Signal" width="150" height="130"/></a>
	</p>
	<ul class="nav">
	    <li><a href="#">채용공고</a></li>
	    <li><a href="#">인재채용</a></li>
	</ul>
	<hr/>
	<div id="container"> 
	        <aside><strong>${sessionScope.loginName}</strong>님 반갑습니다 <br> <a href="">마이페이지</a> <span>|</span> <a href="logout.do">로그아웃</a></aside>    
	</div>
	    <input type="button" class="login" value="로그인" onclick="showPopup()"/>
	    <input type="button" class="join" value="회원가입" onclick="location.href='joinSelect.go'"/>
	</div>
    <div id="wrap">
    	<div id="aside">
        	<nav>
				<ul class="sidemenu">
					<li><a href="">개인정보관리</a></li>
	                <li><a href="">이력서</a></li>
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
			</nav>
    	</div>
     </div>
</body>
<script>
	function showPopup() {
	window.open("loginPopup.go", "login", "width=400, height=300, left=100, top=50");
	
	}
</script>
</html>