<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">
    <h3>Мои подписки</h3><hr>
    <div class="row">
                <div class=col-md-1>Индекс</div>
                <div class=col-md-4>Издание</div>
                <div class=col-md-1>Кол-во номеров</div>
                <div class=col-md-1>Продол-<br>житель-<br>ность</div>
                <div class=col-md-1>Начало подписки</div>
                <div class=col-md-1>Конец подписки</div>
                <div class=col-md-1>Цена</div>
        </div><hr>

    <c:forEach items="${subscriptions}" var="subscription">
            <form class="update-publication-${subscription.id}" action="do?command=ShowSubscriptions" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        ${subscription.publication}
                    </div>
                    <div class=col-md-4>
                        ${publicationsNames.get(subscription.publication)}
                    </div>
                    <div class=col-md-1>
                        ${subscription.copies}
                    </div>
                    <div class=col-md-1>
                        ${subscription.period}
                    </div>
                    <div class=col-md-1>
                        ${subscription.start_subscription}
                    </div>
                    <div class=col-md-1>
                        ${subscription.end_subscription}
                    </div>
                    <div class=col-md-1>
                        ${subscription.price}
                    </div>
                    <div class=col-md-1>
                        <button id="Delete" value="${subscription.id}" name="Delete" class="btn btn-danger">
                           Отписаться
                        </button>
                    </div>
                </div>
            </form>
            <hr size="4">
    </c:forEach>
</div>

<p>SHOW SUBSCRIPTIONS: ${message}</p>

<%@ include file="include/end-html.jsp" %>