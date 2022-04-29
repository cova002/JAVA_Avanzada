package net.codejava.services;

import java.util.List;
import net.codejava.entity.Persona;
import net.codejava.repositories.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

	@Autowired
	private PersonaRepository repo;
	
	public List<Persona> listAll() {
		return repo.findAll();
	}
	
	public void save(Persona product) {
		repo.save(product);
	}
	
	public Persona get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
         public Persona updateEmployee(Long empId, Persona employeeDetails) {
        Persona emp = repo.findById(empId).get();
        emp.setNombre(employeeDetails.getNombre());
        emp.setApellido(employeeDetails.getApellido());
        emp.setEdad(employeeDetails.getEdad());
        
        return repo.save(emp);                                
}
}
