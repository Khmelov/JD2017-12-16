<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal" action="do?command=Signup" method="post">
<fieldset>

<!-- Form Name -->
<legend>Форма Регистрации</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Логин</label>
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">минимум 5 символов</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="E-mail">e-mail</label>
  <div class="col-md-4">
  <input id="E-mail" name="E-mail" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">ваш электронный ящик</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="pasword">Ввод Пароля</label>
  <div class="col-md-4">
    <input id="pasword" name="pasword" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">минимум 7 символов </span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Submitbutton"></label>
  <div class="col-md-4">
    <button id="Submitbutton" name="Submitbutton" class="btn btn-success">Регистрация</button>
  </div>
</div>

</fieldset>
</form>




<%@ include file="include/end-html.jsp" %>


