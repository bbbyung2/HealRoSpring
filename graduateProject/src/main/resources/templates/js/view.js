$( document ).ready(function() {
  
	
	if(img == null)
		{
			$('#imageArea').hide();
			$('#hr').hide();
		
		}
	$('#updateArea').hide();
	$('#admin').hide();
	$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})
		
	if(nickname == userNickName)
	{
		$('#admin').show();
	}
});

function deletePost(id)
{
	if(type == 1)
	{
		getView("deleteCoronaryPost?id=" + id);
	}
	else if(type == 2)
	{
		getView("deleteDiabetePost?id=" + id);
	}
	else if(type == 3)
	{
		getView("deleteCardioPost?id=" + id);
	}
	

}


function deleteComment(id)
{
	var data = id;
	$.ajax({
        url: 'deleteComment',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
	    xhrFields: {
	        withCredentials: true
	    },
    	success: function(response) {
    		
    		if(type == 1)
    		{
    			getView('coronaryView?id='+Id);
    		}
    		else if(type == 2)
    		{
    			getView('diabeteView?id='+Id);
    		}
    		else if(type == 3)
    		{
    			getView('cardioView?id='+Id);
    		}
    		
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});

}

function modifyPost()
{
	$('#showArea').hide();
	$('#updateArea').show();
}

function editPost(id)
{
	var data ={
			"id" : Id,
			"nickname" : userNickName,
			"title" : $('#updateTitle').val(),
			"content" : $('#updateContent').val(),		
	}
	if(type == 1)
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
	    		
	    		if(type == 1)
	    		{
	    			getView('coronaryView?id='+Id);
	    		}
	    		else if(type == 2)
	    		{
	    			getView('diabeteView?id='+Id);
	    		}
	    		else if(type == 3)
	    		{
	    			getView('cardioView?id='+Id);
	    		}
	    		
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
	else if(type == 2)
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
	    		
	    		if(type == 1)
	    		{
	    			getView('coronaryView?id='+Id);
	    		}
	    		else if(type == 2)
	    		{
	    			getView('diabeteView?id='+Id);
	    		}
	    		else if(type == 3)
	    		{
	    			getView('cardioView?id='+Id);
	    		}
	    		
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
	else if(type == 3)
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
	    		
	    		if(type == 1)
	    		{
	    			getView('coronaryView?id='+Id);
	    		}
	    		else if(type == 2)
	    		{
	    			getView('diabeteView?id='+Id);
	    		}
	    		else if(type == 3)
	    		{
	    			getView('cardioView?id='+Id);
	    		}
	    		
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
}

function createComment(id){
	
	var comment = $('#comment').val();
	if(comment == '')
	{
		alert('내용을 입력하세요');
		}
	else
	{
		getView("createComment?id=" + id);
	}
}

$('#commentBtn').on('click',function(){
	
	var comment = $('#comment').val();
	
	var data = {
			"type" : type,
			"comment" : comment,
			"num" : Id,
			"nickname" : userNickName
	}
	
	$.ajax({
        url: 'createComment',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
	    xhrFields: {
	        withCredentials: true
	    },
    	success: function(response) {
    		
    		if(type == 1)
    		{
    			getView('coronaryView?id='+Id);
    		}
    		else if(type == 2)
    		{
    			getView('diabeteView?id='+Id);
    		}
    		else if(type == 3)
    		{
    			getView('cardioView?id='+Id);
    		}
    		
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
})

$('#imageArea').on('click',function(){

		getView("download?img="+img);

})


/**
 * 
 */