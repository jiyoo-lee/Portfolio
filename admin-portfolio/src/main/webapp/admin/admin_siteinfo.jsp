<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  	request.setCharacterEncoding("utf-8");
  %> 
<meta charset="UTF-8">
<p>홈페이지 가입환경 설정</p>

<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" class="in_form1" id="config_title" name="title" value ="<%list%>">
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" class="in_form2" id="config_email" name="email"> 
        ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" value="Y" name="point">포인트 사용</label></em> 
        <em><label><input type="radio" class="ckclass" value="N" name="point" checked >포인트 미사용</label></em>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" name="defaultPoint" id="default_point"
        oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" 
        maxlength="5"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" 
        name="level" id="level"
         oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')"
        maxlength="1"> 레벨
    </li>
</ul> 
</div>

<p>홈페이지 기본환경 설정</p>

<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" id="company" name="company"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" id="rg_num" name="rgNumber" maxlength="14"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" id="m_director" name="director"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" id="m_number" name="directorNumber"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" id="report_number" name="reportNumber"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" id="value_number" name="valueNumber"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" id="postalcode" name="postalcode"
        oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" maxlength="5"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" id="company_addr" name="companyAddr"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" id ="info_manager" name="infoManager"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" id="info_email" name="infoEmail"> 
    </li>
</ul>
</div>

<p>결제 기본환경 설정</p>

<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" class="in_form0" id="bank" name="bank"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" id="bank_account" name="bankAccount"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" value="Y" name="credit"> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" value="N" name="credit" checked> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" value="Y" name="mobile"> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" value="N" name="mobile" checked> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" value="Y" name="voucher"> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" value="N" name="voucher"checked> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" 
        id="min_point" name="minPoint"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')"
        id="max_point" name="maxPoint"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" value="Y" name="receipt"> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" value="N" checked  name="receipt"> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" class="in_form0" id="shipping_name" name="shippingName"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" class="in_form0" id="shipping_cost" name="shipping_cost" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')"
         maxlength="7"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" value="Y"  name="deliveryDate"> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" value="N" name="deliveryDate" checked> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" id="config_save">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="cancel();">저장 취소</button>

</div>