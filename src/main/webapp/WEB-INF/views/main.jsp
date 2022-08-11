<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header.jsp" %>
<!DOCTYPE html>
<html  lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/> 
<style>

    header {
        height : 150px;
    }
	#logo{
        padding-left: 10px;
	}
    li a{
        text-align: center;
    }
    #cal{
   		width: 40px;
    	height : 40px;
 		padding: 0px 10px ;
    }
    #cal-list{
		width: 80%;

    }


</style>
</head>
	
    <body>
    	<h2><img src="./resources/images/calendar.png" alt="calendar" id="cal"/>채용달력</h2>
    	<table id="cal-list">
    		<tr>
				<th>월</th>
				<td></td>
			</tr>
    		<tr>
				<th>화</th>
				<td></td>
			</tr>
   			<tr>
				<th>수</th>
				<td></td>
			</tr>
    		<tr>
				<th>목</th>
				<td></td>
			</tr>
   			<tr>
				<th>금</th>
				<td></td>
			</tr>
    		<tr>
				<th>토</th>
				<td></td>
			</tr>
    		<tr>
				<th>일</th>
				<td></td>
			</tr>	
    	</table>

    </body>
<script>

</script>
</html>