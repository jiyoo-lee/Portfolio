<%@page import="admin.notice.NoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8");
	List<NoticeDTO> notice = (List<NoticeDTO>)request.getAttribute("notice");
	%>        
<meta charset="UTF-8">
<p>공지사항 VIEW 페이지</p>
<div class="write_view">
<ul>
	<%for(NoticeDTO noti : notice){ %>
    <li>공지번호</li>
    <li value="<%=noti.getId()%>" id="page"><%=noti.getId()%></li>
</ul>
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox"<%if(noti.getTopExposure().equals("Y")) {%>checked<%} %>></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" class="notice_input1" value="<%=noti.getTitle()%>"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" class="notice_input2" value="<%=noti.getWriter()%>" readonly> ※ 관리자 이름이 노출 됩니다.       
    </li>
</ul>
<ul>
    <li>첨부파일</li>
    <li>
        <input type="file"> ※ 새로운 첨부파일 적용시 기본 첨부파일은 삭제 됩니다.
        <em class="fileview">기존 첨부 파일명 :<%=noti.getAttachments()%></em>
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3"><%=noti.getContent()%></textarea>
    </li>
</ul>
</div>
 
<div class="board_btn">
    <button class="border_list" id="go_notice_list">공지목록</button>
    <button class="border_modify" id="go_notice_modify">공지수정</button>
    <button class="border_del" id="go_notice_delete">공지삭제</button>
</div>
 <% } %>