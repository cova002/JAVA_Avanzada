<%-- 
    Document   : triangulo
    Created on : 17 feb. 2022, 00:35:13
    Author     : braya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Area" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Triangulo</title>
    </head>
    <body>
       
        <%
            String base=request.getParameter("base");
            String altura=request.getParameter("altura");
        
            Area a= (Area)new Area(base,altura);
            a.calcularArea();
            a.calcularPerimetro();
            
        %>
        
         <h1>Los resultados son:</h1><br>
       <h2>Area</h2>
         <%=a.getResultado()%><br><br>
         <h2>Perimetro</h2>
         <%=a.getResultado2()%>
    </body>
</html>
