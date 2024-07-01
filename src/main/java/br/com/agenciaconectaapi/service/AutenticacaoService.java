package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.UsuarioDto;
import br.com.agenciaconectaapi.model.Usuario;
import br.com.agenciaconectaapi.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    public AutenticacaoService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLogin(login);
    }

    public UsuarioDto criarUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario(usuarioDto);

        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        repository.save(usuario);

       return escondeCaracteresDaSenhaDoUsuarioDto(usuarioDto);
    }

    private UsuarioDto escondeCaracteresDaSenhaDoUsuarioDto(UsuarioDto usuarioDto){
        String senhaExposta = usuarioDto.senha();
        int tamanhoSenhaExposta = senhaExposta.length();

        StringBuilder senhaEscondida = new StringBuilder();

        for(int i = 0; i < tamanhoSenhaExposta; i++){
            senhaEscondida.append("*");
        }

        return new UsuarioDto(usuarioDto.login(), senhaEscondida.toString());
    }
}
