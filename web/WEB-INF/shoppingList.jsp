<%-- 
    Document   : shoppingList
    Created on : 24-Jun-2022, 4:39:29 PM
    Author     : heetk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="shopping?action=logout">
            <p>Hello ${userName} !</p>
            <input type="submit" name="submit" value="Log Out">
        </form>
            <h2> List</h2>
        <form method="post" action="shopping?action=add">
            <label>Add Item: </label>
            <input type="text" name="itemname">
            <input type="submit" name="submit" value="Add">
        </form>
        
        <c:if test="${items.size() > 0}">
            <form method="post" action="shopping?action=delete">
                <c:forEach items="${items}" var="item">
                    <input type="radio" id="${item.name}" name="itemlist" value="${item.name}" />
                    <label for="${item.name}">${item.name}</label><br>
                </c:forEach>
                <input type="submit" name="submit" value="Delete">
            </form>
        </c:if>
        
    </body>
</html>
