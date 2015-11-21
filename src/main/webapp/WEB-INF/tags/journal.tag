<%@tag pageEncoding="UTF-8" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="operate" required="false" type="java.lang.Boolean" %>


<%
    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");
    SimpleDateFormat hf = new SimpleDateFormat("hh:mm:ss");
    request.setAttribute("df", df);
    request.setAttribute("hf", hf);
%>

<c:choose>
    <c:when test="${operate}">
        <div class="row" style="margin-bottom: 5px;">
            <div class="col-md-2">
                <a class="btn btn-default" href="<spring:url value="/enter/history" />" role="button">
                    <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span> &nbsp;&nbsp;Архив событий
                </a>
            </div>
            <div class="col-md-10"></div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row" style="margin-bottom: 5px;">
            <div class="col-md-3">
                <a class="btn btn-default" href="<spring:url value="/enter/operateJournal" />" role="button">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> &nbsp;&nbsp;Оперативный журнал
                </a>
            </div>
            <div class="col-md-9">

            </div>
        </div>
    </c:otherwise>
</c:choose>

<div>
<table class="table table-bordered">
    <thead>
        <tr>
            <th rowspan="2">Дата</th>
            <th rowspan="2">Время</th>
            <th rowspan="2" width="200">Участок объекта автоматизации</th>
            <th rowspan="2">Тип объекта автоматизации</th>
            <th colspan="2">Состояние элементов сооружений</th>
            <th rowspan="2">Дата квинтирования</th>
            <th rowspan="2">Время квинтирования</th>
        </tr>
        <tr>
            <th>Сигнал</th>
            <th>Статус</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${page.content}" var="sensor">
            <tr class="sensor_type_${sensor.type}">
                <td><c:out value="${df.format(sensor.signSys.dateSign)}" /></td>
                <td><c:out value="${hf.format(sensor.signSys.timeSign)}" /></td>
                <td><c:out value="${sensor.objMonitor}" /></td>
                <td><c:out value="${sensor.name}" /></td>
                <td><c:out value="${sensor.text}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${(sensor.type==2 || sensor.type==3) && sensor.isKvint()}">
                            Квит.
                        </c:when>
                        <c:when test="${(sensor.type==2 || sensor.type==3) && !sensor.isKvint()}">
                            Не квит.
                        </c:when>
                        <c:when test="${sensor.type==1}">
                            Норма
                        </c:when>
                        <c:when test="${sensor.type==4}">
                            Отключен
                        </c:when>
                    </c:choose>
                </td>
                <td><c:out value="${sensor.signSys.dateKvint != null ? df.format(sensor.signSys.dateKvint) : ''}" /></td>
                <td><c:out value="${sensor.signSys.timeKvint != null ? hf.format(sensor.signSys.timeKvint) : ''}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%--@elvariable id="page" type="ru.rushydro.vniig.model.Page"--%>
<t:paging pageNumber="${page.page}" count="${page.count}" size="${page.size}" pageCount="${page.pageCount}" />
</div>