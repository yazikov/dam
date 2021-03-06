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

var insisionObjs = [];

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
    var h = $('.col2').width() - 20;
    var k = (h / map.width());
    map.width(map.width()*k);
    //map.height(map.height()*k);
    if (map != null) {
        context = map[0].getContext("2d");

        for (var i = 0; i < insisions.length; i++) {
            var insision = insisions[i];
            drawInsision(insision, 1, 1);
        }

        for (var i=0; i < sensors.length; i++) {
            var sensor = sensors[i];
            drawSensor(sensor, colors[sensor.type - 1], 1);
            if ((sensor.type == 2 || sensor.type == 3) && !sensor.isKvint) {
                kvent.push(sensor.id);
            }
        }

        var container = $('.map_container')[0];
        var headerHeight = $('header').height();

        map.mousemove(function(e) {
            var x = (e.pageX - this.offsetLeft + container.scrollLeft) / k;
            var y = (e.pageY - this.offsetTop + container.scrollTop - headerHeight) / k;

            //var x = e.pageX + container.scrollLeft;
            //var y = e.pageY + container.scrollTop - headerHeight;

            var isCursor = false;
            for (var i = 0; i < circles.length; i++) {
                if (context.isPointInPath(circles[i],x,y)) {
                    isCursor = true;
                }
            }
            for (var i = 0; i < insisionObjs.length; i++) {
                if (context.isPointInPath(insisionObjs[i],x,y)) {
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

            var x = (e.pageX - this.offsetLeft + container.scrollLeft) / k;
            var y = (e.pageY - this.offsetTop + container.scrollTop - headerHeight) / k;

            //var x = e.pageX + container.scrollLeft;
            //var y = e.pageY + container.scrollTop - headerHeight;

            //alert("x: " + x + " y: " + y);
            //alert("x: " + e.pageX + "y: " + e.pageY);
            var isSensor = false;
            for (var i = 0; i < sensors.length; i++) {
                var sensor = sensors[i];
                if (context.isPointInPath(circles[i],x,y)) {
                    isSensor = true;
                    clickSensor(sensor.id, true);
                }
            }
            if (!isSensor) {
                for (var i = 0; i < insisions.length; i++) {
                    var insision = insisions[i];
                    if (context.isPointInPath(insisionObjs[i],x,y)) {
                        openCut(insision);
                    }
                }
            }
        });

        updateSensorLog();

        setInterval(updateSensors, 15000);
        setTimeout(kventSensor, 500);
    }
}

var drawSensor = function (sensor, color, k) {
    var circle = new Path2D();
    circles.push(circle);
    context.fontWeight = "normal";
    if (cutId == 0) {
        circle.arc(sensor.x * k, sensor.y * k, 5 * k, 0, 2 * Math.PI, false);
    } else {
        circle.moveTo(sensor.x * k, sensor.y * k);
        circle.lineTo(sensor.x * k, (sensor.y + 10) * k);
        circle.lineTo((sensor.x + 6) * k, (sensor.y + 10) * k);
        circle.lineTo((sensor.x + 6) * k, sensor.y * k);
        circle.lineTo(sensor.x * k, sensor.y * k);
    }
    context.fillStyle = color;
    context.fill(circle);
    context.lineWidth = 1;
    context.strokeStyle = "black";
    context.stroke(circle);
    context.fillStyle = "black";
    context.font = "bold 14px Arial";
    if (cutId == 0) {
        context.fillText(sensor.name, (sensor.x + 7) * k, (sensor.y + 5) * k);
    } else {
        context.fillText(sensor.name, (sensor.x + 8) * k, (sensor.y + 10) * k);
    }
    return circle;
};

var drawInsision = function (insision, k, h) {
    var insisionObj = new Path2D();
    insisionObjs.push(insisionObj);
    context.fontWeight = "normal";
    if (insision.x2 - insision.x1 > 100) {
        insisionObj.moveTo((insision.x1 - 1) * k, (insision.y1 - 1) * h);
        insisionObj.lineTo((insision.x1 + 3) * k, (insision.y1 + 3) * h);
        insisionObj.lineTo((insision.x2 + 3) * k, (insision.y2 + 3) * h);
        insisionObj.lineTo((insision.x2 - 1) * k, (insision.y2 - 1) * h);
        insisionObj.lineTo((insision.x1 - 1) * k, (insision.y1 - 1) * h);
    } else {
        insisionObj.moveTo((insision.x1 - 1) * k, (insision.y1 - 1) * h);
        insisionObj.lineTo((insision.x1 + 2) * k, (insision.y1 + 2) * h);
        insisionObj.lineTo((insision.x2 + 2) * k, (insision.y2 + 2) * h);
        insisionObj.lineTo((insision.x2 - 1) * k, (insision.y2 - 1) * h);
        insisionObj.lineTo((insision.x1 - 1) * k, (insision.y1 - 1) * h);
    }

    context.fillStyle = "dodgerblue";
    context.fill(insisionObj);
    return insisionObj;
};

function redrawSensor(circle, color) {
    context.fillStyle = color;
    context.fill(circle);
    context.strokeStyle = "black";
    context.stroke(circle);
}

function updateSensors () {
    $.get("/ajax/updateSensor/" + cutId, function (data) {
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
                   if ((sensor.type == 2 || sensor.type == 3) && !sensor.isKvint) {
                       kvent.push(sensor.id);
                   } else {
                       kvent.splice(kvent.indexOf(sensor.id), 1);
                   }
               }
           }

            updateSensorLog();

            if (update) {
                updateSensorTree();
            }

        }
    }).fail(function(jqXHR, textStatus, e ) {
        alert("Ошибка при получение данных с сервера: " + textStatus);
    });
}

function updateSensorLog() {
    var sensorLog = $('#sensor-logging');
    if (sensorLog.length > 0) {
        sensorLog.empty();
        for (var i=0; i< sensors.length; i++) {
            var sensor = sensors[i];
            if (sensor.type == 2 || sensor.type == 3) {
                var sensorClass = sensor.type == 2 ? 'alert-warning' : 'alert-danger';
                var sensorAlert = $('<div class="alert ' + sensorClass + '">' + sensor.name + ": " + sensor.text + '</div>');
                sensorAlert.appendTo(sensorLog);
            }
        }
    }
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

function openCut(insision) {
    openInNewTab("/cut/" + insision.id);
}

function openInNewTab(url) {
    var win = window.open(url, '_blank');
    win.focus();
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
            info.html(sensor.name + ": " + sensor.text + "<br/>" + "Значение: " + sensor.value + "<br/>" + "Уставка k1: " + sensor.setPre);
        }
        var index = kvent.indexOf(sensor.id);
        if (index != -1) {
            kvent.splice(index, 1);
            redrawSensor(getCircleById(sensor.id), colors[sensor.type - 1]);
            kvintSensorInDB(sensor.id);
        }

    }
}

function kvintSensorInDB (sensorId) {
    $.post("/ajax/kvintSensor", {id : sensorId}, function (data) {

    }).fail(function(jqXHR, textStatus, e ) {
        alert("Ошибка квентирования датчика: " + textStatus);
    });
}

