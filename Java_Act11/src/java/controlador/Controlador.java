/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author COVA
 */

@Controller
public class Controlador {
   @RequestMapping("sumar")
    public ModelAndView resultados( @RequestParam("txtNum1") String num1,@RequestParam("txtNum2") String num2)throws ServletException, IOException {
        double Num1 = Integer.parseInt (num1);
        double Num2 = Integer.parseInt (num2);
        ModelAndView modelo = new ModelAndView();
     double resultado= Num1 + Num2;
           return new ModelAndView("WEB-INF/jsp/resultadoSuma.jsp","res", resultado);
    }   
}
