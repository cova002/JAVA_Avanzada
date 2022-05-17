<%-- 
    Document   : datos
    Created on : 29 abr. 2022, 12:06:24
    Author     : braya
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>

        <%
                out.print("");
                String area = (String) request.getAttribute("datos1");
                out.println(" <h1> Área del triangulo: " + area);
                
                out.print("");
                String perimetro = (String) request.getAttribute("datos2");
                out.println(" <h1> Perimetro del triangulo: " + perimetro);
                out.print("<br>");
        %>
        <br><br><br><br>
        <a href="index.jsp"> Realizar otro cálculo</a>
    </body>
</html>
