package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.UsuarioService;

import net.codejava.entity.Formulario;
import net.codejava.entity.Imc;
import net.codejava.services.ImcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.codejava.entity.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AppController {

    @Autowired
    private UsuarioService service;
    @Autowired
    private ImcService imcService;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
            List<Imc> listImc = imcService.listAllImc();
            model.addAttribute("listImc", listImc);
            return "index";
        } else {
            model.addAttribute("formulario", new Usuario());
            return "login";
        }
        //model.addAttribute("listProducts", listProducts);
    }

    @RequestMapping("/loguear")
    public String login(HttpSession session, @ModelAttribute("formulario") Usuario usuario) {
        String user=usuario.getNameuser();
        String pass=usuario.getPassword();
         //List lista1 = service.usp_login(user, pass);
        //if (lista1.size() > 0) {
        session.setAttribute("mySessionAttribute", "Sesión iniciada");
        return "redirect:/";
        //}
       // else{
         //   return "error_login";
       // }
        
    }
@RequestMapping("/new_imc")
    public String newImc(Model model) {
        Imc imc = new Imc();
        model.addAttribute("imc", imc);

        return "new_imc";
    }
   @RequestMapping("/registro")
    public String newUser(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "registro";
    }    
@RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
        service.save(usuario);
        return "redirect:/";
    }
   
    @RequestMapping(value = "/save_imc", method = RequestMethod.POST)
    public String saveImc(@ModelAttribute("imc") Imc imc) {
        double estatura=imc.getEstatura();
        double peso=imc.getPeso();
        double calculo=peso/(estatura*estatura);
        imc.setImc(calculo);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       
        imc.setFecha(dtf.format(LocalDateTime.now()));  
        imcService.save(imc);
        return "redirect:/";
    }
    //@RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
       // ModelAndView mav = new ModelAndView("edit_product");
        //Usuario usuario = service.get(id);
        //mav.addObject("product", usuario);

        return null;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
