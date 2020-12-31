	$('#notyet').hide();
	$('#primary').hide();
	$('#secondary').hide();
	$('#ment1').hide();
	$('#ment2').hide();
	$('#ment3').hide();
	$('#ment4').hide();
	$('#ment5').hide();
	$('#ment6').hide();
	
	if(recentResult > 50){
		$('#secondary').show();
	}
	else if(recentResult <= 50 && recentResult > 0){
		$('#primary').show();
	}
	else{
		$('#notyet').show();
	}

	var ctx = document.getElementById('myChart');
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: [recentDate, pastDate],
			datasets: [{
				label: '% of Prediction',
				data: [recentResult,pastResult],
				backgroundColor: [
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)'
					],
					borderColor: [
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)'
						],
						borderWidth: 1
						}]
	},
	options: {
		responsive : false,
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero: true
					}
				}],
			xAxes: [{
		        barPercentage: 0.5
		    }]
			}
		}
	});
	
	var ratio = recentResult / pastResult;
	if(pastResult == null){
		ratio = -1;
	}
	
	if(ratio >= 1.3){
		document.getElementById( "stage" ).setAttribute("src","./img/heart1.png");
		$('#ment1').show();
	}
	else if(ratio >= 1.1 && ratio < 1.3){
		document.getElementById( "stage" ).setAttribute("src","./img/heart2.png");
		$('#ment2').show();
	}
	else if(ratio > 0.9 && ratio < 1.1){
		document.getElementById( "stage" ).setAttribute("src","./img/heart3.png");
		$('#ment3').show();
	}
	else if(ratio > 0.7 && ratio <= 0.9){
		document.getElementById( "stage" ).setAttribute("src","./img/heart4.png");
		$('#ment4').show();
	}
	else if(ratio >= 0 && ratio <= 0.7){
		document.getElementById( "stage" ).setAttribute("src","./img/heart5.png");
		$('#ment5').show();
	}
	else{
		document.getElementById( "stage" ).setAttribute("src","./img/heart6.png");
		$('#ment6').show();
	}