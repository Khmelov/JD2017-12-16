<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">

    <form class="form-horizontal"  action="do?command=CreateSubscription&index=${publication.id}" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Оформление подписки на издание: ${publication.name}</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="period">Период подписки:</label>
                <div class="col-md-4">
                        <select id="period" name="period" class="form-control">
                            <c:forEach items="${options}" var="option">
                                <option value="${option}"}>
                                        ${option}
                                </option>
                            </c:forEach>
                        </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="start_subscription">Начало подписки:</label>
                <div class="col-md-4">
                    <input id="start_subscription" name="start_subscription" type="text" placeholder="ГГГГ-ММ-ДД" class="form-control input-md" required=""
                           value="">
                </div>
            </div>

            <!-- Button -->
            <div class="row">
                 <div class=col-md-2>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="Subscribe"></label>
                        <div class="col-md-4">
                            <button id="Subscribe" name="Subscribe" value="Subscribe" class="btn btn-primary">Оформить подписку</button>
                        </div>
                    </div>
                 </div>
            </div>
        </fieldset>
    </form>

</div>


<p>CREATE SUBSCRIPTION: ${message}</p>

<%@ include file="include/end-html.jsp" %>