<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="subTitle" fragment="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="notShow" required="false" type="java.lang.Boolean" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>АСИУ</title>

    <spring:url value="/resources/css/main.css" var="mainCss" />
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/js/jquery-1.11.3.min.js" var="jqueryJs" />
    <spring:url value="/resources/js/jquery-ui/jquery-ui.min.js" var="jqueryUIJs" />
    <spring:url value="/resources/css/jquery-ui/jquery-ui.min.css" var="jqueryUICss" />
    <spring:url value="/resources/js/main.js" var="mainJs" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

    <spring:url value="/resources/js/select2/select2.css" var="select2Css" />
    <spring:url value="/resources/js/select2/select2-bootstrap.css" var="select2BootstrapCss" />

    <spring:url value="/resources/js/select2/select2.min.js" var="select2Js" />

    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${jqueryUICss}" rel="stylesheet" />
    <link href="${select2Css}" rel="stylesheet" />
    <link href="${select2BootstrapCss}" rel="stylesheet" />
    <link href="${mainCss}" rel="stylesheet" />

    <script src="${jqueryJs}"></script>
    <script src="${jqueryUIJs}"></script>
    <script src="${select2Js}"></script>
    <script src="${bootstrapJs}"></script>

    <spring:url value="/" var="baseURL"/>

    <script>
        var baseURL = '${baseURL}';
    </script>

</head>

<body>
<div class="wrapper">
    <c:if test="${!notShow}">
    <header>
        <div class="header_logo" onclick="location.href = baseURL"></div>
        <div class="header_content">
            <div class="btn-group" role="group" aria-label="...">
                <div class="btn-group">
                    <button class="btn btn-default dropdown-toggle menu_btn" type="button" id="dropdownMenu0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        Состояние КИА в разрезах
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu0">
                        <li><a href="<spring:url value="/cut/1" />" target="_blank">Разрез (пп) А-А</a></li>
                        <li><a href="<spring:url value="/cut/2" />" target="_blank">Разрез (пп) Б-Б</a></li>
                        <li><a href="<spring:url value="/cut/3" />" target="_blank">Разрез (пп) В-В</a></li>
                        <li><a href="<spring:url value="/cut/4" />" target="_blank">Разрез (пп) Г-Г</a></li>
                        <li><a href="<spring:url value="/cut/5" />" target="_blank">Разрез (пп) Д-Д</a></li>
                        <li><a href="<spring:url value="/cut/6" />" target="_blank">Разрез (пп) Е-Е</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <a class="btn btn-default menu_btn" href="<spring:url value="/enter/operateJournal" />" target="_blank">
                        Оперативный диспетчерский журнал
                    </a>
                </div>
                <div class="btn-group">
                    <a class="btn btn-default menu_btn" href="<spring:url value="/enter/trends" />" target="_blank">
                        Тренды
                    </a>
                </div>

                <%--<div class="btn-group">--%>
                    <%--<button class="btn btn-default dropdown-toggle menu_btn" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">--%>
                        <%--Ввод данных--%>
                        <%--<span class="caret"></span>--%>
                    <%--</button>--%>
                    <%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">--%>
                        <%--<li><a href="#">Данные натурных наблюдений</a></li>--%>
                        <%--<li><a href="#">Контрольный лист замеров глубин</a></li>--%>
                        <%--<li><a href="#">Журнал технического надзора</a></li>--%>
                        <%--<li><a href="<spring:url value="/enter/operateJournal" />" target="_blank">Оперативный диспетчерский журнал</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="btn-group">--%>
                    <%--<button class="btn btn-default dropdown-toggle menu_btn" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">--%>
                        <%--КИА--%>
                        <%--<span class="caret"></span>--%>
                    <%--</button>--%>
                    <%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">--%>
                        <%--<li><a href="#">Работа с датчиками КИА</a></li>--%>
                        <%--<li><a href="#">КИА на чертежах</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="btn-group">--%>
                    <%--<button class="btn btn-default dropdown-toggle menu_btn" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">--%>
                        <%--Просмотр и анализ--%>
                        <%--<span class="caret"></span>--%>
                    <%--</button>--%>
                    <%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu3">--%>
                        <%--<li><a href="#">Журнал событий</a></li>--%>
                        <%--<li><a href="#">Архив журнала событий</a></li>--%>
                        <%--<li><a href="#">Данные натурных наблюдений</a></li>--%>
                        <%--<li><a href="#">Построение упругой линии шпунта лицевой стенки</a></li>--%>
                        <%--<li><a href="#">Оценка технического состояния сооружений</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="btn-group">--%>
                    <%--<button class="btn btn-default dropdown-toggle menu_btn" type="button" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">--%>
                        <%--Документы--%>
                        <%--<span class="caret"></span>--%>
                    <%--</button>--%>
                    <%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu5">--%>
                        <%--<li><a href="#">Отчеты наблюдений за состоянием сооружений</a></li>--%>
                        <%--<li><a href="#">Журнал технического надзора</a></li>--%>
                        <%--<li><a href="#">Оперативный диспетчерский журнал</a></li>--%>
                        <%--<li><a href="#">Ремонты</a></li>--%>
                        <%--<li><a href="#">Показатели состояния</a></li>--%>
                        <%--<li><a href="#">Программа мониторинга сооружений</a></li>--%>
                        <%--<li><a href="#">Нормативно техническая документация</a></li>--%>
                        <%--<li><a href="#">Фотоматериалы</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="btn-group">--%>
                    <%--<button class="btn btn-default dropdown-toggle menu_btn" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">--%>
                        <%--Инструменты--%>
                        <%--<span class="caret"></span>--%>
                    <%--</button>--%>
                    <%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu4">--%>
                        <%--<li><a href="#">Калькулятор инженерный</a></li>--%>
                        <%--<li><a href="#">Калькулятор формул</a></li>--%>
                        <%--<li><a href="#">Записная книжка</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<button class="btn btn-default menu_btn" type="button">--%>
                    <%--Помощь--%>
                <%--</button>--%>
            </div>
        </div>
    </header>
    </c:if>

    <div class="layout">
        <jsp:doBody/>
    </div>
    <div style="clear: both" ></div>

</div>

<c:if test="${!notShow}">
    <footer>
        <div>Inversion sensor</div>
    </footer>
</c:if>


<script src="${mainJs}"></script>

</body>
</html>