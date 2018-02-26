<%@page language="java" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=addCar" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Добавить автомобиль</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Brand">Марка</label>
            <div class="col-md-4">
                <select id="Brand" name="Brand" class="form-control">
                    <option value="1">BMW</option>
                    <option value="2">Mercedes-Benz</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Model">Модель</label>
            <div class="col-md-4">
                <input id="Model" name="Model" type="text" placeholder="Модель" class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="CarClass">Класс</label>
            <div class="col-md-4">
                <select id="CarClass" name="CarClass" class="form-control">
                    <option value="Hatchback">Хэтчбек</option>
                    <option value="Sedan">Седан</option>
                    <option value="Crossover">Кроссовер</option>
                    <option value="SUV">Внедорожник</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Price">Цена</label>
            <div class="col-md-4">
                <input id="Price" name="Price" type="text" placeholder="Цена" class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Year">Год выпуска</label>
            <div class="col-md-4">
                <select id="Year" name="Year" class="form-control">
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="CarButton"></label>
            <div class="col-md-4">
                <button id="CarButton" name="CarButton" class="btn btn-primary">Добавить автомобиль</button>
            </div>
        </div>

    </fieldset>
</form>


<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>