<%@page import="admin.category.CategoryDAO"%>
<%@page import="admin.category.Category1DepthCodeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  	request.setCharacterEncoding("utf-8");
	List<Category1DepthCodeDTO> depthList =  (List<Category1DepthCodeDTO>)request.getAttribute("depthList");
  %> 
<meta charset="UTF-8">
<p>상품 등록 페이지</p>
<div class="product_insert">
    <ul>
        <li>대메뉴 카테고리</li>
        <li>
            <select name="select" id="select" onchange="selectCategory1(this.value)">
            	<option>---선택---</option>
            	<%for(Category1DepthCodeDTO depth : depthList) { %>
            	<option value="<%=depth.getDepth1Code()%>"><%=depth.getDepth1Name()%></option>
            	<% } %>
            </select>
        </li>
    </ul>
    <ul>
        <li>소메뉴 카테고리</li>
        <li>
            <select name="select2" id="select2" onchange="selectCategory2(this.value)">
            	<option>---선택---</option>
            </select> 
        </li>
    </ul>
    <ul>
        <li>상품코드</li>
        <li>
            <input type="text" name="productCode" id="product_code" class="product_input1"> 
            <input type="button" value="중복확인" title="중복확인" class="product_btn" onclick="checkOverlap()"> <span class="help_text">※ 상품코드는 절대 중복되지 않도록 합니다.</span>
            <input type="hidden" id="overlapCheck" value="N">
        </li>
    </ul>
    <ul>
        <li>상품명</li>
        <li>
            <input type="text" class="product_input2" id="productName" name="productName" maxlength="100"> <span class="help_text">※ 상품명은 최대 100자까지만 적용할 수 있습니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품 부가설명</li>
        <li>
            <input type="text" class="product_input4" id="productSuDesc" name="productSuDesc" maxlength="200"> <span class="help_text">※ 상품명은 최대 200자까지만 적용할 수 있습니다.</span>
        </li>
    </ul>
    <ul>
        <li>판매가격</li>
        <li>
            <input type="text" id="price" name="price" class="product_input3" maxlength="7" onchange="calculateDiscount()"> <span class="help_text">※ , 없이 숫자만 입력하세요 최대 7자리</span>
        </li>
    </ul>
    <ul>
        <li>할인율</li>
        <li>
            <input type="text" id="discount" name="discount" class="product_input3" maxlength="2" value="0" onchange="calculateDiscount()">% <span class="help_text">※ 숫자만 입력하세요</span>
        </li>
    </ul>
    <ul>
        <li>할인가격</li>
        <li>
            <input type="text" id="discount_price" name="discount_price" class="product_input3" maxlength="7" value="0" readonly> <span class="help_text">※ 할인율이 0%일 경우 할인가격은 0으로 처리 합니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품재고</li>
        <li>
            <input type="text" class="product_input3" id="stock" name="stock" maxlength="4" value="0">EA <span class="help_text">※ 숫자만 입력하세요. 재고가 0일 경우 soldout이 됩니다.</span>
        </li>
    </ul>
    <ul>
        <li>판매 유/무</li>
        <li>
            <label class="product_label">
            <input type="radio" name="sales" value="Y" style="vertical-align:-1px;" checked> 판매시작
            </label>
            <label class="product_label">
            <input type="radio" name="sales" value="N" style="vertical-align:-1px;"> 판매종료
            </label> <span class="help_text">※ 숫자만 입력하세요. 재고가 0일 경우 soldout이 됩니다.</span>
        </li>
    </ul>
    <ul>
        <li>조기품절</li>
        <li>
            <label class="product_label">
                <input type="radio" name="soldOut" value="Y" style="vertical-align:-1px;"> 사용
            </label>
            <label class="product_label">
                <input type="radio" name="soldOut" value="N" style="vertical-align:-1px;" checked> 미사용
            </label>
        </li>
    </ul>
    <ul style="height: 160px;">
        <li>상품 대표이미지</li>
        <li>
            <ol style="width:100%; height: auto;">
            <li style="width:100%; height:45px;">
            <input type="file" id="image1" name="image1" >
            <span class="help_text">※ 상품 대표이미지 이며, 이미지 용량은 2MB 까지 입니다.</span>
            </li>
            <li style="height:45px;">
            <input type="file" id="image2" name="image2" onchange="imageChange()">
            <span class="help_text">※ 추가 이미지 이며, 이미지 용량은 2MB 까지 입니다.</span>
            </li>
            <li style="height:45px;">
            <input type="file" id="image3" name="image3" onchange="imageChange()">
            <span class="help_text">※ 추가 이미지 이며, 이미지 용량은 2MB 까지 입니다.</span>
            </li>
            </ol>
        </li>
    </ul>
    <ul style="height: 400px;">
        <li>상품 상세설명</li>
        <li>
            <textarea class="product_text1"></textarea>
        </li>
    </ul>
</div>
<div class="subpage_view4" style="text-align:center;">
    <input type="button" value="상품 리스트" title="상품 리스트" class="p_button p_button_color1" style="margin-right: 5px;">
    <input type="button" value="상품 등록" title="상품 등록" class="p_button p_button_color2" onclick="registProduct()">
    </span>
</div>