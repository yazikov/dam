<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/js/tree.js" var="treeJs" />

<spring:url value="/resources/js/jstree.js" var="jsTreeJs" />
<spring:url value="/resources/css/tree/default/style.min.css" var="jsTreeCss" />
<link href="${jsTreeCss}" rel="stylesheet" />
<script src="${jsTreeJs}"></script>

<div id="tree"></div>

<script src="${treeJs}"></script>