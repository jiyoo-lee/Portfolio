
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
		frm.method = "get";
		frm.enctype = "application/x-www-form-urlencoded";
		frm.action = "./category";
		console.log(categoryCode);
		console.log(keyword);		
//		frm.submit(); 	
	}
}