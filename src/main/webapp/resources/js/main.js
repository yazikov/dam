/**
 * Created by nikolay on 06.09.15.
 */
var mapContainer;
var col1;
var col2;
var col3;

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

    $('select').select2();

    $(".datepicker").datepicker({
        firstDay: 1,
        dateFormat: "dd.mm.yy",
        dayNames: [ "Воскресение", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота" ],
        dayNamesMin: [ "Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб" ],
        dayNamesShort: [ "Воск", "Пон", "Втор", "Сред", "Четв", "Пят", "Суб" ],
        monthNames: [ "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" ],
        monthNamesShort: [ "Янв", "Фев", "Март", "Апр", "Май", "Июнь", "Июль", "Авг", "Сен", "Окт", "Нояб", "Дек" ]
    });

});

function getSensorById(id) {
    for (var i = 0; i < sensors.length; i++) {
        var sensor = sensors[i];
        if (sensor.id == id) {
            return sensor;
        }
    }
}

function getCircleById(id) {
    for (var i = 0; i < sensors.length; i++) {
        var sensor = sensors[i];
        if (sensor.id == id) {
            return circles[i];
        }
    }
}

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
    var canvasHeight = $('')
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
