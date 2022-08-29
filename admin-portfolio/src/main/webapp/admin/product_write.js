
function select(depthCode){
	
	$.ajax('./categorycode', {
    type: 'GET',  // http method
    data: { depthCode: depthCode },  // data to submit
    success: function (data) {
        console.log(data.list[0])
    },
    error: function (jqXhr, textStatus, errorMessage) {
            console.log(jqXhr, textStatus, errorMessage)
    	}
	});
}