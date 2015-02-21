// JavaScript Document
var map;                //Map element

google.maps.event.addDomListener(window, 'load', initialize);

//Initializing map in start position
function initialize() {
	var defaultMapOptions = {
		center: {lat : 48.9501, lng : 24.701},
		zoom: 14
	};
	map = new google.maps.Map(document.getElementById('map_container'), defaultMapOptions);
	getReq();
}







//Adding marker to map
function addMarker(position){
	var	marker = new google.maps.Marker({
		position: position,
		title: position.timestamp+"",
		map: map
	});
	marker.setMap(map);
}


//Sending request to server for ATMs
function getReq() {
    $.ajax({
        url: "with time.xml",
        type: "GET",
        context: document.body,
        dataType: "xml",
        success: parse
    })
}

//Receiving data about markers from server and adding marker to map
function parse(data) {
    parsedData = jQuery.parseXML(data);
	jQuery(data).find("GpsData").each(function(){
		var point={
			lat:0,
			lng:0,
			timestamp:0
		};
		point.lat = jQuery(this).attr("latitude")*1;
		point.lng = jQuery(this).attr("longitude")*1;
		point.timestamp = jQuery(this).attr("timestamp")*1;
		addMarker(point)
	})
	
}
