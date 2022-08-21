

function noticeRegistor(){
	location.href ="./admin_notice_write.jsp";
}

function noticeDeletor(){
	var checkboxes = document.getElementsByName("deleteCheck");
	
	var deleteNoticeId = [];
	checkboxes.forEach(checkbox => (checkbox.checked ? deleteNoticeId.push(checkbox.value) : checkbox));
	
	location.href = "./notice-control?datas="+deleteNoticeId;
}