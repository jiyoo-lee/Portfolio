function select(depthCode){
	$('#select2').empty();
	
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

function select2(categoryCode){
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
				alert("상품코드가 중복됩니다요");
			}
			else{
				alert("사용가능한 코드입니다.");
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

function registProduct() {
	
}