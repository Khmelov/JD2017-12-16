<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>




<div class="container">
    <div class="row">
         <div class=col-md-1>ID</div>
         <div class=col-md-2>catalogName</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${catalogs}" var="catalog">
            <form class="update-catalog-${catalog.id}" action="do?command=crudcatalogs" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${catalog.id}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="catalogName" class="form-control input-md" name="catalogName"
                               value="${catalog.catalogName}"/>
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
                     <div class=col-md-2>catalogName</div>
                </div>
            </div>

            <form class="create-catalog" action="do?command=crudcatalogs" method=POST>
               <div class="row">
                   <div class=col-md-1>
                       <input id="id" class="form-control input-md" name="id"
                              value="0"/>
                   </div>
                   <div class=col-md-3>
                       <input id="catalogName" class="form-control input-md" name="catalogName"/>
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


