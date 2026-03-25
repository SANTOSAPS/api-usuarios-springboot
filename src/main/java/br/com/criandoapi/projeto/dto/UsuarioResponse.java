package br.com.criandoapi.projeto.dto;

import lombok.Data;

@Data
public class UsuarioResponse {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public UsuarioResponse(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}