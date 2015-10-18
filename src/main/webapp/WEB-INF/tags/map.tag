<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="cutId" required="false" type="java.lang.Integer" %>
<%@ attribute name="height" required="false" type="java.lang.Integer" %>

<spring:url value="/resources/js/map.js" var="mapJs" />
<spring:url value="/resources/audio/alert.mp3" var="alertMp3" />

<script>
    var cutId = <c:out value="${cutId}" />;

    var sensors = [
            <c:forEach items="${sensors}" var="sensor" varStatus="i">
    <c:out value="${sensor.toJSON()}" escapeXml="false" />
    <c:if test="${!i.last}">,</c:if>
    </c:forEach>
    ];
</script>

<canvas id="map" width="1024" height="${height}" class="map_${cutId}"></canvas>
<audio id="alert_sound" src="${alertMp3}">

</audio>

<script src="${mapJs}"></script>
