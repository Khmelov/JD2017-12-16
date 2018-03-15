<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<legend>Сделайте Ваш заказ</legend>
     <form class="update-user-${user.id}" action="do?command=order" method=POST>
        <div class="row">
            <div class=col-md-5>
                <select id="role" name="zakaz" class="form-control">
                       <option>Выберете контрольную работу</option>
                                 <c:forEach items="${wrk}" var="wr">
                       <option>${wr.name}</option>
                                 </c:forEach>
                </select>
            </div>

            <div class=col-md-1>
                        <button id="Update" value="Update" name="toorder" class="btn btn-success">
                            Заказать
                        </button>
            </div>
        </div>
     </form>
<br>
<p>${message}</p>

<%@ include file="include/end-html.jsp" %>