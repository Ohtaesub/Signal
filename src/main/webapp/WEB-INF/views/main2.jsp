<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<style>
body{
	width:1600px;
	margin:0 auto;
	font-family:'Noto Sans KR',sans-serif;
}

.titleA{
	position:relative;
	font-size:80px;
	font-weight:bold;
	color:#B8860B;
	margin-bottom:20px;
}

.titleB{
	position:relative;
	font-size:50px;
	color:#191970;
	margin-bottom:20px;
}

.titleC{
	position:relative;
	font-size:30px;
	margin-bottom:20px;
}

#container{
	margin:10px 200px 0 0 ;
	width:200px;
    height:140px;
    text-align: center;
    background-color: #1f3864;
    border-radius: 20px;
    position: relative; 
    float:right;
    display:table-cell;
    vertical-align:middle;
}

#container > aside > a {
	font-weight: bold;
}    
   
#container > aside > span {
    font-size:11px;
    color:#c8c8c8;
}

div aside {
    color: white;
}

div aside a {
    color: white;
}

li a{
    text-align: center;
}

input[type="text"]:focus, input[type="password"]:focus, textarea:focus {
   background-color:#fafafa;
}
input[type="submit"], button[type="submit"] {
   padding:5px 10px;
   font-size:12px;
   outline:none;
   border:none;
   color:#fff;
   background-color:#333;
}
input[type="button"], button[type="button"] {
   padding:10px 20px;
   font-size:12px;
   outline:none;
   border:none;
   color:#fff;
   background-color:#333;
}

#section {
		width : 800px;
		position: relative;
		top : -380px;
		left : 0px;
	}

ul.nav li a {
    text-decoration: none;
    color: black;
    padding: 20px 120px 8px 15px;
    font-weight: bold;
}

ul.nav{
    text-decoration: none;
    font-weight:bold;
    padding: 8px 15px 8px 15px;    
    list-style:none;
    width: 300px;
    position: relative;    
    font-size: 25px;    
}	

ul.nav li{
	float:left;
	position:relative;
	}




</style>
</head>	
    <body>
    	<div id="header">
		<p id="logo">
		    <a href="/"><img src="resources/images/logo2.gif" alt="Signal" style="margin:20px 10px 0 10px;"width="200" height="130"/></a>
		    <span class="titleA">???</span><span class="titleB">??????</span><span class="titleA">???</span><span class="titleB">??????</span>
		    <span class="titleC">(ft.See??????)</span>
		    <c:if test="${sessionScope.isClient.equals('true') || sessionScope.isCompany.equals('true') || sessionScope.isAdmin.equals('true')}">
			<div id="container" style="color:white">  
		        <aside>
		        	<strong>${sessionScope.loginId}</strong>??? ??????????????? 
		        	<br>
		        	<c:if test="${sessionScope.isClient.equals('true')}">
		        		<a href="/clientInfoManagement.do">???????????????</a> 
		        	</c:if>
		        	<c:if test="${sessionScope.isCompany.equals('true')}">
		        		<a href="/companyInfoManagement.do">???????????????</a> 
		        	</c:if>
		        	<c:if test="${sessionScope.isAdmin.equals('true')}">
		        		<a href="/adminManagementList.do">???????????????</a> 
		        	</c:if>
		        	<span>|</span> <a href="logout.do">????????????</a>
		        </aside>
			</div>
		</c:if>
		<c:if test="${!sessionScope.isClient.equals('true') && !sessionScope.isCompany.equals('true') && !sessionScope.isAdmin.equals('true')}">
		    <input type="button" class="join" style="float:right; margin:120px 200px 0 0;" value="????????????" onclick="location.href='joinSelect.go'"/>
		    <input type="button" class="login" style="float:right; margin:120px 20px 0 0;" value="?????????" onclick="showPopup()"/>		    
		</c:if>
		</p>
		<ul class="nav">
		    <li><a href="/jobPostingMain.go">????????????</a></li>
		    <li><a href="/personList.go">????????????</a></li>
		</ul>		
		</div>
		<div style="width:250px; height:600px;" id="wrap">
    	<div id="aside">
        	<nav>
				<c:if test="${sessionScope.isClient.equals('true')}">
				<ul class="sidemenu">
					<li><a href="/clientInfoManagement.do">??????????????????</a></li>
	                <li><a href="/resumeList.go">?????????</a></li>
	                <li><a href="/recommendMe.go">????????????</a></li>
	                <li><a href="/clientApplyList.go">??????????????????</a></li>
	                <li><a href="/clientOfferList.go">??????????????????</a></li>
	                <li><a href="/interviewList.go">????????????</a></li>
	                <li><a href="/clientObjectionList.go">??????????????????</a></li>
	                <li><a href="/selfInsert.go">????????????</a></li>
				</ul>
				</c:if>
		        <c:if test="${sessionScope.isCompany.equals('true')}">
		            <ul style="height:366px;" class="sidemenu">
		                <li><a href="/companyInfoManagement.do">????????????????????????</a></li>
		                <li><a href="/companyInfo.go">??????????????????</a></li>
		                <li><a href="/jobPostingList.go">??????????????????</a></li>
		                <li><a href="/companyOfferList.do">??????????????????</a></li>
		                <li><a href="/companyApplyList.go">?????????????????????</a></li>
		                <li><a href="/comObjectionList.go">??????????????????</a></li>
		            </ul>
		        </c:if>
		        <c:if test="${sessionScope.isAdmin.equals('true')}">
		            <ul class="sidemenu">
		                <li><a href="/adminManagementList.do">?????????????????????</a></li>
		                <li><a href="/jobClassReg.go">??????????????????</a></li>
		                <li><a href="/selfTestQue.go">??????????????????</a></li>
		                <li><a href="/interviewTestQue.go">??????????????????</a></li>
		                <li><a href="/adminObjectionList.go">??????????????????</a></li>
		                <li><a href="/adminBlindList.go">??????????????????</a></li>
		                <li><a href="/clientManagementList.do">??????????????????</a></li>
		                <li><a href="/companyManagementList.do">??????????????????</a></li>
		            </ul>
		        </c:if>
			</nav>
    	</div>
     </div>
		
		<div style="width:1300px;">
    	<table id="section" style="width:1200px; float:left; margin-left:100px;">
    	 <thead>
    	 <tr>
    	 	<td colspan="3" style="height:300px;">
    	 		<img src="./resources/images/calendar.png" alt="calendar" id="cal" width="300" height="300"/>
    	 		<span style="line-height:305px; font-size:100px;">????????????</span>
    	 	</td>
    	 </tr>
    	 <tr>
    	 	<th style="width:10%;">??????</th>
    	 	<th style="width:45%;">?????? ?????? ??????</th>
    	 	<th style="width:45%;">?????? ?????? ??????</th>
    	 </tr>									
		</thead>
		<tbody>
			<tr>
    	 		<td><div id="current_date" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start1"></div>
	    	 	</td>
	    	 	<td>
	    	 		<div id="end1"></div> 
    	 		</td> 	 		
			</tr>
			<tr>
    	 		<td><div id="current_date1" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start2"></div>
    	 		</td>
	    	 	<td>
	    	 		<div id="end2"></div>
    	 		</td>   	    	 		    	 		
			</tr>
			<tr>
    	 		<td><div id="current_date2" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start3"></div>
    	 		</td>
	    	 	<td>
	    	 		<div id="end3"></div>
    	 		</td>      		    	 		    	 		
			</tr>
			<tr>
    	 		<td><div id="current_date3" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start4"></div>
    	 		</td>
	    	 	<td>
	    	 		<div id="end4"></div>
    	 		</td>     	 		    	 		
			</tr>
			<tr>
    	 		<td><div id="current_date4" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start5"></div>
    	 		</td>
	    	 	<td>
	    	 		<div id="end5"></div>
    	 		</td>     	    	 		    	 		
			</tr>
			<tr>
    	 		<td><div id="current_date5" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start6"></div>
    	 		</td>
	    	 	<td>
	    	 		<div id="end6"></div>
    	 		</td>      	 		    	 		
			</tr>
			<tr>
    	 		<td><div id="current_date6" style="text-align:center; font-weight: bold;"></div></td>
    	 		<td>
	    	 		<div id="start7"></div>
    	 		</td>
	    	 	<td>
	    	 		<div id="end7"></div>
    	 		</td>   		    	 		    	 		
			</tr>
		</tbody>
    	</table>
    	</div>
    </body>
<%@ include file="../../resources/inc/footer.jsp" %>
<script>
	var dateA = new Date();
	var dateB = new Date();
	var dateC = new Date();
	var dateD = new Date();
	var dateE = new Date();
	var dateF = new Date();	
	var date1 = new Date();
	var date2 = new Date(dateA.setDate(dateA.getDate()+1));
	var date3 = new Date(dateB.setDate(dateB.getDate()+2));
	var date4 = new Date(dateC.setDate(dateC.getDate()+3));
	var date5 = new Date(dateD.setDate(dateD.getDate()+4));
	var date6 = new Date(dateE.setDate(dateE.getDate()+5));
	var date7 = new Date(dateF.setDate(dateF.getDate()+6));	
	
	
	
	for (var i = 1; i < 8; i++) {
		eval("year"+i+"="+"date"+i+".getFullYear()");
		eval("month"+i+"="+"date"+i+".getMonth()+1");
		eval("dlf"+i+"="+"date"+i+".getDate()");		
		
		if(eval("month"+i)<10){
			if(eval("dlf"+i)<10){
				eval("dlf"+i+"= '0'+dlf"+i);
			}
			eval("month"+i+"= '0'+month"+i);
		}		
		eval("var day"+i+"=year"+i+"+'-'+month"+i+"+'-'+dlf"+i);
		console.log(eval("day"+i));
	}
	
	document.getElementById("current_date").innerHTML =  year1+"-"+month1 + "-" + dlf1; 
	document.getElementById("current_date1").innerHTML =  year2+"-"+month2 + "-" + dlf2; 
	document.getElementById("current_date2").innerHTML =  year3+"-"+month3 + "-" + dlf3;
	document.getElementById("current_date3").innerHTML =  year4+"-"+month4 + "-" + dlf4; 
	document.getElementById("current_date4").innerHTML =  year5+"-"+month5 + "-" + dlf5;
	document.getElementById("current_date5").innerHTML =  year6+"-"+month6 + "-" + dlf6;
	document.getElementById("current_date6").innerHTML =  year7+"-"+month7 + "-" + dlf7; 
	
	callendar();
	function callendar(){
		var arr=[];		
		for (var i = 0, j = 1; i < 7; i++, j++) {			
			eval("arr["+i+"]=year"+j+"+'-'+month"+j+"+'-'+dlf"+j);			
		}		
		console.log(arr);
		
		var obj={};
		obj.arr=arr;
		var param={"values":obj};
		
		$.ajax({
			type:'post',
			url:'callendar.ajax',
			data:JSON.stringify(param),
			dataType:'JSON',
			contentType:'application/json; charset=utf-8',
			success:function(data){
				console.log(data.size1+'/'+data.size2+'/'+data.size3+'/'+data.size4+'/'+data.size5+'/'+data.size6+'/'+data.size7+
						'/'+data.size8+'/'+data.size9+'/'+data.size10+'/'+data.size11+'/'+data.size12+'/'+data.size13+'/'+data.size14);
				drawList1(data.startPost1,data.size1);				
				drawList2(data.startPost2,data.size2);
				drawList3(data.startPost3,data.size3);
				drawList4(data.startPost4,data.size4);
				drawList5(data.startPost5,data.size5);
				drawList6(data.startPost6,data.size6);
				drawList7(data.startPost7,data.size7);
				drawList8(data.endPost1,data.size8);
				drawList9(data.endPost2,data.size9);
				drawList10(data.endPost3,data.size10);
				drawList11(data.endPost4,data.size11);
				drawList12(data.endPost5,data.size12);
				drawList13(data.endPost6,data.size13);
				drawList14(data.endPost7,data.size14);
				
			},
			error:function(e){
				console.log(e);
			}
		});	
		
	}
	
	function drawList1(list,size){
		var content ='';		
		var chkState="'start'";
		var chkYear=year1;
		var chkMonth=month1;
		var chkDay=dlf1;
		console.log(size);
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start1').empty();
		$('#start1').append(content);
		console.log(chkState);
		if(size>5){
			var restPost=size - 5;
		$('#start1').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	
	function drawList2(list,size){
		var content ='';		
		var chkState="'start'";
		var chkYear=year2;
		var chkMonth=month2;
		var chkDay=dlf2;
		console.log(size);
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start2').empty();
		$('#start2').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#start2').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	
	function drawList3(list,size){
		var content ='';
		var chkState="'start'";
		var chkYear=year3;
		var chkMonth=month3;
		var chkDay=dlf3;
		console.log(size);
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start3').empty();
		$('#start3').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#start3').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	
	function drawList4(list,size){
		var content ='';
		var chkState="'start'";
		var chkYear=year4;
		var chkMonth=month4;
		var chkDay=dlf4;
		console.log(size);
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start4').empty();
		$('#start4').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#start4').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList5(list,size){
		var content ='';
		var chkState="'start'";
		var chkYear=year5;
		var chkMonth=month5;
		var chkDay=dlf5;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start5').empty();
		$('#start5').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#start5').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	
	function drawList6(list,size){
		var content ='';
		var chkState="'start'";
		var chkYear=year6;
		var chkMonth=month6;
		var chkDay=dlf6;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start6').empty();
		$('#start6').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#start6').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList7(list,size){
		var content ='';
		var chkState="'start'";
		var chkYear=year7;
		var chkMonth=month7;
		var chkDay=dlf7;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start7').empty();
		$('#start7').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#start7').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	
	function drawList8(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year1;
		var chkMonth=month1;
		var chkDay=dlf1;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end1').empty();
		$('#end1').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end1').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList9(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year2;
		var chkMonth=month2;
		var chkDay=dlf2;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end2').empty();
		$('#end2').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end2').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList10(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year3;
		var chkMonth=month3;
		var chkDay=dlf3;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end3').empty();
		$('#end3').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end3').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList11(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year4;
		var chkMonth=month4;
		var chkDay=dlf4;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end4').empty();
		$('#end4').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end4').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList12(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year5;
		var chkMonth=month5;
		var chkDay=dlf5;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end5').empty();
		$('#end5').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end5').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList13(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year6;
		var chkMonth=month6;
		var chkDay=dlf6;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end6').empty();
		$('#end6').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end6').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	function drawList14(list,size){
		var content ='';
		var chkState="'end'";
		var chkYear=year7;
		var chkMonth=month7;
		var chkDay=dlf7;
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>????????? : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end7').empty();
		$('#end7').append(content);
		if(size>5){
			var restPost=size - 5;
		$('#end7').append('<button class="allShow" onclick="mainPop('+chkYear+','+chkMonth+','+chkDay+','+chkState+')">+'+restPost+'</button>');
		}
	}
	
	function mainPop(year,month,dlf,chkState){
		if(month<10){
			if(dlf<10){
				dlf='0'+dlf;
			}
			month='0'+month;
		}
		var chkDay = year+'-'+month+'-'+dlf;
		console.log(chkDay+'/'+chkState);
		window.open("mainPop.go?chkDay="+chkDay+"&&chkState="+chkState, "new","width=1200, height=500, resizable=no, scrollbars=no, status=no, location=no, directories=no");
	}
	
	
	function showPopup() {
		window.open("loginPopup.go","", "width=600, height=400, left=100, top=50");
	
	}
	</script>

</html>