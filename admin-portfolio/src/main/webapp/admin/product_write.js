function selectCategory1(depthCode){
	$('#select2').empty();
	$('#select2').append('<option>---선택---</option>');
	
	$.ajax({
		type: "GET",
		url: "./categorycode",
		async: false,
		data: {depthCode:depthCode},
		datatype: "json",
		success : function(data){
			var length = data.aList.length;
			for (var i = 0; i < length; i++) {
				var depth2Info = data.aList[i].split(",");
				var optionTag = '<option value="' + depth2Info[0] + '">' + depth2Info[1] + '</option>';
				$('#select2').append(optionTag);
			}
			
		}, error : function(xhr){
			console.log(xhr.responseText);
			return;
		}
	})
}

function selectCategory2(categoryCode){
	$.ajax({
		type: "GET",
		url: "./product-code/recommand",
		async: false,
		data: {categoryCode:categoryCode},
		datatype: "text",
		success : function(data){
			$('#product_code').val(data);			
		}, error : function(xhr){
			console.log(xhr.responseText);
			return;
		}
		
	})
}

function checkOverlap() {
	var productCode = $('#product_code').val();
	if(productCode == '') {
		alert('상품코드를 입력해주세요.');
	}
	else {
		$.ajax({
		type: "GET",
		url: "./product/overlap",
		async: false,
		data: {productCode: productCode},
		datatype: "text",
		success : function(data){
			if (data == true) {
				alert("상품코드가 중복됩니다.");
			}
			else{
				alert("사용가능한 코드입니다.");
				$('#overlapCheck').val("Y");
			}
		},
		error : function(xhr){
			console.log(xhr.responseText);
			return;
		}})
	}
}

function calculateDiscount() {
	var price = $('#price').val();
	var discount = $('#discount').val();
	var discount_price = Math.round(price * (100 - discount) / 100);
	
	$('#discount_price').val(discount_price);
}


function listProduct() {

	location.href = "./product-list";
}


function registProduct() {
	var overlapCheck = $("#overlapCheck").val();
	var productCode = $("#product_code").val();
	var productName = $("#productName");
	var productSubDesc = $("#productSubDesc");
	var price = $("#price");
	var discount = $("#discount");
	var discountPrice = $("#discount_price").val();
	var stock = $("#stock");
	var image1 = $("#image1").val();
	var productDetailDesc = $("#productDetailDesc").val();
	
	if(overlapCheck == "N"){
		alert("상품코드 중복체크를 해주세요.");
	}
	else if(productCode.length != 12){
		alert("코드는 대메뉴 카테고리 코드 + 소메뉴 카테고리 코드 + 상품코드 6자리인 12자리로 입력하셔야합니다.");
	}
	else if(productName.val() == ""){
		alert("상품명을 입력해주세요");
		productName.focus();
	}
	else if(productSubDesc.val() == ""){
		alert("상품 부가설명을 입력해주세요.");
		productSubDesc.focus();
	}
	else if(price.val() == ""){
		alert("상품 판매 가격을 입력해주세요.");
		price.focus();
	}
	else if(discount.val() == ""){
		alert("상품 할인 가격을 입력해주세요. 숫자만 입력 가능합니다.")
		discount.focus();
	}
	else if(!image1){
		alert("이미지는 순서대로 첨부해야 하며 최소 하나의 이미지 첨부가 필요합니다.");
	}
	else if(productDetailDesc == ""){
		alert("상품 상세 설명을 입력해주세요.")
	}
	else{
		if(stock.val() == "0"){
			confirm(" 재고를 0으로 입력하면 soldout 처리되어집니다. 진행하시겠습니까?")
		}
		frm.method='POST';
		frm.action="./product";
		frm.enctype="multipart/form-data";
		frm.submit();
	}
}