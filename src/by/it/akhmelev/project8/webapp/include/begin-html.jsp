<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS (from site) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello JSP!</title>
</head>
<body>
<div class="container" >
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href=".">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <mytag:menu command="CreateAd" text="CreateAd"/>
                <mytag:menu command="ResetDB" text="ResetDB"/>
                <c:if test="${user!=null && user.fk_roles==1}">
                    <mytag:menu command="EditUsers" text="EditUsers"/>
                </c:if>
            </ul>
        </div>
        <ul class="navbar-nav navbar-right">
            <c:choose>
                <c:when test="${user==null}">
                    <mytag:menu command="Login" text="Login"/>
                    <mytag:menu command="SignUp" text="SignUp"/>
                </c:when>
                <c:otherwise>
                    <mytag:menu command="Profile" text="Profile"/>
                    <mytag:menu command="Logout" text="Logout"/>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>

