package com.example.aula4.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Paciente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres")
    private String senha;

    public Paciente()
    {
        
    }

    public Long getId()
    {
        return id;
    }

    public Paciente(Long id, @NotBlank(message = "Nome é obrigatório") String nome, @NotBlank(message = "Telefone é obrigatório") String telefone, @NotBlank(message = "Email é obrigatório") @Email(message = "Informe um e-mail válido") String email, @NotBlank(message = "A senha é obrigatória") @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres") String senha)
    {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }
}
