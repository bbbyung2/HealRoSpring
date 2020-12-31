$(document).ready(function(){
    
		
		$('#coronaryTb').DataTable({
			stateSave: true,
			language: {
				lengthMenu:
					  "Display <select class='browser-default custom-select ml-1 mr-1'>" +
			          '<option value="5">5</option>' +
			          '<option value="10">10</option>' +
			          '<option value="20">20</option>' +
			          '<option value="-1">All</option>' +
			          "</select>"
			},
			pageLength: 10,
			order: [[0, "desc"]],
			drawCallBack: function(){
			  $(".dataTables_paginate > .pagination").addClass("pagination-rounded");
			},
			columnDefs: [
				{ targets: 2, width: 150 }
			]
	    });
		$('#cardioTb').DataTable({
			stateSave: true,
			language: {
				lengthMenu:
					  "Display <select class='browser-default custom-select ml-1 mr-1'>" +
			          '<option value="5">5</option>' +
			          '<option value="10">10</option>' +
			          '<option value="20">20</option>' +
			          '<option value="-1">All</option>' +
			          "</select>"
			},
			pageLength: 10,
			order: [[0, "desc"]],
			ordering: true,
			serverSide: false,
			drawCallBack: function(){
			  $(".dataTables_paginate > .pagination").addClass("pagination-rounded");
			},
			columnDefs: [
				{ targets: 2, width: 150 }
			]
	    });
		$('#diabetesTb').DataTable({
			stateSave: true,
			language: {
				lengthMenu:
					  "Display <select class='browser-default custom-select ml-1 mr-1'>" +
			          '<option value="5">5</option>' +
			          '<option value="10">10</option>' +
			          '<option value="20">20</option>' +
			          '<option value="-1">All</option>' +
			          "</select>"
			},
			pageLength: 10,
			order: [[0, "desc"]],
			drawCallBack: function(){
			  $(".dataTables_paginate > .pagination").addClass("pagination-rounded");
			},
			columnDefs: [
				{ targets: 2, width: 150 }
			]
	    });
		
		if(type == 1)
		{
			$("#selectDisease").val("coronary").prop("selected", true);
			$('#cardio').hide();
			$('#diabetes').hide();
		}
		else if(type == 2)
		{
			$("#selectDisease").val("diabete").prop("selected", true);
			$('#cardio').hide();
			$('#coronary').hide();
			
		}
		else if(type == 3)
		{
			$("#selectDisease").val("cardio").prop("selected", true);
			$('#diabetes').hide();
			$('#coronary').hide();
			
		}
		
		
});


$('#selectDisease').on('change',function(){
	var value = $('#selectDisease').val();
	
	if(value == 'coronary')
	{
		$('#cardio').hide();
		$('#diabetes').hide();
		$('#coronary').show();
	}
	else if(value == 'diabete')
	{
		$('#cardio').hide();
		$('#coronary').hide();
		$('#diabetes').show();
	}
	else if(value == 'cardio')
	{
		
		$('#diabetes').hide();
		$('#coronary').hide();
		$('#cardio').show();
	}
	
})

$('#postBtn').on('click',function(){
	
	var data = $('#selectDisease').val();
	getView("post?type=" + data);
})

function coronaryView(id)
{
	getView("coronaryView?id="+id);
}

function diabeteView(id)
{
	getView("diabeteView?id="+id);
}

function cardioView(id)
{
	getView("cardioView?id="+id);
}
