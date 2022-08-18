<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
	session.removeAttribute("name");
	session.invalidate();
%>
<script>
	alert("로그아웃 되셨습니다.");
	location.href = "./index.jsp";
</script>
</body>
</html>