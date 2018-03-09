<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<br>
<div class="container">
<br>
    <b>
        <div class="row">
            <div class="col-md-4">Login</div>
            <div class="col-md-4">Phone Number</div>
            <div class="col-md-4">Password</div>
        </div>
    </b>
<br>
    <div class="row">
        <div class="col-md-4">${user.login} </div>
        <div class="col-md-4">${user.phoneNumber} </div>
        <div class="col-md-4">${user.password} </div>
    </div>
<br>
<form class="form-horizontal" action="do?command=Profile" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Edit profile</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required=""
                       value="${user.login}">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="PhoneNumber">Phone Number</label>
            <div class="col-md-4">
                <input id="PhoneNumber" name="PhoneNumber" type="text" placeholder="" class="form-control input-md" required=""
                       value="${user.phoneNumber}">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password Input</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="placeholder"
                       class="form-control input-md" required=""
                       value="${user.password}">
                <span class="help-block">(min 5 symbols)</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Save</button>
            </div>
        </div>

    </fieldset>
</form>
</div>

<%@ include file="include/end-html.jsp" %>