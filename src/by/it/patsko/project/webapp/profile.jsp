<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal"  action="do?command=profile" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Profile</legend>

            <p>Ваш логин: ${profile_login}<p>

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalOne">
                  изменить логин
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalOne" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelOne" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabelOne">Изменить логин</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                            <!-- Login input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="newLogin">Login</label>
                                <div class="col-md-4">
                                    <input id="newLogin" name="newLogin" type="text" placeholder="новый логин" class="form-control input-md" required="">
                                </div>
                            </div>
                            <!-- Button -->
                            <div class="form-group">
                            <label class="col-md-4 control-label" for="singlebuttonOne"></label>
                                <div class="col-md-4">
                                    <button id="singlebuttonOne" name="singlebuttonOne" class="btn btn-primary">Сохранить логин</button>
                                </div>
                            </div>
                      </div>
                    </div>
                  </div>
                </div>
</fieldset>
</form>


<form class="form-horizontal"  action="do?command=profile" method="post">
    <fieldset>

            <p>Ваш пароль: ${profile_password}<p>
                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalTwo">
                                  изменить пароль
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalTwo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelTwo" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                      <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabelTwo">Изменить пароль</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                          <span aria-hidden="true">&times;</span>
                                        </button>
                                      </div>
                                      <div class="modal-body">
                                            <!-- Password input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="newPassword">Password</label>
                                                <div class="col-md-4">
                                                    <input id="newPassword" name="newPassword" type="text" placeholder="новый пароль" class="form-control input-md" required="">
                                                </div>
                                            </div>
                                            <!-- Button -->
                                            <div class="form-group">
                                            <label class="col-md-4 control-label" for="singlebuttonTwo"></label>
                                                <div class="col-md-4">
                                                    <button id="singlebuttonTwo" name="singlebuttonTwo" class="btn btn-primary">Сохранить пароль</button>
                                                </div>
                                            </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>

</fieldset>
</form>
        <a class="btn btn-outline-primary btn-lg btn-block" href="do?command=Logout" role="button">Logout</a>




<p>Cmd Login: <b>${message}</b></p>

<%@ include file="include/end-html.jsp" %>