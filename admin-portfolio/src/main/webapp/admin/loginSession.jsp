<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
 if(session.getAttribute("name") != null){
	out.print("<script>location.href='./admin_main.jsp';</script>"); 
 }
%>
