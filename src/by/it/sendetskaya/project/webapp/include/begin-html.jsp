<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>Интернет-магазин</title>
  </head>

  <body>

  <div class="container">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="do?command=Index">Каталог товаров <span class="sr-only">(current)</span></a>
        </li>

        <c:if test="${buyer!=null && buyer.fk_roles==1}">

            <li class="nav-item">
                  <a class="nav-link" href="do?command=ResetDB">Сброс БД</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=EditBuyer">Редактирование пользователей</a>
            </li>
        </c:if>
</ul>
</div>

 <form class="form-inline my-1 my-lg-0">

        <input id="searchInput" name="searchInput" class="form-control input-md" type="search"
        placeholder="Search" aria-label="Search">

        <button id="searchBtn" name="searchBtn" class="btn btn-outline-success my-1 my-sm-0" href="do?command=Index"
        type="submit">Search</button>
 </form>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <ul class="navbar-nav navbar-right">
  <c:choose>
       <c:when test="${buyer==null}">
          <li class="nav-item">
            <a class="nav-link" href="do?command=SignUp">Зарегистрироваться <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="do?command=Login">Войти <span class="sr-only">(current)</span></a>
          </li>
       </c:when>
       <c:otherwise>

        <c:if test="${buyer.fk_roles!=3}">
          <li class="nav-item active">
             <a class="nav-link" href="do?command=Profile">Личный кабинет <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
             <a class="nav-link" href="do?command=CreateBasket">Корзина<span class="sr-only">(current)</span></a>
          </li>
        </c:if>
          <li class="nav-item">
            <a class="nav-link" href="do?command=Logout">Выйти <span class="sr-only">(current)</span></a>
          </li>
       </c:otherwise>
  </c:choose>

     </ul>
     </nav>

    </nav>





