<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="text" required="true" type="java.lang.String" %>
<%@ attribute name="value" required="false" type="java.lang.String" %>

<div class="form-group" style="margin-bottom: 5px;">
    <label for="${name}">${text}</label>
    <input type="text" class="form-control" id="${name}" name="${name}" value="${value}">
</div>