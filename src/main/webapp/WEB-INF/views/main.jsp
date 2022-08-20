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
    	padding-left: 20px;
    	padding-right: 10px;
   		width: 100px;
    	height : 80px;
    }
    #cal-list{
		width: 80%;
    }
    h2{
    	margin: 0px;
    }


</style>
</head>
	
    <body>
    	
    	<table id="cal-list">
    	 <thead>
    	 <tr>
    	 	<th colspan="2">
    	 		<h2><img src="./resources/images/calendar.png" alt="calendar" id="cal"/>채용달력</h2>
    	 	</th>
    	 </tr>
    	 	<tr>
    	 		<td></td>
    	 		<td></td>   		    	 		
			</tr>
			<tr>
    	 		<td></td>
    	 		<td></td>   	    	 		    	 		
			</tr>
			<tr>
    	 		<td></td>
    	 		<td></td>   		    	 		    	 		
			</tr>
			<tr>
    	 		<td></td>
    	 		<td></td>   		    	 		    	 		
			</tr>
			<tr>
    	 		<td></td>
    	 		<td></td>   	    	 		    	 		
			</tr>
			<tr>
    	 		<td></td>
    	 		<td></td>   		    	 		    	 		
			</tr>
									
		</thead>
		<tbody>
			<tr>
			</tr>
		</tbody>
    	</table>

    </body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>
	var today = new Date();
	today.setDate(today.getDate() + 7); // 7일 더하여 setting
	
	
</script>
</html>