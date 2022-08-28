function categoryList(){
	
	location.href="./admin_category.jsp";
}

function code(){
	var large = document.getElementById("largeMenuCode").value;
	var small = document.getElementById("smallMenuCode").value;
	var code = large + small;
	document.getElementById("categoryCode").value = code;
}

$(function(){
	$("#onlyLarge").change(function(){
		if($("#onlyLarge").is(":checked")){
			$("#hiddenCheckbox").val("Y");
		}
		else {
			$("#hiddenCheckbox").val("N");
		}
	})
});

function registerCategory(){
	
	var categoryCode = document.getElementById("categoryCode").value;
	var largeMenuCode = document.getElementById("largeMenuCode").value;
	var largeMenu = document.getElementById("largeMenu").value;
	var smallMenuCode = document.getElementById("smallMenuCode").value;
	var smallMenu = document.getElementById("smallMenu").value;
	var onlyLarge = document.getElementById("onlyLarge");
	var hiddenValue = document.getElementById("hiddenCheckbox").value;
	
	if(categoryCode == "" || largeMenuCode == "" || largeMenu == ""){
		alert("모든 사항을 기입해주세요.");
	}
	else if(hiddenValue == "Y" && (smallMenuCode != "" || smallMenu != "") ){
		alert("대메뉴만 작성을 원하시면 소메뉴 작성칸을 삭제하고 대메뉴만 생성에 체크 해주세요.");
	}
	else{
	 	if (onlyLarge.checked) {
			onlyLarge.value = "Y";
			document.getElementById("smallMenuCode").value = null;
			document.getElementById("smallMenu").value = null;
			console.log(hiddenValue);
		}
		else if(!onlyLarge.checked) {
			onlyLarge.value = "N";
			console.log(hiddenValue);
		}
			frm.method = "POST";
			frm.enctype = "application/x-www-form-urlencoded";
			frm.action = "./category";
			frm.submit();
		}
	}
