/**
 * Created by nikolay on 03.10.15.
 */

$(document).ready(function() {
    initTree();
});

function initTree() {
    $('#tree').on('changed.jstree', function (e, data) {
        if (data.selected.length > 0) {
            var id = data.selected[0];
            id = id.replace("tree-sensor-", "");
            clickSensor(id, false);
        }

    }).jstree();
}