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
    	
    	li{
    		list-style: none;
    	}

		.allShow{
			float:right;			
		}

</style>
</head>
	
    <body>
    	
    	<table id="cal-list">
    	 <thead>
    	 <tr>
    	 	<th colspan="3">
    	 		<h2><img src="./resources/images/calendar.png" alt="calendar" id="cal"/>채용달력</h2>
    	 	</th>
    	 </tr>
    	 <tr>
    	 	<th style="width:10%;">날짜</th>
    	 	<th style="width:45%;">채용 시작 기업</th>
    	 	<th style="width:45%;">채용 마감 기업</th>
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
	
	if(month<10){
		if(day<10){
			day='0'+day;
		}
		month='0'+month;
	}
	
	console.log("날짜= " +' / '+ date +' / '+ year +' / '+ month +' / '+ day +' / ');
	
	document.getElementById("current_date").innerHTML =  year+"-"+month + "-" + day; 
	document.getElementById("current_date1").innerHTML =  year+"-"+month + "-" + (day+1); 
	document.getElementById("current_date2").innerHTML =  year+"-"+month + "-" + (day+2); 
	document.getElementById("current_date3").innerHTML =  year+"-"+month + "-" + (day+3); 
	document.getElementById("current_date4").innerHTML =  year+"-"+month + "-" + (day+4); 
	document.getElementById("current_date5").innerHTML =  year+"-"+month + "-" + (day+5); 
	document.getElementById("current_date6").innerHTML =  year+"-"+month + "-" + (day+6); 
	
	callendar();
	function callendar(){
		var arr=[];		
		for (var i = 0; i < 7; i++) {			
			arr[i]=year+'-'+month+'-'+(day+i);
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
				console.log(data.msg);
				drawList1(data.startPost1);				
				drawList2(data.startPost2);
				drawList3(data.startPost3);
				drawList4(data.startPost4);
				drawList5(data.startPost5);
				drawList6(data.startPost6);
				drawList7(data.startPost7);
				drawList8(data.endPost1);
				drawList9(data.endPost2);
				drawList10(data.endPost3);
				drawList11(data.endPost4);
				drawList12(data.endPost5);
				drawList13(data.endPost6);
				drawList14(data.endPost7);
				
			},
			error:function(e){
				console.log(e);
			}
		});	
		
	}
	
	function drawList1(list){
		var content ='';	
		var chkDay=$('#current_date').html();
		var chkState="start";
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start1').empty();
		$('#start1').append(content);
		$('#start1').append('<a class="allShow" href="mainPop.go?chkDay='+chkDay+'&&chkState='+chkState
				+'" onclick="window.open(this.href, \"_blank\",\"width=800, height=400, resizable=no, scrollbars=no, status=no, location=no, directories=no;\")">전체보기</a>')
	}
	
	function drawList2(list){
		var content ='';		
		
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start2').empty();
		$('#start2').append(content);
		$('#start2').append('<a class="allShow" href="#">전체보기</a>')
	}
	
	function drawList3(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start3').empty();
		$('#start3').append(content);
		
	}
	
	function drawList4(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start4').empty();
		$('#start4').append(content);
	}
	function drawList5(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start5').empty();
		$('#start5').append(content);
	}
	
	function drawList6(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start6').empty();
		$('#start6').append(content);
	}
	function drawList7(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_deadline);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>마감일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#start7').empty();
		$('#start7').append(content);
	}
	
	function drawList8(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end1').empty();
		$('#end1').append(content);
	}
	function drawList9(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end2').empty();
		$('#end2').append(content);
	}
	function drawList10(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end3').empty();
		$('#end3').append(content);
	}
	function drawList11(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end4').empty();
		$('#end4').append(content);
	}
	function drawList12(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end5').empty();
		$('#end5').append(content);
	}
	function drawList13(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end6').empty();
		$('#end6').append(content);
	}
	function drawList14(list){
		var content ='';
		list.forEach(function(item,idx){
			var date=new Date(item.jpo_start);
			var day=date.toLocaleDateString("ko-kr");
			console.log(day);			
			
			console.log(item);
			content += '<ul>';
			content += '<li><a href="PostingDetailMain.go?jpo_no='+item.jpo_no+'&&com_id='+item.com_id+'">'
					+item.com_name+'[('+item.jp_name+')/('+item.jc_name+')]</a>&nbsp;&nbsp;<span>시작일 : '+day+'</span></li>';
			content += '</ul>';
		});
		$('#end7').empty();
		$('#end7').append(content);
	}
	
	
	</script>

</html>