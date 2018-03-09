<%@page language="java" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>

<p>${message}</p>
<div class="page-header">
    <legend>Все автомобили пользователя</legend>
</div>

<div class="row">
    <div class="col-md-3">Бренд</div>
    <div class="col-md-2">Марка</div>
    <div class="col-md-2">Класс</div>
    <div class="col-md-2">Цена $</div>
    <div class="col-md-1">Год</div>
    <div class="col-md-1"></div>
</div>

<div class="col-md-12">
    <hr align="center" width="1100" size="2" color="#ff0000"/>
</div>

<c:forEach items="${cars}" var="car">
    <form class="form-horizontal" action="do?command=AllCarsUser" method="POST">
        <div class="form-row">
            <div class="col-md-3">
                <select id="Brand" name="Brand" class="form-control">
                    <c:forEach items="${brands}" var="brand">
                        <option value="${brand.id}"
                                <c:if test="${brand.id==car.brandID}">
                                    selected
                                </c:if>
                        >${brand.brand}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-2">
                <input id="Model" name="Model" type="text" class="form-control" value="${car.model}">
            </div>
            <div class="col-md-2">
                <select id="CarClass" name="CarClass" class="form-control">
                    <option value="${car.carClass}" selected>${car.carClass}</option>
                    <option value="Хэтчбек">Хэтчбек</option>
                    <option value="Седан">Седан</option>
                    <option value="Кроссовер">Кроссовер</option>
                    <option value="Внедорожник">Внедорожник</option>
                </select>
            </div>
            <div class="col-md-2">
                <input id="Price" name="Price" type="text" class="form-control" value="${car.price}">
            </div>
            <div class="col-md-1">
                <select id="Year" name="Year" class="form-control">
                    <option value="${car.year}">${car.year}</option>
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                </select>
            </div>
            <div class="col-md-1">
                <button name="Submit" value="${car.id}" type="submit" class="btn btn-success mb-2">Изменить</button>
            </div>
            <div class="col-md-1">
                <button name="Delete" value="${car.id}" type="delete" class="btn btn-danger mb-2">Удалить</button>
            </div>
        </div>
    </form>
    <br>
</c:forEach>

<%@ include file="include/end-html.jsp" %>