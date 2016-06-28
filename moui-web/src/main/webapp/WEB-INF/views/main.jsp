<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/main.css">
<title>6월 모의고사 결과를 분석해드립니다. 모의고사 분석 서비스 moeui.kr</title>
<script>
	alert(${pageContext.request.contextPath} +  "a");
</script>
</head>
<body>
	<div id="main_container">
		<div id="service_title_area" >
			<h1>6월 모의고사 결과를 분석해드립니다.</h1>
		</div>
		<div id="test_info_input_area" >
			<ul class="input_list">
				<li>분석과목 : 
					<input type="radio" name="subject" value="korean" checked="checked" >국어
					<input type="radio" name="subject" value="math" disabled="disabled">수학
					<input type="radio" name="subject" value="english" disabled="disabled">영어</li>
				<li>틀린문항 : <input id="odab_input" type="text" placeholder="틀린 문항을 입력해주세요."></li>
			</ul>
		</div>
	</div>
</body>
</html>