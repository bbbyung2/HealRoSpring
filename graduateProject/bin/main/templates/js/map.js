
function init()
{
    window.navigator.geolocation.getCurrentPosition(current_position);
}
 
function current_position(position)
{

    
    mapInit( position.coords.latitude ,  position.coords.longitude);
    
}
 
window.addEventListener("load", init);
function mapInit(latitude,logitude)
{
	var mapOptions = {
		    center: new naver.maps.LatLng(latitude, logitude),
		    zoom: 13
		};

	var map = new naver.maps.Map('map', mapOptions);
	
	var MarkerOptions = {
			position : new naver.maps.LatLng(latitude, logitude),
			map : map,
			icon: {
		        url: '../img/house.png',
		        size: new naver.maps.Size(50, 52),
		        origin: new naver.maps.Point(0, 0),
		        anchor: new naver.maps.Point(25, 26)
		    }
	}
	
	var marker = new naver.maps.Marker(MarkerOptions);
	
	$.each(hospList,function(index,value){
		
		var MarkerOptions = {
				
				position : new naver.maps.LatLng(value.hospitalLatitude, value.hospitalLongitude),
				map : map,
			    icon: {
			        url: '../img/hospital.png',
			        size: new naver.maps.Size(50, 52),
			        origin: new naver.maps.Point(0, 0),
			        anchor: new naver.maps.Point(25, 26)
			    }
				
		}
		
		console.log(value.hospitalName);
		var contentString = [
	        '<div class="iw_inner">',
	        '   <h3>"'+String(value.hospitalName)+'"</h3>',
	        '   <p>"'+value.hospitalAddr+'"<br />',
	        '       <img src="'+ value.hospitalImg +'" width="50" height="30" alt="서울시청" class="thumb" /><br />',
	        '       "'+value.hospitalPhone+'"<br />',
	        '       <a href="'+value.hospitalWeb+'" target="_blank">"'+value.hospitalWeb+'"/</a>',
	        '   </p>',
	        '</div>'
	    ].join('');
		value.hospitalName = new naver.maps.Marker(MarkerOptions);
	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});

	naver.maps.Event.addListener(value.hospitalName, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, value.hospitalName);
	    }
	});
		
	});
	
}
