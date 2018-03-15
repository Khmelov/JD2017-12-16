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

    <title>Hello JSP!</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="do?command=price">Цены<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="do?command=order">Заказать<span class="sr-only">(current)</span></a>
            </li>
             <c:choose>
             <c:when test="${student!=null}">
            <li class="nav-item active">
                <a class="nav-link" href="do?command=allorders">Ваш заказ<span class="sr-only">(current)</span></a>
            </li>
            </c:when>
            </c:choose>

            <c:choose>
            <c:when test="${student.getRole()==1}">
            <li class="nav-item active">
            <a class="nav-link" href="do?command=redprice">Редактировать прайс<span class="sr-only">(current)</span></a>
            </li>
            </c:when>
            </c:choose>

        </ul>
    </div>
    <ul class="navbar-nav navbar-right">
        <c:choose>
        <c:when test="${student==null}">

        <li class="nav-item active">
            <a class="nav-link" href="do?command=login">Войти<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="do?command=registration">Зарегистрироваться<span class="sr-only">(current)</span></a>
        </li>

        </c:when>
        <c:otherwise>

        <li class="nav-item active">
            <a class="nav-link" href="do?command=profile">${CurrentNameStud}<span class="sr-only">(current)</span></a>
        </li>

        <li class="nav-item active">
            <a class="nav-link" href="do?command=logout">Выйти<span class="sr-only">(current)</span></a>
        </li>

        </c:otherwise>
        </c:choose>

         <li class="nav-item">
            <a class="nav-link" href="do?command=ResetDB">ResetDB</a>
        </li>
    </ul>
</nav>