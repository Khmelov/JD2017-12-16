<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="update-book-${category.id}" action="do?command=crudbooks" method=POST>
    <div class="row">
        <div class=col-md-2>
            <select id="choose_category_id" name="choose_category_id" class="form-control">
                <c:forEach items="${categories}" var="category">
                        <option value="${category.id}" role=${category.id} "selected"}>
                                ${category.categoryName}
                        </option>
                </c:forEach>
            </select>
        </div>
        <button class="btn btn-success">
            ok
        </button>
    </div>
</form>
<br><br>

<c:if test="${choose_category_id!=null}">
    <div class="container">
        <div class="row">
             <div class=col-md-1>ID</div>
             <div class=col-md-2>Название</div>
             <div class=col-md-2>Автор</div>
             <div class=col-md-2>Цена</div>
             <div class=col-md-2>Категория</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${books}" var="book">
                <form class="update-book-${book.id}" action="do?command=crudbooks" method=POST>
                    <div class="row">
                        <div class=col-md-1>
                            <input id="id" class="form-control input-md" name="id"
                                   value="${book.id}"/>
                        </div>
                        <div class=col-md-2>
                            <input id="name" class="form-control input-md" name="name"
                                   value="${book.name}"/>
                        </div>
                        <div class=col-md-2>
                            <input id="author" class="form-control input-md" name="author"
                                   value="${book.author}"/>
                        </div>
                        <div class=col-md-2>
                            <input id="price" class="form-control input-md" name="price"
                                   value="${book.price}"/>
                        </div>

                        <div class=col-md-2>
                            <select id="Category_id" name="Category_id" class="form-control">
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}" role=${category.id} ${category.id==book.category_id?"selected":""}>
                                            ${category.categoryName}
                                    </option>
                                </c:forEach>
                            </select>
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
                         <div class=col-md-2>Название</div>
                         <div class=col-md-2>Автор</div>
                         <div class=col-md-2>Цена</div>
                         <div class=col-md-2>Категория</div>
                    </div>
                </div>

                <form class="create-catalog" action="do?command=crudbooks" method=POST>
                   <div class="row">
                       <div class=col-md-1>
                           <input id="id" class="form-control input-md" name="id"
                                  value="0"/>
                       </div>
                       <div class=col-md-2>
                           <input id="name" class="form-control input-md" name="name"
                                  value="${book.name}"/>
                       </div>
                       <div class=col-md-2>
                           <input id="author" class="form-control input-md" name="author"
                                  value="${book.author}"/>
                       </div>
                       <div class=col-md-2>
                           <input id="price" class="form-control input-md" name="price"
                                  value="${book.price}"/>
                       </div>

                       <div class=col-md-2>
                           <select id="Category_id" name="Category_id" class="form-control">
                               <c:forEach items="${categories}" var="category">
                                   <option value="${category.id}" role=${category.id} "selected"}>
                                           ${category.categoryName}
                                   </option>
                               </c:forEach>
                           </select>
                       </div>

                       <button id="Create" value="Create" name="Create" class="btn btn-success">
                           ok
                       </button>
                   </div>
                </form>
            </div>
        </div>
    </div>
</c:if>



<%@ include file="include/end-html.jsp" %>


