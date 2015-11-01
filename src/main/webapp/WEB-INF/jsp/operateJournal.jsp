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
      <div class="block">
        <div class="panel panel-default">
          <div class="panel-heading">Условные обозначения</div>
          <div class="panel-body">
            <div id="sensor-info" class="alert">
              <table class="table table-noborder">
                <tr>
                  <td>
                    <div class="sensor_type_3 legend_block"></div>
                  </td>
                  <td>
                    Аварийные сигналы
                  </td>
                </tr>
                <tr>
                  <td>
                    <div class="sensor_type_2 legend_block"></div>
                  </td>
                  <td>
                    Предупреждающие сигналы
                  </td>
                </tr>
                <tr>
                  <td>
                    <div class="sensor_type_1 legend_block"></div>
                  </td>
                  <td>
                    Сигналы состояния
                  </td>
                </tr>
              </table>
            </div>
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
