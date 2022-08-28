

function app(id,access){
	if(access == 'Y' || access == 'N' || id != "") {
		var ajax = new XMLHttpRequest();
		ajax.open("put","./approval-access?id="+id+"&access="+access,true);
		
		ajax.onload = function () {
		if(ajax.status == 200 && ajax.response == "success"){
			alert("처리 되었습니다.");
			location.reload();
		}
		else{
			alert("데이터 통신 오류로 처리되지 못했습니다.")	
		}
};
		ajax.onerror = function () {
			console.error('onerror');
			console.error(ajax.status);
			console.error(ajax.response);
		};	
		ajax.send();	
	}	
}
