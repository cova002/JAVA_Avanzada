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
	
	public Persona get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
