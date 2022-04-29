package net.codejava.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.entity.Persona;
import net.codejava.repositories.PersonaRepository;
import net.codejava.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class AppController {

    @Autowired
    private PersonaService Pservice;

    private final PersonaRepository repository;

  AppController(PersonaRepository repository) {
    this.repository = repository;
  }

    @RequestMapping("/")
    public String viewHomePage( Model model) {
            List<Persona> listProducts = Pservice.listAll();
            model.addAttribute("listaPersona", listProducts);
            return "index";
    }


    @RequestMapping("/new")
    public String showNewPersona(Model model) {
        Persona persona = new Persona();
        model.addAttribute("persona", persona);

        return "new_person";
    }

 
    @PutMapping("/edit_persona/{id}")
    Persona replaceEmployee(@RequestBody Persona newPersona, @PathVariable(name = "id") Long id) {
  
      return repository.findById(id)
        .map(employee -> {

          employee.setEdad(35);
          employee.setSexo("F");

          return repository.save(employee);
        })
        .orElseGet(() -> {
          return repository.save(newPersona);
        });
    }
    
    
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Persona> userById(@RequestParam(value = "id") Long id) {
        Persona persona  = Pservice.get(id);
         persona.setEdad(32);
         Pservice.save(persona);
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @GetMapping("/personas")
    public List<Persona> findAll(){
        //retornará todos los usuarios
        return Pservice.listAll();
    }
    
    
    
    
    
    @PostMapping("/add_persona")
    public Persona addUser(@RequestBody Persona persona) {
        persona.setNombre("Israel");
        persona.setApellido("Covarrubias");
        persona.setEdad(22);
        persona.setSexo("M");
        float estatura= (float) 1.83;
        float peso= 55;
        float IMC=peso/(estatura*estatura);
        persona.setImc(IMC);
        Pservice.save(persona);

        return persona;

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("persona") Persona persona) {     
        float estatura=persona.getEstatura();
        float peso=persona.getPeso();
        float IMC=peso/(estatura*estatura);
        persona.setImc(IMC);
        Pservice.save(persona);
        return "redirect:/";
    }
    

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPerson(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_persona");
        Persona persona = Pservice.get(id);
        mav.addObject("persona", persona);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        Pservice.delete(id);
        return "redirect:/";
    }
}
