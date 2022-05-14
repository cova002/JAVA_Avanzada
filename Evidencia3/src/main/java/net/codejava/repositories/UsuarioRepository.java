package net.codejava.repositories;

import java.util.Optional;
import net.codejava.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
