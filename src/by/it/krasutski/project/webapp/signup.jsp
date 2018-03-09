<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<br>
<div class="container">
    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>

            <legend>Hello new Bonjo user!</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Login">Login</label>
                <div class="col-md-4">
                    <input id="Login" name="Login" type="text" placeholder="ExampleLogin" class="form-control input-md"
                           required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Email">Email</label>
                <div class="col-md-4">
                    <input id="Email" name="Email" type="text" placeholder="example@google.com"
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Password Input</label>
                <div class="col-md-4">
                    <input id="Password" name="Password" type="password" placeholder="min 5 symbols"
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Nickname">Nickname</label>
                <div class="col-md-4">
                    <input id="Nickname" name="Nickname" type="text" placeholder="example" class="form-control input-md"
                           required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="PhoneNumber">PhoneNumber</label>
                <div class="col-md-4">
                    <input id="PhoneNumber" name="PhoneNumber" type="text" placeholder="+375297777777"
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Sign Up</button>
                </div>
            </div>

        </fieldset>
    </form>

    <p>SIGN-UP MESSAGE: <b>${message}</b></p>
</div>

<%@ include file="include/end-html.jsp" %>


