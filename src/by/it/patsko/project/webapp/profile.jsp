<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal"  action="do?command=profile" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Profile</legend>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="singlebutton">Ваш логин: ${profile_login}</label>
          <div class="col-md-4">
            <button id="singlebutton" name="singlebutton" class="btn btn-primary">изменить</button>
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="singlebutton">Ваш пароль: ${profile_password}</label>
          <div class="col-md-4">
            <button id="singlebutton" name="singlebutton" class="btn btn-primary">изменить</button>
          </div>
        </div>
<a class="btn btn-primary btn-lg" href="do?command=Logout" role="button">Выйти из профиля</a>
    </fieldset>
</form>



<p>Cmd Login: <b>${message}</b></p>

<%@ include file="include/end-html.jsp" %>