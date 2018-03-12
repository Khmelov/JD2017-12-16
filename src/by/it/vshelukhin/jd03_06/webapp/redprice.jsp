<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<legend>Редактировать прайс</legend>
<br>
<div class="container">
    <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-5>Название</div>
            <div class=col-md-2>Цена</div>

    </div>
</div>

<div class="container">
    <c:forEach items="${wrk}" var="wr">
            <form class="update-stud-${wr.id}" action="do?command=redprice" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${wr.id}"/>
                    </div>
                    <div class=col-md-5>
                        <input id="name" class="form-control input-md" name="name"
                               value="${wr.name}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="price" class="form-control input-md" name="price"
                               value="${wr.price}"/>
                    </div>

                    <div class=col-md-1>
                        <button id="Update" value="Update" name="update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>

                    <div class=col-md-1>
                        <button id="Delete" value="Delete" name="delete" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>
                </div>
            </form>
    </c:forEach>
    <form class="update-stud-${wr.id}" action="do?command=redprice" method=POST>
                    <div class="row">
                        <div class=col-md-1>
                            <input id="id" class="form-control input-md" name="id"
                                   value="0"/>
                        </div>
                        <div class=col-md-5>
                            <input id="name" class="form-control input-md" name="name"
                                   value=""/>
                        </div>

                        <div class=col-md-2>
                            <input id="price" class="form-control input-md" name="price"
                                   value=""/>
                        </div>

                        <div class=col-md-2>
                            <button id="Create" value="Create" name="create" class="btn btn-success">
                                Добавить
                            </button>
                        </div>

                    </div>
     </form>

</div>

<p>${message}</p>

<%@ include file="include/end-html.jsp" %>