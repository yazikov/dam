<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<spring:url value="/virtual/sensors/add" var="addUrl" />



<div class="row" style="margin-bottom: 5px; width: 98%;">
    <div class="col-sm-10"></div>
    <div class="col-sm-2">
        <a id="btnGraphic" class="btn btn-default" href="${addUrl}">Добавить сенсор</a>
    </div>
</div>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>Измерительный створ</th>
        <th>Номер датчика</th>
        <th>Пьезометр</th>
        <th>Измеряемый параметр</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${sensors}" var="sensor" varStatus="i" >
        <tr>
            <td><c:out value="${sensor.objMonitor}" /></td>
            <td><c:out value="${sensor.number}" /></td>
            <td><c:out value="${sensor.name}" /></td>
            <td><c:out value="${sensor.measParamTypeSig.discription}" /></td>
            <td>
                <div data-id="${sensor.idSensors}" class="btn btn-default btn-on">
                    <span class="glyphicon glyphicon-off" aria-hidden="true"></span> <span class="text">Включить</span>
                </div>
                <div data-id="${sensor.idSensors}" class="btn btn-default btn-off">
                    <span class="glyphicon glyphicon-off" aria-hidden="true"></span> <span class="text">Выключить</span>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>