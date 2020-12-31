$("#go").click(function(){ 
		
	
	
	
	
	$('#validAge').hide();
	$('#validSex').hide();
	$('#validBloodPressure').hide();
	$('#validCholesterol').hide();
	$('#validSmoke').hide();
	$('#validAlchol').hide();
	$('#validActive').hide();
	$('#validGlucose').hide();
	$('#validBMI').hide();
	
	
		var data = {
				Sex : $('#Sex').val(),
				BloodPressure : $('#BloodPressure').val(),
				Cholesterol : $('#Cholesterol').val(),
				Glucose: $('#Glucose').val(),
				Smoke : $('#Smoke').val(),
				Alchol : $('#Alchol').val(),
				Active : $('#Active').val(),
				BMI : $('#BMI').val(),
				Age : $('#Age').val()
				
		}
		
		if(data.Age == 0 || data.Sex == -1  || data.BMI == 0 || data.BloodPressure == -1 || data.Glucose == -1 
				|| data.Cholesterol == -1 || data.Smoke == -1 || data.Alchol == -1 || data.Active == -1)
		{
			
			if(data.Age == 0)
			{
				$('#validAge').show();
			}
			
			if(data.Sex == -1)
			{
				$('#validSex').show();
			}
			if(data.BMI == 0)
			{
				$('#validBMI').show();
			}
			
			
			if(data.BloodPressure == -1)
			{
				$('#validBloodPressure').show();
			}
			
			if(data.Cholesterol == -1)
			{
				$('#validCholesterol').show();
			}
			
			if(data.Smoke == -1)
			{
				$('#validSmoke').show();
			}
			if(data.Alchol == -1)
			{
				$('#validAlchol').show();
			}
			if(data.Active == -1)
			{
				$('#validActive').show();
			}
			
			if(data.Glucose == -1)
			{
				$('#validGlucose').show();
			}
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
		        url: "http://3.16.17.117:5000/heartDisease2",
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
			disease : "cardio"
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