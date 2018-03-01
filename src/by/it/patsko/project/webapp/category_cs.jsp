<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" >
    <fieldset>

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
            <tr>
              <td>Блох Джошуа</td>
              <td>Java. Эффективное программирование</td>
              <td>200</td>
              <td>
                  <a href="do?command=toBasket" method="post" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">в корзину</a>
              </td>
            </tr>
            <tr>
              <td>Шилдт Герберт</td>
              <td>Java 8. Полное руководство</td>
              <td>500</td>
              <td>
                  <a href="do?command=toBasket" method="post"  class="btn btn-primary btn-lg active" role="button" aria-pressed="true">в корзину</a>
              </td>
            </tr>
          </tbody>
        </table>

    </fieldset>
</form>



<p>Cmd ERROR: ${error}</p>
<p>Cmd Message: ${message}</p>
<br><br><br><br><br><br><br><br><br>
<%@ include file="include/end-html.jsp" %>


