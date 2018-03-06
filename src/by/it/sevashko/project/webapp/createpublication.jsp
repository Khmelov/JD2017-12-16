<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/navbar.jsp" %>

<div class="container">
	<form class="well span8" method="post" action="do?command=CreatePublication">
        <div class="row">

            <div class="span5">
                <label>Название издания</label>
                <textarea class="input-xlarge span5" id="name" name="name" rows="7"></textarea>
            </div>

            <div class="span3">
                <label>Периодичность</label> <input class="span3" placeholder=
                "Количество экземпляров в полугодии" type="text" name="periodicity">
                <label>Минимальный подписной период</label>
                <input class="span3" placeholder="в месяцах" type="text" name="minPeriod">
                <label>Цена</label>
                <input class="span3" placeholder=
                "Цена мин. подписного периода" type="text" name="price">
            </div>


            <button class="btn btn-primary pull-right">Добавить издание</button>
        </div>
    </form>
</div>

<p>Cmd CreatePublication: ${message}</p>

<%@ include file="include/end-html.jsp" %>


