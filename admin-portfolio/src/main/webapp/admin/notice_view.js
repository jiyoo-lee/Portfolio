$(function(){
	$("#go_notice_list").click(function() {
		location.href = "./notice";
	})
	
	$("#go_notice_modify").click(function() {
		var id = $("#page").val();
		
		frm.method ="post";
		frm.actionc = "./noticeview";
		frm.submit();
	})
	
	$("#go_notice_delete").click(function() {
		var idx = $("#page").val();
		
		$.ajax({
		url: "./notice-control",
		type: "post",
		traditional : true,
		data : {"datas": idx},
		dataType: "json",
		success : function(response){
			if(response == "1"){
				alert("삭제 처리 되었습니다.");
				location.href = "./notice";
			}
			else {
				alert("데이터 통신 오류로 처리되지 못했습니다.");
			}
		},
		error : function(){
			alert("올바른 접근이 아닙니다.")
		}
	})
	})
});