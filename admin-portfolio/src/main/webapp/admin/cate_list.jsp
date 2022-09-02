<%@page import="admin.category.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  	request.setCharacterEncoding("utf-8");
	List<CategoryDTO> categories = (List<CategoryDTO>)request.getAttribute("categories");
  %> 
<meta charset="UTF-8">
<p>카테고리관리 페이지</p>
<div class="subpage_view">
    <span>등록된 카테고리 0건</span>
    <span>
        <select class="p_select1" id="select">
            <option value="1">카테고리명</option>
            <option value="2">카테고리코드</option>
        </select>
        <input type="text" class="p_input1" placeholder="검색어를 입력해 주세요" id="keyword" name="keyword">
        <input type="submit" value="검색" title="카테고리 검색" class="p_submit" onclick="search()">
    </span>
</div>
<div class="subpage_view2">
    <ul>
        <li><input type="checkbox"></li>
        <li>분류코드</li>
        <li>대메뉴 코드</li>
        <li>대메뉴명</li>
        <li>소메뉴 코드</li>
        <li>소메뉴명</li>
        <li>사용 유/무</li>
        <li>관리</li>
    </ul>
    
    <% if(categories.size() != 0) { 
     	for(CategoryDTO category : categories) {
    %>
    <ul>
        <li><input type="checkbox"></li>
        <li style="text-align: left; text-indent: 5px;"><%=category.getCode()%></li>
        <li><%=category.getDepthCode1()%></li>
        <li style="text-align: left; text-indent: 5px;"><%=category.getDepthName1()%></li>
        <li><%=category.getDepthCode2()%></li>
        <li style="text-align: left; text-indent: 5px;"><%=category.getDepthName2()%></li>
        <li><%=category.getUsage()%></li>
        <li>[수정]</li>
    </ul>
    <%
     	}
     } else { %>
    <ul>
        <li style="width: 100%;">등록된 카테고리가 없습니다.</li>
    </ul>
    <% } %>
</div>
<div class="subpage_view3">
    <ul class="pageing">
        <li><img src="./ico/double_left.svg"></li>
        <li><img src="./ico/left.svg"></li>
        <li>1</li>
        <li><img src="./ico/right.svg"></li>
        <li><img src="./ico/double_right.svg"></li>
    </ul>
</div>
<div class="subpage_view4">
    <input type="button" value="카테고리 삭제" title="카테고리 삭제" class="p_button">
    <span style="float: right;">
    <input type="button" value="상품 리스트" title="상품 리스트" class="p_button p_button_color1" onclick="list_product()">
    <input type="button" value="카테고리 등록" title="카테고리 등록" class="p_button p_button_color2" onclick="regist_category()">
    </span>
</div>