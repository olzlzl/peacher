<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List" import="kr.modustudy.db.TestInfo"
    pageEncoding="UTF-8"%><%
    
    List<TestInfo> tiList = (List<TestInfo>)request.getAttribute("tiList");
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
		<br />
		<br />
		<div>
			<a href="insert_test.html">모의고사 정보 추가</a>	
		</div>
		<div>
			<%
		        for (TestInfo testInfo : tiList) {
		    %>
					<%=testInfo.getGrade() %> <%=testInfo.getYear() %> <%=testInfo.getMonth() %> <%=testInfo.getAuth() %> <a href="delete_test.html?test_id=<%= testInfo.getTestId() %>">삭제</a><br /> 
			<%					
				}

			%>
		</div>
		<div>
			<form action="insert_test.html" method="post">
				<table>
					<tr>
						<td>학년</td>
						<td>
							<input type="radio" name="i_grade" value="1"> 고1
							<input type="radio" name="i_grade" value="2"> 고2
	 						<input type="radio" name="i_grade" value="3" checked> 고3
						</td>
					</tr>
					<tr>
						<td>년도</td>
						<td>
							<select name="i_year">
								<option value="2016">2016</option>
								<option value="2015">2015</option>
								<option value="2014">2014</option>
								<option value="2013">2013</option>
								<option value="2012">2012</option>
								<option value="2011">2011</option>
								<option value="2010">2010</option>
								<option value="2009">2009</option>
								<option value="2008">2008</option>
								<option value="2007">2007</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>월</td>
						<td>
							<select name="i_month">
								<option value="3">3월</option>
								<option value="4">4월</option>
								<option value="6">6월</option>
								<option value="7">7월</option>
								<option value="9">9월</option>
								<option value="10">10월</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>시행처</td>
						<td>
							<select name="i_auth">
								<option value="kor">평가원</option>
								<option value="seo">서울 교육청</option>
								<option value="gye">경기 교육청</option>
								<option value="inc">인천 교육충</option>
								<option value="bus">부산 교육충</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="입력하기"></input></td>
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