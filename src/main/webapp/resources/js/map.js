var mapContainer;

var color = {
    green : "#0FEB00",
    red: "red",
    yellow: "yellow",
    gray: "gray",
    black: "black",
    white: "white"
};

var colors = [color.green, color.yellow, color.red, color.gray];

var circles = [];

var kventColor = true;
var kvent = [];

var context;

var alertSound;

$(document).ready(function() {
    alertSound = $('#alert_sound');
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
                kvent.push(sensor.id);
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

            for (var i = 0; i < sensors.length; i++) {
                var sensor = sensors[i];
                if (context.isPointInPath(circles[i],x,y)) {
                    clickSensor(sensor.id, true);
                }
            }
        });

        setInterval(updateSensors, 15000);
        setTimeout(kventSensor, 500);
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

function updateSensors () {
    $.get("ajax/updateSensor", function (data) {
        if (data.update) {
            var update = false;
           for (var i = 0; i < sensors.length; i++) {
               var sensor = sensors[i];
               var dataSensor;
               for (var j = 0; j < data.sensors.length; j++) {
                   if (data.sensors[j] != null && data.sensors[j].idSensors == sensor.id) {
                       dataSensor = data.sensors[j];
                       break;
                   }
               }
               var redraw = sensor.type != dataSensor.type;
               sensor.value = dataSensor.value;
               sensor.type = dataSensor.type;
               sensor.text = dataSensor.text;
               if (redraw) {
                   update = true;
                   redrawSensor(circles[i], colors[sensor.type - 1]);
                   if (sensor.type == 2 || sensor.type == 3) {
                       kvent.push(sensor.id);
                   } else {
                       kvent.splice(kvent.indexOf(sensor.id), 1);
                   }
               }
           }

            if (update) {
                updateSensorTree();
            }

        }
    }).fail(function(jqXHR, textStatus, e ) {
        alert("Ошибка при получение данных с сервера: " + textStatus);
    });
}

function kventSensor () {
    if (kvent.length != 0) {
        if (alertSound[0].paused == true) {
            alertSound.trigger('play');
        }
    } else {
        if (alertSound[0].paused == false) {
            alertSound.trigger('pause');
        }
    }

    kventColor = !kventColor;
    for (var i=0;i<kvent.length;i++) {
        var id = kvent[i];
        var sensor;
        var circle;
        for (var j=0; j<sensors.length; j++) {
            if (sensors[j].id == id) {
                sensor = sensors[j];
                circle = circles[j];
            }
        }

        redrawSensor(circle, kventColor ? color.white : colors[sensor.type - 1]);
    }
    setTimeout(kventSensor, 1000);
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
        var index = kvent.indexOf(sensor.id);
        if (index != -1) {
            kvent.splice(index, 1);
            redrawSensor(getCircleById(sensor.id), colors[sensor.type - 1]);
        }

    }
}

