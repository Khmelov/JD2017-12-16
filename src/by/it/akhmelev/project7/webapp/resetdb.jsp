<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=ResetDB" method="post">
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

<p>Нажмите на кнопку чтобы создать или сбросиь базу akhmelev (порт 2016)</p>

<p>Cmd Reset DB: <b>${message}</b></p>

<%@ include file="include/end-html.jsp" %>