
function allBox(allCategories)  {
  const checkboxes 
       = document.getElementsByName("categoryCheck");
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = allCategories.checked;
  })
}

function categoryDeletor(){
	var checkboxes = document.getElementsByName("categoryCheck");

	var deletCategoryCode = [];
	checkboxes.forEach(checkbox => (checkbox.checked ? deletCategoryCode.push(checkbox.value) : checkbox));
	
	location.href = "./category/delete?datas="+deletCategoryCode;
}


function search(){
	
	var categoryCode = document.getElementById("select").value;
	var keyword = document.getElementById("keyword").value;
	var regxKeyword = /[0-9]/g;
	
	if(keyword == "" || categoryCode == ""){
		alert("검색어를 입력해주세요.");
	}
	else if (categoryCode == 2 && regxKeyword.test(keyword) == false){
		alert("카테코리 코드로 검색시 숫자로만 검색 가능합니다.");	
	}
	else{
		location.href="./category?search="+categoryCode+"&keyword="+keyword;
	};
}

function list_product() {
	location.href = "./product-list";
}	

function regist_category() {
	location.href = "./admin_category_write.jsp";
}
