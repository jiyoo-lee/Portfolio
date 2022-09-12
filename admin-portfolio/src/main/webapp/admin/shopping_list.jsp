<%@page import="admin.coupon.CouponDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  	request.setCharacterEncoding("utf-8");		
	List<CouponDTO> coupons = (List<CouponDTO>)request.getAttribute("coupons");
	int pageCount = (int) request.getAttribute("pageCount");
 %> 
<p>쇼핑몰 관리 페이지</p>
    <div class="subpage_view">
        <span>※ 쿠폰발행 현황 리스트 | <em>[ 사용중인 쿠폰 0 ]</em></span>
        <span>
         <ol class="coupon_title">
            <li>번호</li>
            <li>쿠폰명</li>
            <li>쿠폰종류</li>
            <li>사용시작일</li>
            <li>사용종료일</li>
            <li>쿠폰타입</li>
            <li>할인금액</li>
            <li>최소주문금액</li>
         </ol>
         <%
         if (coupons.size() == 0) {
         %>
         <ol class="coupon_none_lists">
            <li>등록된 쿠폰이 없습니다.</li>
         </ol>
         <%
         }
         else {
        	 for (CouponDTO coupon : coupons) {	 
         %>
         	<ol class="coupon_lists">
            	<li><%=coupon.getId()%></li>
            	<li><%=coupon.getName()%></li>
            	<li><%=coupon.getType()%></li>
            	<li><%=coupon.getUsageStart()%></li>
            	<li><%=coupon.getUsageEnd()%></li>
            	<li><%=coupon.getDiscountType()%></li>
            	<li><%=coupon.getPriceOrRate()%></li>
            	<li><%=coupon.getMinPrice()%></li>
         	</ol>
         <%
         	}
         }
         %>
        </span>
		<%
			for (int i = 1; i <= pageCount; i++) {
		%>		
	        <div style="border:1px solid black;" >
	        	<a href="./coupon?pageNumber=<%=i%>"><%=i%></a>
	        </div>
 		<%
 			}
 		%>       
        <span><input type="button" value="쿠폰 등록하기" class="shopping_btn" onclick="mkCoupon()"></span>
    </div>
    <div class="subpage_view">
        <span>※ 팝업창 현황 리스트 </span>
        <span>
         <ol class="popup_title">
            <li>번호</li>
            <li>팝업명</li>
            <li>팝업 창크기</li>
            <li>링크</li>
            <li>사용시작일</li>
            <li>사용종료일</li>
         </ol>
         <ol class="popup_lists">
            <li>1</li>
            <li>가을신상품 소개</li>
            <li>300 * 200</li>
            <li>http://</li>
            <li>2022-09-01</li>
            <li>2022-09-30</li>
         </ol>
         <ol class="coupon_none_lists">
            <li>등록된 팝업창이 없습니다.</li>
        </ol>
        </span>
        <span><input type="button" value="팝업창 등록하기" class="shopping_btn"></span>
    </div>