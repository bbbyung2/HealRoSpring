/**
 * 
 */

$('#postBtn').on('click',function(){
	
	
	var fileValue = $("#file").val().split("\\");
	var fileName = fileValue[fileValue.length-1];
	fileName = fileName.replace(/(\s*)/g, "") ;
	
	var data = {
			'nickname' :userNickName,
			'title' : $('#title').val(),
			'content': $('#content').val(),	
			'img' : fileName
	}
	
	
	
	var formData = new FormData();
	console.log($('input[type=file]')[0].files[0]);
	formData.append('img', $('#file')[0].files[0]);
	console.log(formData);
	
	
	
	$.ajax({
		//두개 false로 해야함.
        url: 'uploadImage',
        type: 'POST',
        data: formData,
        datatype: 'text',
        contentType : false,
        processData : false,
    	success: function(response) {
    		
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
	
	
	
	if(type == "coronary")
	{
		$.ajax({
	        url: 'createCoronary',
	        type: 'POST',
	        data: JSON.stringify(data),
	        contentType: 'application/json',
		    xhrFields: {
		        withCredentials: true
		    },
	    	success: function(response) {
	    		
	    		getView('community?type=1');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
	else if(type == "diabete")
	{
		$.ajax({
	        url: 'createDiabete',
	        type: 'POST',
	        data: JSON.stringify(data),
	        contentType: 'application/json',
		    xhrFields: {
		        withCredentials: true
		    },
	    	success: function(response) {
	    		
	    		getView('community?type=2');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
		
	}
	else if(type == "cardio")
	{
		$.ajax({
	        url: 'createCardio',
	        type: 'POST',
	        data: JSON.stringify(data),
	        contentType: 'application/json',
		    xhrFields: {
		        withCredentials: true
		    },
	    	success: function(response) {
	    		
	    		getView('community?type=3');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
	
})