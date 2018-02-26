<%@page language="java" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Войти</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="Login" class="form-control input-md">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="Password" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LoginButton"></label>
            <div class="col-md-4">
                <button id="LoginButton" name="LoginButton" class="btn btn-primary">Войти</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>