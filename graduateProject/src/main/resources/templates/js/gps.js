function init()
{
    window.navigator.geolocation.getCurrentPosition(current_position);
}
 
function current_position(position)
{
    var msg;
    
//    msg = "Latitude: " + position.coords.latitude + ", " + "Longitude: " + position.coords.longitude;
    var lat;
    var long;
    lat = position.coords.latitude;
    long = position.coords.longitude;
    msg = lat + ', ' + long;

    document.getElementById('name1').innerHTML = lat
    document.getElementById('name2').innerHTML = long
//    alert(msg);
}
window.addEventListener("load", init);
