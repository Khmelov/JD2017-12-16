<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<h3>User</h3>
<p>${user}</p>

<form class="form-horizontal"  action="do?command=Profile" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Form Login</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required=""
                       value="${user.login}">
                <span class="help-block">Login (hint)</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Pasword">Pasword Input</label>
            <div class="col-md-4">
                <input id="Pasword" name="Pasword" type="pasword" placeholder="placeholder" class="form-control input-md" required=""
                       value="${user.pasword}">
                <span class="help-block">(min 6 symbols)</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Изменить</button>
            </div>
        </div>

    </fieldset>
</form>

<div class="page-header">
    <h1>Все объявления</h1>
    <p class="lead">Пример макета для вывода данных в виде таблицы</p>
</div>

<div class="row">
    <div class="col-md-1">Грузоподъёмность</div>
    <div class="col-md-3">Объём кузова</div>
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


<%@ include file="include/end-html.jsp" %>