var HEALRO_REST_POST_URL = setRestUrl(); 

$( document ).ready(function() {
  
});

function setRestUrl(){
	var wholeUrl = window.location.href;
	var url = "http://"+wholeUrl.split("/")[2];
	return url;
}

function getView(func){
	location.href = HEALRO_REST_POST_URL+"/"+func;
	
}

function logout(){
	console.log('exec logout()');
    getView('logout');
}

function heartDiseasePredict()
{
	if(userNickName != null)
	{
		getView('predictHeartDisease');
	}
	else
	{
		getView('login');
	}
}

function heartDiseasePredict2()
{
	if(userNickName != null)
	{
		getView('predictHeartDisease2');
	}
	else
	{
		getView('login');
	}
}


function diabetesPredict()
{
	if(userNickName != null)
	{
		getView('predictDiabetes');
	}
	else
	{
		getView('login');
	}
}

// function toggleLang() {
// 	let element = document.getElementById('translation');
// 	console.log(element.value)
// 	if (element.value === 'KOR') {
// 		element.value = 'ENG'
// 	} else if (element.value === 'ENG') {
// 		element.value = 'KOR';
// 	}
// }

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
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
	
	
}


