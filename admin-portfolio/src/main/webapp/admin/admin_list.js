
$(function (){
	$("input[name=approval]").click(function(){
	 	
	var $confirm = $('[name="check"]').attr('id');
	var $id = $('[name="check"]').val();
	
	console.log($confirm);
		
		$.ajax({
				url: "./approval-access",
				catch: false,
				type: "POST",
				dataType: "text",
				data: {update : $confirm, id:$id},
				success: function($data) { 
					if($data == "success"){
						alert("승인처리가 완료되었습니다.");
					}
					else{
						alert("데이터 통신 오류. 서버 관리자에게 문의하세요.");
					}
				},
				error: function () {
					console.log("통신오류");
			}
		});
	})
});
