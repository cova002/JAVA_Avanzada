/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.triangulo;

/**
 *
 * @author braya
 */
public class procesar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {

            if (request.getAttribute("flag")!=null) {

                request.setAttribute("flag", 1);
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } else {

                String base = request.getParameter("base");
                String altura = request.getParameter("altura");
                String lado1 = request.getParameter("lado1");
                String lado2 = request.getParameter("lado2");
                String lado3 = request.getParameter("lado3");
                String nombre = request.getParameter("nombre");

                int baseT = Integer.parseInt(base);
                int alturaT = Integer.parseInt(altura);
                int lado11 = Integer.parseInt(lado1);
                int lado22 = Integer.parseInt(lado2);
                int lado33 = Integer.parseInt(lado3);

                triangulo tri = new triangulo();
                Cookie ck = new Cookie("base", base + "");
                response.addCookie(ck);
                ck = new Cookie("altura", altura + "");
                response.addCookie(ck);

                String areaR = Integer.toString(tri.Area(baseT, alturaT));
                String perR = Integer.toString(tri.Perimetro(lado11, lado22, lado33));
                ck = new Cookie("areaR", areaR + "");
                response.addCookie(ck);
                ck = new Cookie("perR", perR + "");
                response.addCookie(ck);

                HttpSession sesion = request.getSession(false);
                sesion.setAttribute("nombre", nombre);
                request.setAttribute("datos1", areaR);
                request.setAttribute("datos2", perR);
                request.getRequestDispatcher("datos.jsp").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
