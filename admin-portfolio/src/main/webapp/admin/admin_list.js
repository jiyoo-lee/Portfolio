

function app(id,access){
		console.log(id + "," + access)
	if(access == 'Y' || access == 'N' || id != "") {
		var ajax = new XMLHttpRequest();
		ajax.open("put","./approval-access?id="+id+"&&acceess="+access,true);
		ajax.send();
		if(ajax.status == 200 && ajax.response == "success"){
			alert("승인처리 되었습니다.");
		} 
	}
	else{
		alert("데이터 통신 오류로 처리되지 못했습니다.")	
	}
}

//$(function (){
//	$('.new_addbtn1').click(function(){
//	 	
//	var $confirm = $('.new_addbtn1').attr('id');
//	var $id = $('.new_addbtn1').val();
//	
//	console.log($confirm + "," + $id);
//		
//		$.ajax({
//				url: "./approval-access",
//				catch: false,
//				type: "POST",
//				dataType: "text",
//				data: {update : $confirm, id:$id},
//				success: function($data) { 
//					if($data == "success"){
//						alert("승인처리가 완료되었습니다.");
//					}
//					else{
//						alert("데이터 통신 오류. 서버 관리자에게 문의하세요.");
//					}
//				},
//				error: function () {
//					console.log("통신오류");
//			}
//		});
//	})
//});
