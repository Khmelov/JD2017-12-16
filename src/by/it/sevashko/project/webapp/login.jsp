<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/signup.css">
<%@ include file="include/navbar.jsp" %>

<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Авторизация</h5>
					<form class="" method="post" action="do?command=Login">

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Логин</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="login" id="login"  placeholder="Введите логин" value="TestLogin"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Пароль</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Введите пароль" value="TestPassword"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button  id="button" class="btn btn-primary btn-lg btn-block login-button">Войти</a>
						</div>

					</form>
				</div>
			</div>
		</div>

<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>


