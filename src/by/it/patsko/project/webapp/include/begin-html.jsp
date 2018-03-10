<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>Patsko Arkadzi!</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Catalog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <c:if test="${user.roles_id==1}">
         <div class="dropdown">
             <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               I/R DataBase
             </button>
             <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
               <a class="dropdown-item" href="do?command=InitDB">InitDB</a>
               <a class="dropdown-item" href="do?command=ResetDB">ResetDB</a>
             </div>
         </div>

         <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   DataBase actions
              </button>
              <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                   <a class="dropdown-item" href="do?command=crudbooks">CRUD books</a>
                   <div class="dropdown-divider"></div>
                   <a class="dropdown-item" href="do?command=crudcatalogs">CRUD catalogs</a>
                   <div class="dropdown-divider"></div>
                   <a class="dropdown-item" href="do?command=crudcategories">CRUD categories</a>
                   <div class="dropdown-divider"></div>
                   <a class="dropdown-item" href="do?command=crudlistofpurchases">CRUD list of purchases</a>
                   <div class="dropdown-divider"></div>
                   <a class="dropdown-item" href="do?command=crudroles">CRUD roles</a>
                   <div class="dropdown-divider"></div>
                   <a class="dropdown-item" href="do?command=crudusers">CRUD users</a>
                   <div class="dropdown-divider"></div>
              </div>
         </div>
    </c:if>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">

            <!--
                <li class="nav-item active">
                    <a class="nav-link" href="do?command=Catalog">Catalog<span class="sr-only">(current)</span></a>
                </li>
            -->

        </ul>
    </div>


    <ul class="navbar-nav navbar-right">
        <c:choose>
            <c:when test="${user!=null}">
                <li class="nav-item active">
                    <a class="nav-link" href="do?command=Profile" style="color:#FF0000">
                    <b>${user.login}</b>
                    <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="do?command=Basket">Basket<span class="sr-only">(current)</span></a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="nav-item active">
                    <a class="nav-link" href="do?command=Login">Login <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="do?command=SignUp">SignUp <span class="sr-only">(current)</span></a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

