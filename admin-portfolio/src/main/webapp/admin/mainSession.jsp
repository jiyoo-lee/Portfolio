<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<% if(session.getAttribute("name") == null){
	out.print("<script>alert('로그인이 필요합니다.'); location.href='./index.jsp';</script>");
}else{
	session.setMaxInactiveInterval(20*60);
}
%>
