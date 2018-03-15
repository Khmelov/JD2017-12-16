<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>SingUp</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">min 5 symbols</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="E-mail">e-mail</label>
  <div class="col-md-4">
  <input id="E-mail" name="E-mail" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">your e-mail</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="pasword">Pasword Input</label>
  <div class="col-md-4">
    <input id="pasword" name="pasword" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">min 7 symbols </span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Submitbutton"></label>
  <div class="col-md-4">
    <button id="Submitbutton" name="Submitbutton" class="btn btn-success">submit</button>
  </div>
</div>

</fieldset>
</form>




<%@ include file="include/end-html.jsp" %>


