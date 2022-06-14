<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <p>Hello ${username}</p>

        
                <form method="get" action="login">
            <input type="submit" value="Log out">
            <input type="hidden" name="operation" value="logout"> 
    </form>
    </body>
</html>
