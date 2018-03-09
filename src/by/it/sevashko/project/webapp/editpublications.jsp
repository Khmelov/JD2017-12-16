<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">
    <h3>Добовление нового издания</h3>
    <form class="add-publication" action="do?command=EditPublications" method=POST>
        <div class="row">
            <div class=col-md-11>
                <textarea name="name" id="name" class="form-control" aria-label="With textarea"
                placeholder="Название издания">TestName</textarea>
            </div>
        </div>
                <div class="row">
                    <div class=col-md-3>
                        <input id="periodicity" class="form-control input-" name="periodicity"
                               placeholder="Периодичность" value="26"/>
                    </div>
                    <div class=col-md-3>
                        <input id="minPeriod" class="form-control input-md" name="minPeriod"
                               placeholder="Мин. под. период (мес.)" value="2"/>
                    </div>
                    <div class=col-md-3>
                        <input id="price" class="form-control input-md" name="price"
                               placeholder="Цена" value="45.8"/>
                    </div>
                    <div class=col-md-3>
                        <button id="Add" value="Add" name="Add" class="btn btn-primary">
                             Добавить
                        </button>
                    </div>
                </div>
            </form>
            <hr>
</div>

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
            <form class="update-publication-${publication.id}" action="do?command=EditPublications" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="index" class="form-control input-md" name="index"
                               value="${publication.id}"/>
                    </div>
                    <div class=col-md-5>
                        <textarea name="name" id="name" class="form-control" aria-label="With textarea"
                                        placeholder="Название издания">${publication.name}</textarea>
                    </div>
                    <div class=col-md-2>
                        <input id="periodicity" class="form-control input-" name="periodicity"
                               value="${publication.periodicity}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="minPeriod" class="form-control input-" name="minPeriod"
                               value="${publication.minPeriod}"/>
                        </select>
                    </div>
                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="${publication.price}"/>
                    </div>
                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                             Удалить
                        </button>
                    </div>
                </div>
            </form>
            <hr size="4">
    </c:forEach>
</div>

<p>INDEX: ${message}</p>

<%@ include file="include/end-html.jsp" %>