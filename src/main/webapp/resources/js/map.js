var mapContainer;

var color = {
    green : "#0FEB00",
    red: "red",
    yellow: "yellow",
    gray: "gray",
    black: "black"
};

var colors = [color.green, color.yellow, color.red, color.gray];

var circles = [];

var context;

$(document).ready(function() {
    drawMap();
});

function drawMap() {
    var map = $('#map');
    if (map != null) {
        context = map[0].getContext("2d");

        for (var i=0; i < sensors.length; i++) {
            var sensor = sensors[i];
            var circle = drawSensor(sensor, colors[sensor.type - 1]);
            if (sensor.type == 2 || sensor.type == 3) {
                //setInterval(alertSensor(circle, colors[sensor.type - 1]), 51000);
            }
        }

        var container = $('.map_container')[0];
        var headerHeight = $('header').height();

        map.mousemove(function(e) {
            var x = e.pageX - this.offsetLeft + container.scrollLeft;
            var y = e.pageY - this.offsetTop + container.scrollTop - headerHeight;
            var isCursor = false;
            for (var i = 0; i < circles.length; i++) {
                if (context.isPointInPath(circles[i],x,y)) {
                    isCursor = true;
                }
            }
            if (isCursor) {
                map.css("cursor", "pointer");
            } else {
                map.css("cursor", "auto");
            }

        });

        map.click(function (e) {

            var x = e.pageX - this.offsetLeft + container.scrollLeft;
            var y = e.pageY - this.offsetTop + container.scrollTop - headerHeight;

            //alert("x: " + x+ " y: " + y);

            for (var i = 0; i < sensors.length; i++) {
                var sensor = sensors[i];
                if (context.isPointInPath(circles[i],x,y)) {
                    //alert ('clicked number: ' + sensor.id);
                    clickSensor(sensor.id, true);
                }
            }
        });
    }
}

var drawSensor = function (sensor, color) {
    var circle = new Path2D();
    circles.push(circle);
    context.fontWeight = "normal";
    circle.arc(sensor.x, sensor.y, 5, 0, 2 * Math.PI, false);
    context.fillStyle = color;
    context.fill(circle);
    context.lineWidth = 1;
    context.strokeStyle = "black";
    context.stroke(circle);
    context.fillStyle = "black";
    context.font = "bold 14px Arial";
    context.fillText(sensor.name, sensor.x + 7, sensor.y + 5);
    return circle;
};

function redrawSensor(circle, color) {
    context.fillStyle = color;
    context.fill(circle);
    context.strokeStyle = "black";
    context.stroke(circle);
}

function alertSensor(circle, color) {
    redrawSensor(circle, colors.black);
    setTimeout(redrawSensor(circle, color), 2500);
}

function clickSensor (id, isMap) {
    var sensor = getSensorById(id);
    if (sensor.type != 4) {
        var info = $('#sensor-info');
        var tree = $('#tree');
        if (isMap) {
            tree.jstree('deselect_all');
            tree.jstree('close_all');
            tree.jstree('select_node', 'tree-sensor-' + sensor.id);
        } else {
            switch (sensor.type) {
                case 1: info.removeClass("alert-danger"); info.removeClass("alert-warning"); info.addClass("alert-success"); break;
                case 2: info.removeClass("alert-success"); info.removeClass("alert-danger"); info.addClass("alert-warning"); break;
                case 3: info.removeClass("alert-success"); info.removeClass("alert-warning"); info.addClass("alert-danger"); break;
            }
            info.html(sensor.name + ": " + sensor.text);
        }

    }
}

