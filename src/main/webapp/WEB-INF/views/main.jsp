<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../resources/inc/header_jobPosting.jsp" %>
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
	   	table{
			width: 80%;
	   		margin: 0 auto;
	   }
	   th{
	   		background-color: #e8ecf4ff;
	   }
	   td{
	   height: 100px;
	   }
	   	table,th,td{
		   	border: 1px solid gray;
		   	border-collapse: collapse;
	  		padding: 3px;
	   }
		h2{
			margin: 0px 0px 0px 0px;
		}
   		h3{
	    	margin: 0px;
			font-weight: bold;
  	 	}
    	h4{
	    	width: 20px;
	    	text-align: center;
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
    	 		<td><h4><div id="current_date"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>

	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div> 
    	 		</td> 	 		
			</tr>
			<tr>
    	 		<td><h4><div id="current_date1"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>
	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div>
    	 		</td>   	    	 		    	 		
			</tr>
			<tr>
    	 		<td><h4><div id="current_date2"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>
	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div>
    	 		</td>      		    	 		    	 		
			</tr>
			<tr>
    	 		<td><h4><div id="current_date3"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>
	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div>
    	 		</td>     	 		    	 		
			</tr>
			<tr>
    	 		<td><h4><div id="current_date4"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>
	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div>
    	 		</td>     	    	 		    	 		
			</tr>
			<tr>
    	 		<td><h4><div id="current_date5"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>
	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div>
    	 		</td>      	 		    	 		
			</tr>
			<tr>
    	 		<td><h4><div id="current_date6"></div></h4></td>
    	 		<td>
	    	 		<div id="start">[ 시작 ]</div>
	    	 		<br/>
	    	 		<div id="end">[ 마감 ]</div>
    	 		</td>   		    	 		    	 		
			</tr>
									
		</thead>
		<tbody>
			<tr>
			</tr>
		</tbody>
    	</table>
    	<div>
    	<p>?????</p>
    	</div>

    </body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>
/* 	var today = new Date();
	today.setDate(today.getDate("current_date") + 7); // 7일 더하여 setting
	 */
	
	date = new Date();
	year = date.getFullYear();
	month = date.getMonth() + 1;
	day = date.getDate();
	document.getElementById("current_date").innerHTML =  year+"/"+month + "/" + day; 
	document.getElementById("current_date1").innerHTML =  year+"/"+month + "/" + (day+1); 
	document.getElementById("current_date2").innerHTML =  year+"/"+month + "/" + (day+2); 
	document.getElementById("current_date3").innerHTML =  year+"/"+month + "/" + (day+3); 
	document.getElementById("current_date4").innerHTML =  year+"/"+month + "/" + (day+4); 
	document.getElementById("current_date5").innerHTML =  year+"/"+month + "/" + (day+5); 
	document.getElementById("current_date6").innerHTML =  year+"/"+month + "/" + (day+6); 
	</script>

</html>