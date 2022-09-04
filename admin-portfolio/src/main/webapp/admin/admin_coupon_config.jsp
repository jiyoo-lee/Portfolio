<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  	request.setCharacterEncoding("utf-8");
  %> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쇼핑몰 환경설정</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" type="text/css" href="./css/shipping.css?v=1">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <link rel="stylesheet" href= "./js/jquery-ui.css">
    <script src="./js/jquery.js"></script>
    <script src="./js/jquery-ui.js"></script>
    <script src="./coupon_insert.js"></script>
    
</head>
<body>
<header class="headercss">
<%@include file="./admin_header.html" %>
</header>
<nav class="navcss">
<%@include file="./admin_menu.html" %>
</nav>
<form name="frm" id="frm">
<main class="maincss">
<section style="height: auto;">
<%@include file="./coupon_insert.jsp"%>  
</section>
</main>
</form>
<footer class="main_copyright">
<%@include file="./admin_footer.html" %>
</footer>
</body>
</html>