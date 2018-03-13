<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">
    <h3>Добавление новой подписки</h3><hr>
    <form class="add-subscription" action="do?command=EditSubscriptions" method=POST>
                <div class="row">
                        <div class=col-md-1>ID клиента</div>
                        <div class=col-md-1>ID издания</div>
                        <div class=col-md-1>Кол-во номеров</div>
                        <div class=col-md-1>Продол-<br>житель-<br>ность</div>
                        <div class=col-md-2>Начало подписки</div>
                        <div class=col-md-2>Конец подписки</div>
                        <div class=col-md-1>Цена</div>
                </div><hr>
                <div class="row">
                    <div class=col-md-1>
                        <input id="user" class="form-control input-md" name="user"
                               value="1"/>
                    </div>
                    <div class=col-md-1>
                        <input id="publication" class="form-control input-md" name="publication"
                               value="2"/>
                    </div>
                    <div class=col-md-1>
                        <input id="copies" class="form-control input-" name="copies"
                               value="12"/>
                    </div>
                    <div class=col-md-1>
                        <input id="period" class="form-control input-" name="period"
                               value="6"/>
                        </select>
                    </div>
                    <div class=col-md-2>
                        <input id="start_subscription" class="form-control input-md" name="start_subscription"
                               value="2016-08-01"/>
                    </div>
                    <div class=col-md-2>
                        <input id="end_subscription" class="form-control input-md" name="end_subscription"
                               value="2016-12-01"/>
                    </div>
                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="18.53"/>
                    </div>
                    <div class=col-md-1>
                        <button id="Add" value="Add" name="Add" class="btn btn-primary">
                             Добавить
                        </button>
                    </div>
                </div>
            </form>
            <hr>
</div>

<div class="container users">
    <h3>Оформленные подписки</h3><hr>
    <div class="row">
            <div class=col-md-1>ID подписки</div>
            <div class=col-md-1>ID клиента</div>
            <div class=col-md-1>ID издания</div>
            <div class=col-md-1>Кол-во номеров</div>
            <div class=col-md-1>Продол-<br>житель-<br>ность</div>
            <div class=col-md-2>Начало подписки</div>
            <div class=col-md-2>Конец подписки</div>
            <div class=col-md-1>Цена</div>
    </div><hr>
    <c:forEach items="${subscriptions}" var="subscription">
            <form class="update-subscription-${subscription.id}" action="do?command=EditSubscriptions" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${subscription.id}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="user" class="form-control input-md" name="user"
                               value="${subscription.user}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="publication" class="form-control input-md" name="publication"
                               value="${subscription.publication}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="copies" class="form-control input-" name="copies"
                               value="${subscription.copies}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="period" class="form-control input-" name="period"
                               value="${subscription.period}"/>
                        </select>
                    </div>
                    <div class=col-md-2>
                        <input id="start_subscription" class="form-control input-md" name="start_subscription"
                               value="${subscription.start_subscription}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="end_subscription" class="form-control input-md" name="end_subscription"
                               value="${subscription.end_subscription}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="${subscription.price}"/>
                    </div>
                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>
                    <div class=col-md-1>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                             Удалить
                        </button>
                    </div>
                </div>
            </form>
            <hr size="4">
    </c:forEach>
</div>

<p>EDIT SUBSCRIPTIONS: ${message}</p>

<%@ include file="include/end-html.jsp" %>