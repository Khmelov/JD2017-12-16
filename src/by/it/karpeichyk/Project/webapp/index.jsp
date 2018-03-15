<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<!-- Основное содержимое -->

<div class="page-header">
    <h1>Все объявления</h1>
    <p class="lead">Пример макета для вывода данных в виде таблицы</p>
</div>

<div class="row">
    <div class="col-md-1">Грузоподъёмность`</div>
    <div class="col-md-3">Объём </div>
    <div class="col-md-4">Информация</div>
    <div class="col-md-1">Тариф</div>
</div>

<c:forEach items="${ads}" var="ad">
    <br>
    <div class="row">
        <div class="col-md-1">${ad.carrying} </div>
        <div class="col-md-3">${ad.volume} </div>
        <div class="col-md-4">${ad.description} </div>
        <div class="col-md-1">${ad.tariff} </div>

    </div>
</c:forEach>

<br><br>


<p>INDEX: ${message}</p>

<%@ include file="include/end-html.jsp" %>