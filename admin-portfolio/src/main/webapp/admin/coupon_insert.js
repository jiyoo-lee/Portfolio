$(function (){
	$("#usageStart").datepicker();
 	$('#usageStart').datepicker("option", "maxDate", $("#usageEnd").val());
    $("#usageStart").datepicker("option", "onClose", function ( selectedDate ) {
        $("#usageEnd").datepicker( "option", "minDate", selectedDate );
    });
	
	
	$("#usageEnd").datepicker();
	$('#usageEnd').datepicker();
    $('#usageEnd').datepicker("option", "minDate", $("#usageStart").val());
    $('#usageEnd').datepicker("option", "onClose", function ( selectedDate ) {
        $("#usageStart").datepicker( "option", "maxDate", selectedDate );
    });
	
	$("#couponList").click(function() {
		console.log("쿠폰리스트로 갈것");
	})
	
	
	$("#couponRegist").click(function(){
	
	var startDay = $("#usageStart").val();
	var endDay = $("#usageEnd").val();
	var couponName = $("#couponName").val();
	var couponType = $("#counponType option:selected").val();
	var discountType = $("#discountType option:selected").val();
	var discount = $("#discount").val();
	var minPrice = $("#minPrice").val();
	var couponImage = $("#couponImage").val();
	
	
	if(couponName == "" || couponName.lenght > 40){
		alert("쿠폰명을 확인해주세요. 쿠폰명은 최대 40자까지만 가능합니다.");
	}
	else if(couponType == ""){
		alert("쿠폰 종류를 선택해주세요.");
	}
	else if(startDay == "" || endDay == ""){
		alert("쿠폰 사용기한을 입력해주세요");
	}
	else if (discountType == ""){
		alert("할인 종류 입력해주세요.")
	}
	else if(discount == ""){
		alert("할인 금액 또는 할인율을 입력해주세요.")
	}
	else if(minPrice == ""){
		alert("최소 금액을 입력해주세요")
	}
	else if(couponImage == "") {
		alert("쿠폰이미지를 첨부해주세요 ")
	}
	else if(discountType == 1 && discount < 1000){
		alert("정액 할인 금액은 1000원 이상의 금액이 입력되어야합니다.")
	}
	else if(discountType == 2 && discount > 100){
		alert("정률 할인 금액은 100%이상의 값은 입력하실 수 없습니다.")
	}
	else if(minPrice < 10000){
		alert("최소 주문금액 설정은 만원 이상부터입니다.")
	}
	else {
		$("#usageStart").val(startDay + " 00:00:00");
		$("#usageEnd").val(endDay + " 23:59:59");
		
		frm.method = "post";
		frm.enctype = "multipart/form-data";
		frm.action = "./coupon";
		frm.submit();
	}
	
		
	})
});