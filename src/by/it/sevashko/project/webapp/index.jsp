<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">
    <h3>Доступные издания</h3><hr>
    <div class="row">
            <div class=col-md-1>Индекс</div>
            <div class=col-md-5>Название</div>
            <div class=col-md-2>Периодичность(кол-во экземпляров в п\год)</div>
            <div class=col-md-1>Мин. под. период (мес.)</div>
            <div class=col-md-1>Цена за мин. под. период</div>
    </div><hr>
    <c:forEach items="${publications}" var="publication">
            <form class="update-publication-${publication.id}" action="do?command=CreateSubscription&index=${publication.id}" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        ${publication.id}
                    </div>
                    <div class=col-md-5>
                        ${publication.name}
                    </div>
                    <div class=col-md-2>
                        ${publication.periodicity}
                    </div>
                    <div class=col-md-1>
                        ${publication.minPeriod}
                    </div>
                    <div class=col-md-1>
                        ${publication.price}
                    </div>
                    <c:if test="${user != null}">
                        <div class=col-md-1>
                            <button class="btn btn-success">
                                Подписаться
                            </button>
                        </div>
                    </c:if>
                </div>
            </form>
            <hr size="4">
    </c:forEach>
</div>

<p>INDEX: ${message}</p>

<%@ include file="include/end-html.jsp" %>