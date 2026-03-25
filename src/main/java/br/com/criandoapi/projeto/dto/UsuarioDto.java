package br.com.criandoapi.projeto.dto;


import lombok.Data;

@Data
public class UsuarioDto {
    private String email;
    private String senha;

    public UsuarioDto(String senha, String email) {
        this.email = email;
        this.senha = senha;
    }
}
