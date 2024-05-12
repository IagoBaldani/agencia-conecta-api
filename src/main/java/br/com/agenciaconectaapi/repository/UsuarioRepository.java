package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    UserDetails findByLogin(String login);
}
