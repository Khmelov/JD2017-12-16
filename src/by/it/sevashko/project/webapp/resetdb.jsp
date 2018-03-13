<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">
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
    <p>Нажмите на кнопку чтобы создать или сбросиь базу sevashko (порт 2016)</p>
    <p><b>${message}</b></p>
</div>

<%@ include file="include/end-html.jsp" %>