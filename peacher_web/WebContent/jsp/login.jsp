<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    session.invalidate();
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
		<img alt="이든배움학원_로고" src="img/logo_square.png" width="200">
		<form>
			<table class="login_table">
				<tr>
					<td><input type="text" name="id" id="login_id_input" tabindex="1" placeholder="아이디"></td>
					<td rowspan="2"><input id="login_submit_button" tabindex="3" type="button" value="로그인"></td>
				</tr>
				<tr>
					<td><input type="password" name="pw" id="login_pw_input" tabindex="2" placeholder="비밀번호"></td>
				</tr>
			</table>
		</form>
		<div class="result_message_area"><span id="result_message"></span></div>
	</div>

	<script>
		$(document).ready(function(){
			$("#login_id_input").focus();
		});
		
		$("#login_id_input").keypress(function(event) {
			if(event.which==13) {
				$("#login_pw_input").focus();
			}
		});

		$("#login_pw_input").keypress(function(event) {
			if(event.which==13) {
				sendData();
			}
		});

		$("#login_submit_button").keypress(function(event) {
			if(event.which==13) {
				sendData();
			}
		});

		$("#login_submit_button").click(function() {
			sendData();
		});
		
		function sendData() {
			if(checkParameters()) {
			    $.ajax({
			    	url : "login.action", 
			    	type : "post", 
			    	data : $("form").serialize(),
			    	success : function(data) {
			        	switch (data) {
						case "0":
							location.href="index.html";							
							break;
						case "1":
							$("#result_message").text("아이디가 존재하지 않습니다.");	
							$("#login_id_input").focus();
							break;
						case "2":
							$("#result_message").text("비밀번호가 일치하지 않습니다.");
							$("#login_pw_input").focus();
							break;
						default:
							break;
						} 
			    	}, 
			    	error : function(data) {
			    		alert("error : " + data);
			    	}
			    });			
			}
		}
		
		function checkParameters(){
			if($("#login_id_input").val()=="") {
				$("#result_message").text("아이디를 입력하세요.");
				$("#login_id_input").focus();
				return false;
			}
			if($("#login_pw_input").val()=="") {
				$("#result_message").text("비밀번호를 입력하세요.");
				$("#login_pw_input").focus();
				return false;
			}
			return true;
		}
	</script>

</body>
</html>