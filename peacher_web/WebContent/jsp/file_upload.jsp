<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String msg = (String)request.getAttribute("message");
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
	<%= msg %>
</body>
</html>