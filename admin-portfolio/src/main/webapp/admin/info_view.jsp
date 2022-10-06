<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="admin_login_add">
    <ul>
        <li class="font_color1">관리자 정보 수정</li>
        <li>
        <input type="text" class="add_input1" readonly>
        </li>
        <li>
            <input type="text" class="add_input1" id="password" name="password" placeholder="변경할 패스워드를 입력하세요">
            <input type="text" class="add_input1" id ="password2" placeholder="동일한 패스워드를 입력하세요">
        </li>
        <li class="font_color1">관리자 기본정보 입력</li>
        <li>
            <input type="text" class="add_input1" readOnly>
        </li>
        <li>
        <input type="text" class="add_input1 emails" id ="email">
        </li>
        <li class="font_color1">
        <input type="text" class="add_input1 hp1" maxlength="3" id ="email" >
        -
        <input type="text" class="add_input1 hp2" maxlength="4" id ="email">
        -
        <input type="text" class="add_input1 hp2" maxlength="4" id ="email">
        </li>
        <li class="font_color1">관리자 담당부서 및 직책</li>
        <li>
            <select class="add_select1">
                <option>담당자 부서를 선택하세요</option>
                <option>임원</option>
                <option>전산팀</option>
                <option>디자인팀</option>
                <option>CS팀</option>
                <option>MD팀</option>
            </select>
            <select class="add_select1">
                <option>담당자 직책을 선택하세요</option>
                <option>대표</option>
                <option>부장</option>
                <option>팀장</option>
                <option>과장</option>
                <option>대리</option>
                <option>사원</option>
            </select>
        </li>
        <li class="font_color1">※ 아이디,이름 외 모든 정보는 수정 할 수 있습니다.(개명은 전산팀으로 문의바람)</li>
    </ul>
    <span class="admin_addbtn">
        <button type="button" class="btn_button btncolor1" title="관리자 등록">정보 수정</button>
    </span>
</div>