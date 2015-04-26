<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/"/>resources/style.css">
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA4YR8loJtUaiviLc-WxnBsSH9Znt9TNEY"></script>
    <script src="<c:url value="/"/>resources/richmarker-compiled.js"></script>
    <script src="<c:url value="/"/>resources/initMap.js"></script>
    <script type="text/javascript">
        var url = "<c:url value="/"/>";
    </script>
    <title>Testing websockets</title>
</head>
<body>
<div>
    <input type="submit" value="Start" onclick="start()" />
    <input type="submit" value="Start" onclick="start()" />
    <form action="<c:url value="/"/>parseNewRoad">
        <input type="submit" value="parse" >
        </form>
</div>
<div id="messages"></div>
<script type="text/javascript">
    var webSocket =
            new WebSocket('ws://localhost:8080/FindBus/websocket');

    webSocket.onerror = function(event) {
        onError(event)
    };

    webSocket.onopen = function(event) {
        onOpen(event)
    };

    webSocket.onmessage = function(event) {
        onMessage(event)
    };

    function onMessage(event) {
        var busPos = JSON.parse(event.data);
        addMarker(busPos.coordinate, "bus");
    }

    function onOpen(event) {
        document.getElementById('messages').innerHTML
                = 'Connection established';
    }

    function onError(event) {
        alert(event.data);
    }

    function start() {
        webSocket.send('hello');
        return false;
    }
</script>

<div id = "map_container">

</div>
</body>
</html>
