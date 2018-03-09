<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<br>
<div class="container">
<form class="form-horizontal"  action="do?command=ResetDB" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Reset DB</legend>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Reset (or create) DB</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Reset and create DataBase</p>

<p>Cmd Reset DB: <b>${message}</b></p>
</div>

<%@ include file="include/end-html.jsp" %>