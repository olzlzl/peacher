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
<title>모두의 공부 :: 대한민국 모든 고등학생을 위한 무료 교육 서비스</title>
</head>
<body>
	<div>
		<div>
			<a href="index.html">홈</a> <a href="login.html">로그인</a> <a href="join.html">무료계정생성</a> <a href="admin.html">관리자</a>
		</div>
		<div>
			<form action="analysis.html" method="post">
			<h1>모두의 공부</h1>
			<h3>대한민국의 모든 고등학생을 위한 무료 교육 서비스 모두의 공부에 오신 것을 환영합니다.</h3>
			<p>모의고사 틀린 문제 번호만 입력해보세요. 모두의 공부 성적 분석 시스템이 여러분의 취약점을 찾아내주고, 취약점 보완을 위한 다양한 강의와 시험문제들을 제공해드립니다.</p>
				<table>
					<tr>
						<td>학년</td>
						<td>
							<input type="radio" name="grade" value="1" disabled> 고1
  							<input type="radio" name="grade" value="2" disabled> 고2
  							<input type="radio" name="grade" value="3" checked> 고3
  						</td>
					</tr>
					<tr>
						<td>년도</td>
						<td>
							<select name="year">
								<option value="2016">2016</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>월</td>
						<td>
							<select name="month">
								<option value="3">3월</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>틀린문항</td><td><input name="incorrect_number"></input></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="분석해보기"></input></td>
					</tr>
				</table>
			</form>
		</div>
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