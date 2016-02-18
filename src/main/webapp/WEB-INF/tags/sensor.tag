<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<spring:url value="/virtual/sensors/save" var="editUrl" />



<form role="form" action="${editUrl}" method="post" class="form-horizontal validator-form" data-toggle="validator">
    <input type="hidden" value="${sensor.idSensors}"/>
    <t:combobox items="${types}" name="objMonitor" text="Измерительный створ" value="${sensor.objMonitor}" multiple="false" />
    <t:text name="name" text="Номер датчика" value="${sensor.number}" />
    <t:text name="number" text="Пьезометр" value="${sensor.name}" />
    <t:text name="parametr" text="Измеряемый параметр" value="${sensor.measParamTypeSig.discription}" />
    <c:choose>
        <c:when test="${sensor.idSensors == null}">
            <t:number name="value" text="Значение датчика" />
            <t:calendar name="date" text="Дата измерения" />
            <t:time name="time" text="Дата измерения" />
        </c:when>
    </c:choose>
    <div class="form-group"  style="margin-bottom: 5px;">
        <button type="submit" class="btn btn-default">Добавить</button>
    </div>
</form>