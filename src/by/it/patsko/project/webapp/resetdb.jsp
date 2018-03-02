<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal"  action="do?command=ResetDB" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Reset DB</legend>

        <div class="alert alert-success" role="alert">
                  <h4 class="alert-heading">${message}</h4>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>