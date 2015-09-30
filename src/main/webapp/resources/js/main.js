/**
 * Created by nikolay on 06.09.15.
 */

var mapContainer;
var col1;
var col2;
var col3;

var color = {
  green : "#0FEB00",
    red: "red",
    yellow: "yellow"

};

var colors = [color.green, color.red, color.yellow];



$(document).ready(function() {

    mapContainer = $('.map_container');
    col1 = $('.col1');
    col2 = $('.col2');
    col3 = $('.col3');

    if (mapContainer != null) {
        setMapContainerSize(mapContainer);
        scrollToCenter(mapContainer);
    }

    setColumnSize();
    $(window).resize(function() {
        if (mapContainer != null) {
            setMapContainerSize();
        }
        setColumnSize();
    });

    var pressed = false;
    var start = undefined;
    var startX, startWidth;

    $('.col1_resize').mousedown(function(e) {
        start = $('.col1');
        pressed = true;
        startX = e.pageX;
        startWidth = start.width();
    });

    $('.col3_resize').mousedown(function(e) {
        start = $('.col3');
        pressed = true;
        startX = e.pageX;
        startWidth = start.width();
    });

    $(document).mousemove(function(e) {
        if(pressed) {
            var i = 1;
            var direction = 'left';
            if ($(start).hasClass("col3")) {
                i = -1;
                direction = 'right';
            }
            var width = startWidth + i * (e.pageX - startX);
            if (width < 50) {
                width = 50;
            } else if (width > 300) {
                width = 300;
            }
            $(start).width(width);
            $(start).find('.block').width(width);
            $('.col2').css('margin-' + direction, width);
        }
    });

    $(document).mouseup(function() {
        if(pressed) {
            pressed = false;
        }
    });

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

function scrollToCenter(elem) {
    var childrens = elem.children();
    if (childrens != null && childrens.length > 0) {
        var children = $(childrens[0]);
        var width = elem.width();
        var inWidth = children.width();
        if (width < inWidth) {
            elem.scrollLeft((inWidth - width) / 2);
        }
        var height = elem.height();
        var inHeight = children.height();
        if (height < inHeight) {
            elem.scrollTop((inHeight - height) / 2);
        }

    }
}

function setMapContainerSize() {
    var viewportHeight = $(window).height();
    mapContainer.height(viewportHeight);
}

function setColumnSize() {
    var height = col2.height() + 20;
    if (height > 600) {
        col1.height(height);
        col3.height(height);
        col1.css("min-height", height + "px");
        col3.css("min-height", height + "px");
    } else {
        col1.height(600);
        col3.height(600);
        col1.css("min-height", "600px");
        col3.css("min-height", "600px");
    }
}
