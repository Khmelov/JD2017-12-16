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
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="do?command=Home">Bonjo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="do?command=Home">Home <span class="sr-only">(current)</span></a>
                </li>
                <c:if test="${user!=null && user.roles_ID==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=EditUsers">EditUsers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="do?command=ResetDB">ResetDB</a>
                    </li>
                </c:if>
                <c:if test="${user!=null && user.roles_ID==2}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=CreateAd">Create Ad <span class="sr-only">(current)</span></a>
                </li>
                </c:if>
                <c:if test="${user!=null && user.roles_ID==2}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=MyAds">My Ads <span class="sr-only">(current)</span></a>
                </li>
                </c:if>
            </ul>
            <ul class="navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${user==null}">
                        <li class="nav-item active">
                            <a class="nav-link" href="do?command=Login">Login <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="do?command=SignUp">SignUp <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item active">
                            <a class="nav-link" href="do?command=Profile">Profile <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="do?command=Logout">Logout <span class="sr-only">(current)</span></a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </nav>
</div>