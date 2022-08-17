<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="admin.AdminDAO" %>
<%@page import="admin.ApprovalJoinDTO" %>
<%@page import="java.util.List" %>
<% if(session.getAttribute("name") == null){%>	
	<script>
	alert("로그인이 필요합니다.");
	 location.href="./index.jsp";
	</script>	
<% 
	}
%>
  <%
  	request.setCharacterEncoding("utf-8");
  	
  	AdminDAO adminDAO = new AdminDAO();
  	List<ApprovalJoinDTO> members = adminDAO.selectWaitingMembers();
  %> 
<meta charset="UTF-8">

<p>신규등록 관리자</p>
<ol class="new_admin_title">
    <li>NO</li>
    <li>관리자명</li>
    <li>아이디</li>
    <li>전화번호</li>
    <li>이메일</li>
    <li>담당부서</li>
    <li>담당직책</li>
    <li>가입일자</li>
    <li>승인여부</li>
</ol>
<% if (members.size() == 0) {%>
<ol class="new_admin_none">
    <li>신규 등록된 관리자가 없습니다.</li>
</ol>
<%} else {%>
 <%for(ApprovalJoinDTO member : members) { %>
<ol class="new_admin_lists">
    <li><%=member.getId()%></li>
    <li><%=member.getName()%></li>
    <li><%=member.getAdminId()%></li>
    <li><%=member.getPhoneNumber()%></li>
    <li><%=member.getEmail()%></li>
    <% String depart = member.getDepartment();
    	String department = ""; 
    	switch(depart){
    	case "a" :
    		department = "임원";	
    		break;
    		
    	case "b" :
    		department = "전산팀";
    		break;
    		
    	case "c" :
    		department = "디자인팀";	
    		break;
    		
    	case "d" :
    		department = "CS팀";	
    		break;
    		
    	case "e" :
    		department = "MD팀";	
    		break;
    	} %> 
    <li><%=department%></li>
    	  <% String employee = member.getPosition();
    	String position = ""; 
    	switch(employee){
    	case "1" :
    		position = "대표";	
    		break;
    		
    	case "2" :
    		position = "부장";
    		break;
    		
    	case "3" :
    		position = "팀장";	
    		break;
    		
    	case "4" :
    		position = "과장";	
    		break;
    		
    	case "5" :
    		position = "대리";	
    		break;
    		
    	case "6" :
    		position = "사원";	
    		break;
    	} %> 
    
    <li><%=position%></li>
    <li><%=member.getCreateDate()%></li>
    <li>
        <input type="button" value="승인" class="new_addbtn1" title="승인">
        <input type="button" value="미승인" class="new_addbtn2" title="미승인">
    </li>
</ol>
  <% } %>
<% }%>