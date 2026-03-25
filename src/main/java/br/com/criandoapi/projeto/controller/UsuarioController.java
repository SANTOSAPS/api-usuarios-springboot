package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.dto.UsuarioDto;
import br.com.criandoapi.projeto.dto.UsuarioResponse;
import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity <List<Usuario>> listaUsuario (){
        return ResponseEntity.status(200).body(usuarioService.listarUsuario());
    }

    @PostMapping
    public ResponseEntity <Usuario> criarUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
    }

    @DeleteMapping ("/{id}")
    public  ResponseEntity <?> excluirUsuario (@PathVariable int id){
        usuarioService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping ("/login")
    public ResponseEntity<Token> logar(@Valid @RequestBody UsuarioDto usuario) {
        Token token = usuarioService.gerarToken(usuario);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handValidationException (MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fielName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fielName, errorMessage);

        });

        return errors;
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponse> usuarioLogado() {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Usuario usuario = usuarioService.buscarPorEmail(email);

        UsuarioResponse response = new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone()
        );

        return ResponseEntity.ok(response);
    }

}
