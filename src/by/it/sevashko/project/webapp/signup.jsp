<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/signup.css">
<%@ include file="include/navbar.jsp" %>

<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Регистрация нового пользователя</h5>
					<form class="" method="post" action="do?command=Signup">

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Логин</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="login" id="login"  placeholder="Придумайте логин" value="TestLogin"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Пароль</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Придумайте пароль" value="TestPassword"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Имя</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Введите своё имя" value="TestName"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Фамилия</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="lastName" id="lastName"  placeholder="Введите свою фамилию" value="TestLastName"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="Введите свой Email" value="test@email.com"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button  id="button" class="btn btn-primary btn-lg btn-block login-button">Зарегистрироваться</a>
						</div>

					</form>
				</div>
			</div>
		</div>

<p>SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>


