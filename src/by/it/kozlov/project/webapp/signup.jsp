<%@page language="java" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="Login" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Email">Email</label>
            <div class="col-md-4">
                <input id="Email" name="Email" type="text" placeholder="Email" class="form-control input-md">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="text" placeholder="Password" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="SignUpButton"></label>
            <div class="col-md-4">
                <button id="SignUpButton" name="SignUpButton" class="btn btn-primary">Зарегистрироваться</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd SignUp: ${message}</p>

<%@ include file="include/end-html.jsp" %>


