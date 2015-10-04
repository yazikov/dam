<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/js/map.js" var="mapJs" />

<script>
    var circles = [
            <c:forEach items="${sensors}" var="sensor" varStatus="i">
    <c:out value="${sensor.toJSON()}" escapeXml="false" />
    <c:if test="${!i.last}">,</c:if>
    </c:forEach>
    ];
</script>
<canvas id="map" width="1024" height="800"></canvas>


<script src="${mapJs}"></script>
