package net.codejava.services;

import net.codejava.entity.Product;
import java.util.List;
import net.codejava.entity.Imc;
import net.codejava.entity.Usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.repositories.UsuarioRepository;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
@Transactional
public class UsuarioService {
  private JdbcTemplate jt;
	@Autowired
	private UsuarioRepository repo;
	
	
	public void save(Usuario usuario) {
		repo.save(usuario);
	}
	
	public Usuario get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
        
      public List usp_login(String user, String pass) {
        List lista = jt.queryForList("usuario ?,?", user, pass);
        return lista;
    }
      public List<Usuario> listAllUsers() {
	return repo.findAll();
	}
}
