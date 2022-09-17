

function noticeRegistor(){
	location.href ="./admin_notice_write.jsp";
}

function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName("deleteCheck");
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}


function noticeDeletor(){
	var checkboxes = document.getElementsByName("deleteCheck");
	
	var deleteNoticeId = [];
	checkboxes.forEach(checkbox => (checkbox.checked ? deleteNoticeId.push(checkbox.value) : checkbox));
	console.log(deleteNoticeId);
	$.ajax({
		url: "./notice-control",
		type: "post",
		traditional : true,
		data : {"datas": deleteNoticeId},
		dataType: "json",
		success : function(response){
			if(response == "1"){
				alert("삭제 처리 되었습니다.");
				location.reload();
			}
			else {
				alert("데이터 통신 오류로 처리되지 못했습니다.");
			}
		},
		error : function(){
			alert("올바른 접근이 아닙니다.")
		}
	})
}