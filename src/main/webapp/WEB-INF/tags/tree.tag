<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/js/tree.js" var="treeJs" />

<spring:url value="/resources/js/jstree.js" var="jsTreeJs" />
<spring:url value="/resources/css/tree/default/style.min.css" var="jsTreeCss" />
<spring:url value="/resources/images/type-" var="typeImg" />
<link href="${jsTreeCss}" rel="stylesheet" />
<script src="${jsTreeJs}"></script>

<div id="tree">
    <ul>
        <c:forEach items="${roots}" var="root">
            <li>
                <c:out value="${root}" />
                <ul>
                    <c:forEach items="${sensors}" var="sensor">
                        <c:if test="${sensor.objMonitor == root}">
                            <li id="tree-sensor-${sensor.idSensors}" data-jstree='{"icon":"${typeImg}${sensor.type}.png"}'><c:out value="${sensor.name}" /></li>
                        </c:if>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
    </ul>
</div>

<script src="${treeJs}"></script>