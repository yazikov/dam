<%--
  Created by IntelliJ IDEA.
  User: nikolay
  Date: 06.09.15
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page>
  <jsp:body>
    <div class="col1">
      <div class="col1_resize"></div>
      <div class="block info_block"></div>
      <div class="block data_block"></div>
    </div>
    <div class="col3">
      <div class="col3_resize"></div>
      <div class="block data_block"></div>
      <div class="block info_block"></div>
    </div>
    <div class="col2">
      <div class="map_container">
          <img src="${pageContext.request.contextPath}/resources/images/map.jpg" width="1024" usemap="#sensors"/>
          <map id="sensors">
            <c:forEach var="sensor" items="${sensors}">
              <area class="sensor_norm" shape="circle" coords='${sensor.xValue.intValue()},${sensor.yValue.intValue()},3' onclick="alert('test')"/>
            </c:forEach>
          </map>
      </div>
    </div>
  </jsp:body>
</t:page>