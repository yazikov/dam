<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/js/map.js" var="mapJs" />
<spring:url value="/resources/audio/alert.mp3" var="alertMp3" />

<script>
    var sensors = [
            <c:forEach items="${sensors}" var="sensor" varStatus="i">
    <c:out value="${sensor.toJSON()}" escapeXml="false" />
    <c:if test="${!i.last}">,</c:if>
    </c:forEach>
    ];
</script>
<canvas id="map" width="1024" height="800"></canvas>
<audio id="alert_sound" src="${alertMp3}">

</audio>

<script src="${mapJs}"></script>
