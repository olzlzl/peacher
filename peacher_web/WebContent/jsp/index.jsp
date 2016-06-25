<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String id = (String)session.getAttribute("id");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/common.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<title>이든배움학원 관리자 페이지</title>
</head>
<body>
	<div class="container">
		<form>
			<div class="search_area">
				<input id="search_input" name="q" placeholder="이름, 전화번호, 학교, 메모 검색 가능"/> <input id="search_button" value="검색" readonly />
			</div> 
		</form>
		<div class="menu_area">
			<dl>
				<dt>메뉴</dt>
				<dd><a href="">학생등록</a></dd>
				<dd><a href="">출석부</a></dd>
				<dd><a href="">수강반관리</a></dd>
				<dd><a href="">수강생관리</a></dd>
				<dd><a href="">원비관리</a></dd>
			</dl>
		</div>
		<div class="search_result_area">
			<span id="search_result"></span>
		</div>
	</div>

	<script>
		$(document).ready(function(){
			$("#search_input").focus();
		});
		
		$("#search_input").keypress(function(event) {
			if(event.which==13) {
				search();
			}
		});

		$("#search_button").click(function() {
			search();
		});
		
		function search() {
			var ca = /\+/g;
			if(checkParameters()) {
			    $.ajax({
			    	url : "search.action", 
			    	type : "get", 
			    	data : $("form").serialize(),
			    	success : function(data) {
			    		if( data == null || data == "" ) {
			    			$("#search_result").html("검색결과가 없습니다.");
			    		} else {
				    		$("#search_result").html(decodeURIComponent(data.replace(ca, " ")));
			    		}
			    	}, 
			    	error : function(data) {
			    		alert("error : " + data);
			    	}
			    });			
			}
		}
		
		function checkParameters(){
			if($("#search_input").val()=="") {
				return false;
			}
			return true;
		}
	</script>

</body>
</html>