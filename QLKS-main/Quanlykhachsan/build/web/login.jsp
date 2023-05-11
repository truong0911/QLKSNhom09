<%-- 
    Document   : login
    Created on : May 4, 2023, 10:15:45 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title><link rel="stylesheet" href="css/login.css">
    
</head>
<body>
    <div class="container">
        <div class="left">
          <div class="header">
            <h2 class="animation a1">Welcome Back</h2>
            <h4 class="animation a2">Log in to your account using username and password</h4>
          </div>
          <form action="login" method="post">
          <div class="form">          
            <input type="text" name="user" class="form-field animation a3" placeholder="User Name">
            <input type="password" name="pass" class="form-field animation a4" placeholder="Password">
            <button type="submit" class="animation a6"><a>LOGIN</a></button> 
          </div>
        </form>
        </div>
        <div class="right"></div>
      </div>
</body>
</html>

