<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>CreateAd</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Name">Name</label>
  <div class="col-md-4">
  <input id="Name" name="Name" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Carrying">Carrying</label>
  <div class="col-md-4">
  <input id="Carrying" name="Carrying" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Volume">Volume</label>
  <div class="col-md-4">
  <input id="Volume" name="Volume" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Tariff">Tariff</label>
  <div class="col-md-4">
  <input id="Tariff" name="Tariff" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Description">Description</label>
  <div class="col-md-4">
    <textarea class="form-control" id="Description" name="Description">limit 500 symbols</textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Create"></label>
  <div class="col-md-4">
    <button id="Create" name="Create" class="btn btn-info">Create</button>
  </div>
</div>

</fieldset>
</form>

<p>Main: ${message}</p>

<%@ include file="include/end-html.jsp" %>

