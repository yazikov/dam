var mapContainer;

var color = {
    green : "#0FEB00",
    red: "red",
    yellow: "yellow"

};

var colors = [color.green, color.red, color.yellow];

$(document).ready(function() {
    drawMap();
});

function drawMap() {
    var map = $('#map');
    if (map != null) {
        var context = map[0].getContext("2d");

        for (var i=0; i < sensors.length; i++) {
            drawSensor(context, sensors[i], colors[i%3]);
        }

        var container = $('.map_container')[0];
        var headerHeight = $('header').height();

        map.click(function (e) {

            var x = e.pageX - this.offsetLeft + container.scrollLeft;
            var y = e.pageY - this.offsetTop + container.scrollTop - headerHeight;

            alert("x: " + x+ " y: " + y);

            for (var i = 0; i < sensors.length; i++) {
                var sensor = sensors[i];
                if (x < (sensor.x + 3) && x > (sensor.x - 3) && y < (sensor.y + 3) && y > (sensor.y - 3)) {
                    alert ('clicked number: ' + sensor.id);
                    clickSensor(sensor.id, true);
                }
            }
        });
    }
}

var drawSensor = function (context, sensor, color) {
    context.beginPath();
    context.fontWeight = "normal";
    context.arc(sensor.x, sensor.y, 5, 0, 2 * Math.PI, false);
    context.fillStyle = color;
    context.fill();
    context.lineWidth = 1;
    context.strokeStyle = "black";
    context.stroke();
    context.fillStyle = "black";
    context.font = "bold 14px Arial";
    context.fillText(sensor.name, sensor.x + 7, sensor.y + 5);
};

function clickSensor (id, isMap) {
    var sensor = getSensorById(id);
    var info = $('#sensor-info');
    var tree = $('#tree');
    if (isMap) {
        tree.jstree('deselect_all');
        tree.jstree('select_node', 'tree-sensor-' + sensor.id);
        info.html(sensor.name + ": ");
    }
}

