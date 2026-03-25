package br.com.criandoapi.projeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size (min = 3, message = "O nom deve ter no mínimo 3 caracteres!")
    @NotBlank(message = "O nome é obrigatório!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email (message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;


}
