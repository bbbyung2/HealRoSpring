function init()
{
    window.navigator.geolocation.getCurrentPosition(current_position);
}
 
function current_position(position)
{

    
    mapInit( position.coords.latitude ,  position.coords.longitude);
    
}

