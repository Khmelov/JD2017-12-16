<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Signup" method="post">
<fieldset>

<!-- Form Name -->
<legend>Регистрация нового пользователя</legend>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required=""
  value="TestLogin">
  <span class="help-block">Введите Ваш логин</span>
  </div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
  value="TestEmail@google.com" >
  <span class="help-block">Укажите e-mail</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="********" class="form-control input-md" required=""
    value="TestPassword">
    <span class="help-block">Введите пароль минимум 4 символов</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="btnSignup"></label>
  <div class="col-md-4">
    <button id="btnSignup" name="btnSignup" class="btn btn-success">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>

<p>SIGN-UP MESSAGE: <b>${message}</b></p>

<%@ include file="include/end-html.jsp" %>


