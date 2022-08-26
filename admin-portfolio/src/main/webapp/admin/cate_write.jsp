<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  	request.setCharacterEncoding("utf-8");
  %> 
<meta charset="UTF-8">
<p>카테고리 등록 페이지</p>
<div class="cate_insert">
    <ul>
        <li>분류코드</li>
        <li><input type="text" class="cate_input1" id="categoryCode" name = "categoryCode" readonly></li>
        <li>※ 분류코드는 대메뉴 코드와 소메뉴 코드를 합쳐서 자동 입력 됩니다.</li>
    </ul>
    <ul>
        <li>대메뉴 코드</li>
        <li>
            <input type="text" class="cate_input2" id="largeMenuCode" name = "largeMenuCode" onkeyup="code()" 
            oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" maxlength="3" list="lg_menu">
            <datalist id="lg_menu">
                <option>01</option>
                <option>02</option>
            </datalist>
        </li>
        <li>※ 대메뉴에 사용할 코드 번호를 입력하세요 최소 2자 이상의 숫자로 입력하셔야 합니다.</li>
    </ul>
    <ul>
        <li>대메뉴명</li>
        <li><input type="text" class="cate_input3" id="largeMenu" name = "largeMenu"> <label><input type="checkbox" style="margin-left:10px; margin-right: 5px;" id="onlyLarge">대메뉴만 생성</label></li>
        	<input type="hidden" name="onlyLarge" id="hiddenCheckbox" value="N">
        <li>※ 소메뉴만 등록시 대메뉴 코드와 대메뉴명은 무조건 입력 되어야 합니다.</li>
    </ul>
    <ul>
        <li>소메뉴 코드</li>
        <li>
            <input type="text" class="cate_input2" id="smallMenuCode" name = "smallMenuCode" 
            oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" maxlength="4" list="lg_menu" onkeyup="code()">
            <datalist id="lg_menu">
                <option>01</option>
                <option>02</option>
            </datalist>
        </li>
        <li>※ 소메뉴에 사용할 코드 번호를 입력하세요 최소 2자 이상의 숫자로 입력하셔야 합니다.</li>
    </ul>
    <ul>
        <li>소메뉴명</li>
        <li><input type="text" class="cate_input3" id="smallMenu" name = "smallMenu"></li>
        <li>※ 대메뉴만 등록시 소메뉴 코드 및 소메뉴명은 입력하지 않으셔도 됩니다.</li>
    </ul>
    <ul>
        <li>사용 유/무</li>
        <li>
            <label class="rmargin"><input type="radio" name="a" value="Y" checked>사용함 </label>
            <label class="rmargin"><input type="radio" name="a" value="N">사용안함</label>
        </li>
        <li>※ 카테고리 사용안함으로 설정시 쇼핑몰에 해당 메뉴는 생성 되지 않습니다.</li>
    </ul>
</div>
<div class="subpage_view4" style="text-align:center;">
    <input type="button" value="카테고리 리스트" title="카테고리 리스트" class="p_button p_button_color1" style="margin-right: 5px;" onclick="categoryList()">
    <input type="button" value="카테고리 생성" title="카테고리 생성" class="p_button p_button_color2" onclick="registerCategory()">
    </span>
</div>