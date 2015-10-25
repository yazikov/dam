<%@tag pageEncoding="UTF-8" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%
    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");
    SimpleDateFormat hf = new SimpleDateFormat("hh:mm:ss");
    request.setAttribute("df", df);
    request.setAttribute("hf", hf);
%>

<table class="table table-bordered">
    <thead>
        <tr>
            <th rowspan="3">Кв</th>
            <th rowspan="3">Дата</th>
            <th rowspan="3">Время</th>
            <th rowspan="3" width="120">Участок объекта автоматизации</th>
            <th rowspan="3">Тип объекта автоматизации</th>
            <th colspan="3">Состояние элементов сооружений</th>
            <th rowspan="3">Дата квинтирования</th>
            <th rowspan="3">Время квинтирования</th>
        </tr>
        <tr>
            <th colspan="2">Сигнал</th>
            <th rowspan="2">Статус</th>
        </tr>
        <tr>
            <th>K1/const</th>
            <th>K2/const</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${sensors}" var="sensor">
            <tr>
                <td><c:out value="${sensor.type}" /></td>
                <td><c:out value="${df.format(sensor.signSys.dateSign)}" /></td>
                <td><c:out value="${hf.format(sensor.signSys.timeSign)}" /></td>
                <td><c:out value="${sensor.objMonitor}" /></td>
                <td><c:out value="${sensor.name}" /></td>
                <td><c:out value="${sensor.text}" /></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
