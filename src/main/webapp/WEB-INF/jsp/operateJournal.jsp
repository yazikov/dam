<%--
  Created by IntelliJ IDEA.
  User: nikolay
  Date: 18.10.15
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page>
  <jsp:body>
    <div class="col1">
      <div class="col1_resize"></div>
      <div class="block info_block">
        <div class="panel panel-default">
          <div class="panel-heading">Информация о датчике</div>
          <div class="panel-body">
            <div id="sensor-info" class="alert"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="col2 no_right">
      <div class="journal_container">
        <t:journal />
      </div>
    </div>
  </jsp:body>
</t:page>
