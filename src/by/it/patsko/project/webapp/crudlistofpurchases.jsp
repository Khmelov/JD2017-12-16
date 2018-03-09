<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="container">
    <div class="row">
         <div class=col-md-1>ID</div>
         <div class=col-md-2>users_id</div>
         <div class=col-md-2>books_id</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${list_ofPurchases}" var="list">
            <form class="update-list-${list.id}" action="do?command=crudlistofpurchases" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${list.id}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="users_id" class="form-control input-md" name="users_id"
                               value="${list.users_id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="books_id" class="form-control input-md" name="books_id"
                               value="${list.books_id}"/>
                    </div>

                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>

                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                            Удалить
                        </button>
                </div>
            </form>
            <br>
    </c:forEach>
    <br><br>

    <p>
      <button class="btn btn-success btn-lg" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
        Create
      </button>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <div class="container">
                <div class="row">
                     <div class=col-md-1>ID</div>
                     <div class=col-md-2>users_id</div>
                     <div class=col-md-2>books_id</div>
                </div>
            </div>

            <form class="create-list" action="do?command=crudlistofpurchases" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="0"/>
                    </div>

                    <div class=col-md-2>
                        <input id="users_id" class="form-control input-md" name="users_id"
                               value="${list.users_id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="books_id" class="form-control input-md" name="books_id"
                               value="${list.books_id}"/>
                    </div>

                    <button id="Create" value="Create" name="Create" class="btn btn-success">
                        ok
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>



<%@ include file="include/end-html.jsp" %>


