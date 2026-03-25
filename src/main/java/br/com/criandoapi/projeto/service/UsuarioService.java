package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.dto.UsuarioDto;
import br.com.criandoapi.projeto.repository.UsuarioRepository;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.security.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService (UsuarioRepository repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List <Usuario> listarUsuario(){
        return repository.findAll();
    }

    public Usuario criarUsuario (Usuario usuario) {
        String encoder =  this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return repository.save(usuario);
    }

    public Usuario editarUsuario (Usuario usuario) {
        String encoder =  this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return repository.save(usuario);
    }

    public Boolean excluirUsuario (Integer id){
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        return passwordEncoder.matches(usuario.getSenha(), senha);
    }

    public Token gerarToken(@Valid UsuarioDto usuario) {

        Usuario user = repository.findByEmail(usuario.getEmail());

        if (user == null) {
            return null;
        }

        if (!passwordEncoder.matches(usuario.getSenha(), user.getSenha())) {
            return null;
        }

        String token = TokenUtil.createToken(user);

        return new Token(token);
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}


