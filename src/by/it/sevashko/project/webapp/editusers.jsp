<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<link rel="stylesheet" href="css/container.css">
<%@ include file="include/navbar.jsp" %>

<div class="container users">
    <h3>Регистрация нового пользователя</h3>
    <form class="add-user" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <div class=col-md-3>
                        <input id="login" class="form-control input-" name="login"
                               placeholder="Логин" value="TestLogin"/>
                    </div>
                    <div class=col-md-3>
                        <input id="name" class="form-control input-md" name="name"
                               placeholder="Имя" value="TestName"/>
                    </div>
                    <div class=col-md-3>
                        <input id="email" class="form-control input-md" name="email"
                               placeholder="Email" value="Test@email.com"/>
                    </div>

                    <div class=col-md-3>
                        <select id="role" name="fk_role" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.fk_role?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class=col-md-3>
                        <input id="password" class="form-control input-md" name="password"
                               placeholder="Пароль" value="TestPassword"/>
                    </div>
                    <div class=col-md-3>
                        <input id="lastName" class="form-control input-md" name="lastName"
                               placeholder="Фамилия"/ value="TestLastName">
                    </div>
                    <div class=col-md-3>
                        ${message}
                    </div>
                    <div class=col-md-3>
                        <button id="Add" value="Add" name="Add" class="btn btn-primary">
                             Добавить
                        </button>
                    </div>
                </div>
            </form>
            <hr>
</div>

<div class="container users">
    <h3>Зарегистрированные пользователи</h3><hr>
    <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Логин/Пароль</div>
            <div class=col-md-2>Фамилия/Имя</div>
            <div class=col-md-3>Email</div>
            <div class=col-md-2>Роль</div>
    </div><hr>
    <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${user.id}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="login" class="form-control input-" name="login"
                               value="${user.login}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="name" class="form-control input-md" name="name"
                               value="${user.name}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="email" class="form-control input-" name="email"
                               value="${user.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="role" name="fk_role" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.fk_role?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class=col-md-1>
                        <button id="Update" value="Update" name="Update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>
                </div>

                <div class="row">
                    <div class=col-md-1>
                    </div>
                    <div class=col-md-2>
                        <input id="password" class="form-control input-md" name="password"
                               value="${user.password}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="lastName" class="form-control input-md" name="lastName"
                               value="${user.lastName}"/>
                    </div>
                    <div class=col-md-3>
                    </div>
                    <div class=col-md-2>
                    </div>
                    <div class=col-md-1>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                             Удалить
                        </button>
                    </div>
                </div>
            </form>
            <hr size="4">
    </c:forEach>
</div>

<p>INDEX: ${message}</p>

<%@ include file="include/end-html.jsp" %>