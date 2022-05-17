<%-- 
    Document   : datos
    Created on : 29 abr. 2022, 14:32:44
    Author     : braya
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actividad 8</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>  

        <%
            if (request.getAttribute("flag")!=null) {
                out.print("<h1>Inserte un número mayor a 0 </h1>");
            } else {
                Cookie ck[] = request.getCookies();               
                    if (ck != null) {
                        for (int i = 0; i < ck.length; i++) {
                            if ((ck[i].getName().equals("base"))) {
                                out.print("");
                                out.println("La base anterior fue: " + ck[i].getValue() + "<br>");
                            }
                            if ((ck[i].getName().equals("altura"))) {
                                out.print("");
                                out.println(" La altura anterior fue: " + ck[i].getValue() + "<br>");
                            }
                            if ((ck[i].getName().equals("areaR"))) {
                                out.print("");
                                out.println(" El area anterior fue: " + ck[i].getValue() + "<br>");
                            }
                            if ((ck[i].getName().equals("perR"))) {
                                out.print("");
                                out.println(" El perimetro anterior fue: " + ck[i].getValue() + "<br>");
                            }
                        }
                    }

                    HttpSession sesion = request.getSession(false);
                    Enumeration e = sesion.getAttributeNames();
                    if (e.hasMoreElements()) {
                        out.print("<br>");
                        out.print("Bienvenido ");
                        out.print(sesion.getAttribute("nombre"));
                    }
                }           
        %>

        <div> 
            <h1>Área y perímetro de un triángulo</h1><br>
            <form action="ejecutar.do" method="POST">
                Nombre:<input type="text" name="nombre" value="" /><br><br>
                Base:<input type="number" name="base" value="" /><br><br>
                Altura:<input type="text" name="altura" value="" /><br><br>
                Lado 1:<input type="number" name="lado1" value="" /><br><br>
                Lado 2:<input type="number" name="lado2" value="" /><br><br>
                Lado 3:<input type="number" name="lado3" value="" /><br><br>
                <input type="submit" value="Calcular" />
            </form>
        </div>
    </body>
</html>
