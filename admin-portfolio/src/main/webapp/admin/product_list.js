function checkAll(allProducts)  {
  const checkboxes 
       = document.getElementsByName("productCheck");
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = allProducts.checked;
  })
}


function productDeletor(){
	var checkboxes = document.getElementsByName("productCheck");

	var deleteProductId = [];
	checkboxes.forEach(checkbox => (checkbox.checked ? deleteProductId.push(checkbox.value) : checkbox));
	
	location.href = "./product/delete?datas="+deleteProductId;
}


function category() {
	
	location.href = "./admin_category_write.jsp";
}
function newproduct(){
	
	location.href = "./product";
}

function listsearch() {
	
	var searchkey = document.getElementById("searchProduct").value;
	var productKeyword = document.getElementById("productKeyword").value;
	var regxKeyword = /[0-9]/g;
	
	if(searchkey == "" || productKeyword == ""){
		alert("검색어를 입력해주세요.");
	}
	else if(searchkey == 2 && regxKeyword.test(productKeyword) == false){
		alert("상품코드로 검색시 숫자로만 검색 가능합니다.");
	}
	else{
		location.href = "./product-list?searchkey=" + searchkey + "&keyword=" + productKeyword;
	}
}
	
	
