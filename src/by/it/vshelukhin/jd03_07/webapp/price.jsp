<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<legend>Наши цены</legend>
<div class="row" >
    <div class="col-md-5">Название</div>
    <div class="col-md-2">Цена</div>
</div>
<br>
<c:forEach items="${wrk}" var="wr">
    <div class="row">
        <div class="col-md-5">${wr.name} </div>
        <div class="col-md-2">${wr.price} рублей </div>
    </div>
</c:forEach>

<p>${message}</p>

<%@ include file="include/end-html.jsp" %>