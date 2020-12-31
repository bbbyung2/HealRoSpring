



$("#go").click(function(){ 
		
	$('#validAge').hide();
	$('#validGlucose').hide();
	$('#validBloodPressure').hide();
	$('#validSkinThickness').hide();
	$('#validInsulin').hide();
	$('#validBMI').hide();
	
	
	
		var data = {
				Pregnancies : $('#Pregnancies').val(),
				Glucose : $('#Glucose').val(),
				BloodPressure : $('#BloodPressure').val(),
				SkinThickness : $('#SkinThickness').val(),
				Insulin : $('#Insulin').val(),
				BMI : $('#BMI').val(),
				Age : $('#Age').val()
				
		}
		
		if(data.Age == 0 || data.Glucose == 0 || data.BloodPressure == 0 || data.SkinThickness == 0 || data.Insulin == 0 || 
				data.BMI == 0)
		{
			
			if(data.Age == 0)
			{
				$('#validAge').show();
			}
			
			if(data.Glucose == 0)
			{
				$('#validGlucose').show();
			}
			
			if(data.BloodPressure == 0)
			{
				$('#validBloodPressure').show();
			}
			
			if(data.SkinThickness == 0)
			{
				$('#validSkinThickness').show();
			}
			
			if(data.Insulin == 0)
			{
				$('#validInsulin').show();
			}
			
			if(data.BMI == 0)
			{
				$('#validBMI').show();
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
		        url: "http://3.16.17.117:5000/diabetes",
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
			disease : "diabetes"
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

/**
 * 
 */