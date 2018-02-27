<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal"  action="do?command=InitDB" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Init DB</legend>

        <div class="alert alert-success" role="alert">
          <h4 class="alert-heading">База данных восстановлена!!!</h4>
        </div>


    </fieldset>
</form>

<p>Cmd Init DB: <b>${message}</b></p>

<%@ include file="include/end-html.jsp" %>