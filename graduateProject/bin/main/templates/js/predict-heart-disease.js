var _checkSmoke = 0;

$( document ).ready(function() {
    $('#targetSmoke').hide();
});




$("#Smoke").change(function(){

	if($(this).val() == 1)
	{
		$('#targetSmoke').show();
		_checkSmoke = 1;
	}
	else
	{
		$('#targetSmoke').hide();
		_checkSmoke = 0;
	}
	
});






$("#go").click(function(){ 
		
	
	
	
	
	$('#validAge').hide();
	$('#validSex').hide();
	$('#validPressMadicine').hide();
	$('#validBrain').hide();
	$('#validPress').hide();
	$('#validDiabetes').hide();
	$('#validSmoke').hide();
	$('#validsmokeCount').hide();
	$('#validBMI').hide();
	
	
		if(_checkSmoke == 1)
		{
			var data = {
					male : $('#Sex').val(),
					BPMeds : $('#PressMadicine').val(),
					prevalentStroke : $('#Brain').val(),
					prevalentHyp: $('#Press').val(),
					diabetes : $('#Diabetes').val(),
					currentSmoker : $('#Smoke').val(),
					cigsPerDay : $('#smokeCount').val(),
					BMI : $('#BMI').val(),
					age : $('#Age').val()
					}
				
		}
		else
		{
			var data = {
			male : $('#Sex').val(),
			BPMeds : $('#PressMadicine').val(),
			prevalentStroke : $('#Brain').val(),
			prevalentHyp: $('#Press').val(),
			diabetes : $('#Diabetes').val(),
			currentSmoker : $('#Smoke').val(),
			cigsPerDay : 0,
			BMI : $('#BMI').val(),
			age : $('#Age').val()
			}
			
		}
		
		
		
		
		
		if(data.age == 0 || data.male == -1  || data.BMI == 0 || data.currentSmoker == -1 || data.diabetes == -1 
				|| data.prevalentHyp == -1 || data.prevalentStroke == -1 || data.BPMeds == -1 )
		{
			
			if(data.age == 0)
			{
				$('#validAge').show();
			}
			
			if(data.male == -1)
			{
				$('#validSex').show();
			}
			if(data.BMI == 0)
			{
				$('#validBMI').show();
			}
			
			
			if(data.currentSmoker == -1)
			{
				$('#validSmoke').show();
			}
			
			if(data.diabetes == -1)
			{
				$('#validDiabetes').show();
			}
			
			if(data.prevalentHyp == -1)
			{
				$('#validPress').show();
			}
			if(data.prevalentStroke == -1)
			{
				$('#validBrain').show();
			}
			if(data.BPMeds == -1)
			{
				$('#validPressMadicine').show();
			}
			
			
		}
		else if(_checkSmoke == 1 && data.cigsPerDay == 0)
		{
			$('#validsmokeCount').show();
		}
		else
		{
			$('#go').empty();
			var html = "<button class='btn btn-warning btn-lg btn-block'>Loading</button>"
			$('#go').append(html);
			
			JSON.stringify(data);
			console.log(data);
			$.ajax({
		        type: "GET",
		        dataType: "jsonp",
		        data : data,
		        url: "http://3.16.17.117:5000/heartDisease",
		        success: function (data) {
		        	$('#go').empty();
					var html = "<button class='btn btn-primary btn-lg btn-block'>Go</button>"
					$('#go').append(html);
					recordResult(data.odd);
		        	var result = data.odd +"%";
		        	$('#textArea').empty();
		        	$('#textArea').append(result);
		            
		        }
		    });
			
		}
		
		
}); 



function calculate(){
	
	$('#validheight').hide();
	$('#validweight').hide();
	
	var height = $('#height').val()/100;
	var weight = $('#weight').val();
	
	
	if(height == "" || weight == "")
	{
		if(height == "")
		{
			$('#validheight').show();
		}
		
		if(weight == "")
		{
			$('#validweight').show();
		}
	}
	else
	{
		var BMI = (weight / (height * height)).toFixed(2);
		$('#modalClose').click();
		$('#target').empty();
		
		var html = "<label for='BMI'>BMI 지수</label>" +
					"<input class = 'form-control' id='BMI' type='number' value='" + BMI + "'>";
		
		$('#target').append(html);
		
	}
}

function recordResult(x){
	data ={
			odd : x,
			disease : "coronary"
			};
	$.ajax({
        url: 'recordResult',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
	    xhrFields: {
	        withCredentials: true
	    },
    	success: function(response) {
    		console.log(response);
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
}