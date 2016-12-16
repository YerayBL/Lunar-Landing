<%-- 
    Document   : index
    Created on : 12-dic-2016, 11:05:17
    Author     : yeray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login/Registro</title>
    </head>
    <body>
        <div class="form">
             <%
                if (request.getAttribute("errorMessage") != null) {
                    out.println("<p class='error-message'>" + request.getAttribute("errorMessage") + "</p>");
                }
            %>
            <form action="ServletLogin" method="POST">
                <h1>LOGIN</h1>
                <p>Usuario: <input class="user" type="text" name="user"/></p> 
                <p>Contraseña: <input class="pass" type="password" name="pass"/></p>
                <input class="submit" type="submit" value="Submit"/>
            </form>
        </div>

            
        <div class="form">
            <%
                if (request.getAttribute("errorMessage") != null) {
                    out.println("<p class='error-message'>" + request.getAttribute("errorMessage") + "</p>");
                }
            %>
            <form method="POST" action="ServletRegister">
                <h1>REGISTRO</h1>
                <p>Usuario:<input class="user" type="text" name="user"/></p> 
                <p>Contraseña: <input  class="pass" type="password" name="pass"/></p>
                <p>Repetir Contraseña: <input class="pass2" type="password" name="pass2"/></p>
                <input class="submit" type="submit" value="Aceptar"/>
            </form>
        </div>
    </body>
</html>
