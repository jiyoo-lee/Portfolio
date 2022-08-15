<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="admin.AdminDAO" %>
<%@page import="admin.ApprovalJoinDTO" %>
<%@page import="java.util.List" %>

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
    <li><%=member.getDepartment()%></li>
    <li><%=member.getPosition()%></li>
    <li><%=member.getCreateDate()%></li>
    <li>
        <input type="button" value="승인" class="new_addbtn1" title="승인">
        <input type="button" value="미승인" class="new_addbtn2" title="미승인">
    </li>
</ol>
  <% } %>
<% }%>