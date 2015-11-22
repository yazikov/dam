<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<spring:url value="/enter/graphic" var="graphicAction" />
<spring:url value="/enter/table" var="tableAction" />



<form action="${graphicAction}" class="form-horizontal" target="_blank">
    <div class="form-group">
        <t:calendar name="startDate" text="Период с" value="${startDate}" inline="true"/>
        <t:calendar name="endDate" text="Период по" value="${endDate}" inline="true"/>
        <div class="col-sm-2">
            <button id="btnGraphic" type="submit" class="btn btn-primary">Построить график</button>
        </div>
        <div class="col-sm-2">
            <button id="btnTable" type="submit" class="btn btn-default">Вывести таблицу</button>
        </div>

    </div>

    <c:forEach items="${sensors}" var="entry" varStatus="i" >
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading${i.index}">
                    <a role="button" data-toggle="collapse" href="#collapse${i.index}" aria-expanded="true" aria-controls="collapse${i.index}">
                            ${entry.key}
                    </a>
                </div>
                <div id="collapse${i.index}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${i.index}">
                    <div class="panel-body">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Номер датчика</th>
                                    <th>Пьезометр</th>
                                    <th>Измеряемый параметр</th>
                                    <th>Выбрано</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${entry.value}" var="sensor">
                                <tr>
                                    <td><c:out value="${sensor.number}" /></td>
                                    <td><c:out value="${sensor.name}" /></td>
                                    <td><c:out value="${sensor.measParamTypeSig.discription}" /></td>
                                    <td><input name="sensor_${sensor.idSensors}" type="checkbox"></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</form>

<script>
    var graphic = "${graphicAction}";
    var table = "${tableAction}";

    $(document).ready(function() {
        $('#btnGraphic').click(function() {
            $('form').attr('action', graphic);
        });
        $('#btnTable').click(function() {
            $('form').attr('action', table);
        });
    });
</script>