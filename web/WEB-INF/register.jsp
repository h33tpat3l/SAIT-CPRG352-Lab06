<%-- 
    Document   : register
    Created on : 24-Jun-2022, 4:26:50 PM
    Author     : heetk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="shopping?action=register">
            <label>Username: </label>
            <input type="text" name="username">
            <input type="submit" name="submit" value="Register Name">
        </form>
        <p>${message}</p>
    </body>
</html>
