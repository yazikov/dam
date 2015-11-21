<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="text" required="true" type="java.lang.String" %>
<%@ attribute name="value" required="false" type="java.lang.String" %>
<%@ attribute name="items" required="true" type="java.util.List" %>

<div class="form-group" style="margin-bottom: 5px;">
    <label for="${name}">${text}</label>
    <select class="form-control" id="${name}" name="${name}" multiple="multiple">
        <option value=""></option>
        <c:forEach items="${items}" var="item">
            <option ${value.contains(item.id) ? "selected" : ''} value="${item.id}">${item.name}</option>
        </c:forEach>
    </select>
</div>