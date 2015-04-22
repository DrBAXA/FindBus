// JavaScript Document
var map;                //Map element
var markers = [];       //all favorite addresses

google.maps.event.addDomListener(window, 'load', initialize);

//Initializing map in start position
function initialize() {
	var defaultMapOptions = {
		center: {lat : 48.9501, lng : 24.701},
		zoom: 14
	};
	map = new google.maps.Map(document.getElementById('map_container'), defaultMapOptions);
    //addMarker({lat: })
}

//Adding marker to map
function addMarker(position, title){
    for(var i = 0; i < markers.length; i++){
        markers[i].setMap(null);
    }
    markers = [];
    var markerPos = new google.maps.LatLng(position.lng, position.lat);
    var	marker = new google.maps.Marker({
        position: markerPos,
        map: map,
        title: title
    });
    marker.setMap(map);
	markers.push(marker);
}

//Creating GET HTTP request object
function GetXmlHttpObject(){
    if (window.XMLHttpRequest){
       	return new XMLHttpRequest();
    }
    if (window.ActiveXObject){
      	return new ActiveXObject("Microsoft.XMLHTTP");
    }
 	return null;
}
