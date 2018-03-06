<%@page language="java" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
    <h3>Все все автомобили каталога</h3>
</div>

<div class="row">
    <div class="col-md-3">Бренд</div>
    <div class="col-md-3">Марка</div>
    <div class="col-md-2">Класс</div>
    <div class="col-md-2">Цена $</div>
    <div class="col-md-2">Год выпуска</div>

</div>
<div class="col-md-12"><hr align="center" width="1000" size="2" color="#ff0000" /></div>

<c:forEach items="${cars}" var="car">
    <br>
    <div class="row">
        <div class="col-md-3">
            <c:forEach items="${brands}" var="brand">
                <c:if test="${brand.id==car.brandID}">
                    ${brand.brand}
                </c:if>
            </c:forEach>


        </div>
        <div class="col-md-3">${car.model}</div>
        <div class="col-md-2">${car.carClass}</div>
        <div class="col-md-2">${car.price}</div>
        <div class="col-md-2">${car.year}</div>
    </div>
</c:forEach>

<%@ include file="include/end-html.jsp" %>