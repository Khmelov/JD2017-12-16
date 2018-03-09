<%@ page language="java" pageEncoding="UTF-8" %>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="do?command=ResetDB">ResetDB</a>
            </li>
            <c:if test="${user != null && user.fk_role == 1}">
                <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Операции
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="do?command=EditUsers">Пользователи</a>
                          <a class="dropdown-item" href="do?command=EditPublications">Издания</a>
                          <a class="dropdown-item" href="do?command=EditSubscriptions">Подписки</a>
                          <div class="dropdown-divider"></div>
                          <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                </li>
            </c:if>
        </ul>
    </div>
    <ul class="navbar-nav navbar-right">
        <c:if test="${user == null}">
            <li class="nav-item active">
                <a class="nav-link" href="do?command=Login">Login <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="do?command=SignUp">SignUp <span class="sr-only">(current)</span></a>
            </li>
        </c:if>
        <c:if test="${user != null}">
        <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      ${user.login}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="do?command=Profile">Профиль</a>
                      <a class="dropdown-item" href="do?command=ShowSubscriptions">Мои подписки</a>

                    </div>
        </li>
            <li class="nav-item active">
                <a class="nav-link" href="do?command=Logout">Logout<span class="sr-only">(current)</span></a>
            </li>
        </c:if>
    </ul>
</nav>
</head>
<body>