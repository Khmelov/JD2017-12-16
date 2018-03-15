<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<!-- Form Name -->


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Логин</label>
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block"></span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="pasword">Пароль</label>
  <div class="col-md-4">
    <input id="pasword" name="pasword" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block"> </span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Submitbutton"></label>
  <div class="col-md-4">
    <button id="Submitbutton" name="Submitbutton" class="btn btn-primary">Вход</button>
  </div>
</div>

</fieldset>
</form>


<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>