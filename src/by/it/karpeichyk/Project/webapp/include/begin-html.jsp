<%@ page language="java" pageEncoding="UTF-8" %>


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>СТЕНА ОБЪЯВЛЕНИЙ</title>
  </head>
  <body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">НАВИГАЦИЯ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">

        <li class="nav-item active">
          <a class="nav-link" href=".">Домой <span class="sr-only">(current)</span></a>
        </li>
        <li>
          <a href=do?command=CreateAd>Создать Объявление</a>
        </li>

        <li>
          <a href=do?command=ListAd>Список Объявлений</a>
        </li>
      </ul>
                 <li> <a href=do?command=Login>Логин</a></li>
                 <li> <a href=do?command=SignUp>Регистрация</a></li>
                 <li> <a href=do?command=Logout>Выход</a></li>
  </nav>





