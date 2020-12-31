function mail()
{
	
	$.ajax({
		//두개 false로 해야함.
        url: 'mail',
        type: 'GET',
        datatype: 'text',
        contentType : false,
        processData : false,
    	success: function(response) {
    		alert("메일이 발송되었습니다");
    		$('#modalClose').click();
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
	
	
}