<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
  <h1> Все товары</h1>
  <p class="lead"></p>
</div>

<div class="container">
<div class="row">
   <div class="col-md-2">Товар</div>
   <div class="col-md-1">Цена</div>
   <div class="col-md-1">Размер</div>
   <div class="col-md-1">Цвет</div>
   <div class="col-md-2">Состав</div>
   <div class="col-md-3">Описание</div>
   <div class="col-md-1"></div>
   <div class="col-md-1"></div>

</div>
<br>

<c:forEach items="${goods}" var="good">
   <form class="update-good-${good.id}" action="do?command=Index" method=POST>
      <div class="row">
         <div class="col-md-2">${good.name}</div>
         <div class="col-md-1">
                     <input id="price" class="form-control input-md" name="Price" class="form-control"
                        value="${good.price}"  />

         </div>
         <div class="col-md-1">${good.size}</div>
         <div class="col-md-1">${good.colour}</div>
         <div class="col-md-2">${good.structure}</div>
         <div class="col-md-3">${good.description}</div>


         <div class="col-md-1">
            <input id="id" class="form-control input-md" name="ID" type="hidden" class="form-control"
               value="${good.id}"  />

         </div>

         <div class="col-md-1">
            <button id="Update" value="Update" name="Update" class="btn btn-success">
                  В корзину
            </button>
         </div>
      </div>

   </form>

</c:forEach>
</div>

<br><br>


<%@ include file="include/end-html.jsp" %>