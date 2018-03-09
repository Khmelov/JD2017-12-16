<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">

    <form class="form-horizontal"  action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Профиль пользователя</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.login}">
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="пароль" class="form-control input-md" required=""
                           value="${user.password}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Имя</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.name}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="lastName">Фамилия</label>
                <div class="col-md-4">
                    <input id="lastName" name="lastName" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.lastName}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.email}">
                </div>
            </div>

            <!-- Button -->
            <div class="row">
                 <div class=col-md-2>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="Update"></label>
                        <div class="col-md-4">
                            <button id="Update" name="Update" value="Update" class="btn btn-primary">Изменить</button>
                        </div>
                    </div>
                 </div>

                 <div class=col-md-1>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="Delete"></label>
                        <div class="col-md-4">
                            <button id="Delete" name="Delete" value="Delete" class="btn btn-danger">Удалить</button>
                        </div>
                    </div>
                 </div>
            </div>
        </fieldset>
    </form>

</div>


<p>PROFILE: ${message}</p>

<%@ include file="include/end-html.jsp" %>