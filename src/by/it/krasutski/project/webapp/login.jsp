<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<br>
<div class="container">
<form class="form-horizontal"  action="do?command=Login" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Welcome back!</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="put your login here" class="form-control input-md" required="">
                <span class="help-block">Login (hint)</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password Input</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="put your password here" class="form-control input-md" required="">
                <span class="help-block">(min 5 symbols)</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Login</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Login: <b>${message}</b></p>
</div>

<%@ include file="include/end-html.jsp" %>