<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login" >
            <label>Username</label>
            <input type="text" name="username" value="">
            <br>
            <label>Password</label>
            <input type="password" name="password" value="">
            <br>
            <input type="Submit" name="login" value="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
