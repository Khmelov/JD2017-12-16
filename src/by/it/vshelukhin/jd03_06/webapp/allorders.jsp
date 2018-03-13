<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<legend>Ваши заказы</legend>
<br>
<div class="row" >
    <div class="col-md-5">Название</div>
    <div class="col-md-2">Цена</div>
</div>
<br>
<c:forEach items="${wrk}" var="wr">
    <div class="row">
        <div class="col-md-5">${wr.name} </div>
        <div class="col-md-2">${wr.price} рублей </div>
    </div>
</c:forEach>
<div class="row" >

    <div class="col-md-5"><b>Итого</b></div>
    <div class="col-md-2"><b>${priceAll} рублей</b></div>

</div>
<br>
<p>Форма для удаления заказов</p>
<form class="update-user-${user.id}" action="do?command=allorders" method=POST>
        <div class="row">
            <div class=col-md-5>
                <select id="role" name="zakazDel" class="form-control">
                       <option>Выберете заказ для удаления</option>
                                 <c:forEach items="${wrk}" var="wr">
                       <option>${wr.name}</option>
                                 </c:forEach>
                </select>
            </div>

            <div class=col-md-1>
                        <button id="Update" value="Update" name="del" class="btn btn-success">
                            Удалить
                        </button>
            </div>
        </div>
     </form>

<p>${message}</p>

<%@ include file="include/end-html.jsp" %>