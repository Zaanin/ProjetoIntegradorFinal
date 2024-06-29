package proBarber.proBarber.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proBarber.proBarber.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
