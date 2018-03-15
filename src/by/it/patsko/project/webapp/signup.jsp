<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Signup" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Form Signup</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required=""
                value="TestLogin">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Email">Email</label>
            <div class="col-md-4">
                <input id="Email" name="Email" type="text" placeholder="your Email" class="form-control input-md" required=""
                value="TestEmail@google.com" >
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="text" placeholder="placeholder" class="form-control input-md" required=""
                value="TestPassword">
                <span class="help-block">(min 6 symbols)</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Зарегистрироваться</button>
            </div>
        </div>

    </fieldset>
</form>


<!--<p>SIGN-UP MESSAGE: <b>${message}</b></p>-->

<%@ include file="include/end-html.jsp" %>


