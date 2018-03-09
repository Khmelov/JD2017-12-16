<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

   <p><b><c:out value="${category.categoryName}"/></b></p>
       <table class="table">
           <thead>
               <tr>
                   <th scope="col">Автор</th>
                   <th scope="col">Название</th>
                   <th scope="col">Цена</th>
                   <th scope="col"></th>
               </tr>
           </thead>
           <tbody>
               <c:forEach items="${books_in_category}" var="book">
                   <form class="form-horizontal" action="do?command=category&categoryId=${category.id}&bookToBasketId=${book.id}" method="post">
                       <tr>
                           <td>${book.author}</td>
                           <td>${book.name}</td>
                           <td>${book.price}</td>
                           <td>
                               <c:if test="${user!=null}">
                                   <button id="toBasket" value="toBasket" name="toBasket" class="btn btn-success">
                                       в корзину
                                   </button>
                               </c:if>
                           </td>
                       </tr>
                   </form>
               </c:forEach>
           </tbody>
       </table>



<p>Cmd ERROR: ${error}</p>
<p>Cmd Message: ${message}</p>
<br><br><br><br><br><br><br><br><br>
<%@ include file="include/end-html.jsp" %>


