<%@ page pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CreateAd" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создать объявление</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Description">Описание</label>
  <div class="col-md-4">
  <input id="Description" name="Description" value="Тестовое описание"
         type="text" placeholder="" class="form-control input-md" required="" >

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Address">Адрес</label>
  <div class="col-md-4">
  <input id="Address" name="Address"   value="Тестовый адрес"
         type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Area">Площадь</label>
  <div class="col-md-4">
  <input id="Area" name="Area" type="text" placeholder="" class="form-control input-md"  value="0.5">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floor">Этаж</label>
  <div class="col-md-4">
  <input id="Floor" name="Floor" type="text" placeholder="" class="form-control input-md" required=""  value="3">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Floors">Число этажей</label>
  <div class="col-md-4">
  <input id="Floors" name="Floors" type="text" placeholder="" class="form-control input-md" required=""  value="5">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="RoomCount">Число комнат</label>
  <div class="col-md-4">
  <input id="RoomCount" name="RoomCount" type="text" placeholder="" class="form-control input-md" required=""  value="2">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Цена</label>
  <div class="col-md-4">
  <input id="Price" name="Price" type="text" placeholder="" class="form-control input-md" required=""  value="55555">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="postbutton"></label>
  <div class="col-md-4">
    <button id="postbutton" name="postbutton" class="btn btn-primary">Создать</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>