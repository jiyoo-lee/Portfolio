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
		var $noticeTitle = $("#noticeTitle").val();
		var $writer = $("#writer").val();
		var $content = $("#content").val();
		
		if($noticeTitle == "" || $content == ""){
			alert("모든 사항을 기재바랍니다.");
		}
		else if($("#writer") == ""){
			alert("세션이 만료되었습니다. 로그인 바랍니다.");
			location.href = "./index.jsp";
		}		
		else{ 
			frm.method = "POST";
			frm.action = "./notice";
			frm.enctype = "application/x-www-form-urlencoded";
			frm.submit();
		}
	}
}