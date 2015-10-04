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

        for (var i=0; i < circles.length; i++) {
            drawCircle(context, circles[i], colors[i%3]);
        }

        var container = $('.map_container')[0];
        var headerHeight = $('header').height();

        map.click(function (e) {

            var x = e.pageX - this.offsetLeft + container.scrollLeft;
            var y = e.pageY - this.offsetTop + container.scrollTop - headerHeight;

            alert("x: " + x+ " y: " + y);

            for (var i = 0; i < circles.length; i++) {
                var circle = circles[i];
                if (x < (circle.x + 3) && x > (circle.x - 3) && y < (circle.y + 3) && y > (circle.y - 3)) {
                    alert ('clicked number: ' + circle.id);
                }
            }
        });
    }
}

var drawCircle = function (context, circle, color) {
    context.beginPath();
    context.fontWeight = "normal";
    context.arc(circle.x, circle.y, 5, 0, 2 * Math.PI, false);
    context.fillStyle = color;
    context.fill();
    context.lineWidth = 1;
    context.strokeStyle = "black";
    context.stroke();
    context.fillStyle = "black";
    context.font = "bold 14px Arial";
    context.fillText(circle.name, circle.x + 7, circle.y + 5);
};