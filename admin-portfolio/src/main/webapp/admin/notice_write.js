$(function(){
	$("#top_exposure").change(function(){
		if($("#top_exposure").is(":checked")){
			$("#hiddenCheckbox").val("Y");
		}
		else {
			$("#hiddenCheckbox").val("N");
		}
	})
});

function register() {
	if(confirm("공지를 등록하시겠습니까?")){
		frm.method = "POST";
		frm.action = "./notice";
		frm.enctype = "application/x-www-form-urlencoded";
		frm.submit();
	}
}