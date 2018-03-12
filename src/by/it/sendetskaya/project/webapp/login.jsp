<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="loginID">Login</label>
  <div class="col-md-4">
  <input id="loginID" name="loginID" type="text" placeholder="input login" class="form-control input-md" required=""
  value="TestLogin">
  <span class="help-block">your login</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordLoginID">Password</label>
  <div class="col-md-4">
    <input id="passwordLoginID" name="passwordLoginID" type="password" placeholder="input password" class="form-control input-md"required=""
      value="TestPassword">
    <span class="help-block">(min 6 symbols)</span>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="btnLoginOkID"></label>
  <div class="col-md-8">
    <button id="btnLoginOkID" name="btnLoginOkID" class="btn btn-success">Войти</button>
    <button id="btnLoginCancelID" name="btnLoginCancelID" class="btn btn-danger">Отмена</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd Login: <b>${message}</b></p>

<%@ include file="include/end-html.jsp" %>