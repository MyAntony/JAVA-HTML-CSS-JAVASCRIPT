package com.example.aula4.model;

// import jakarta.annotation.Generated;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// import jakarta.validation.constraints.*;

@Entity
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    // @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres")
    private String senha;

    // @Enumerated(EnumType.STRING)
    // private Sexo sexo;

    // @OneToOne(cascade = CascadeType.ALL)
    // private Endereco endereco;

    public Usuario()
    {
        
    }

    // public Usuario(Long id, @NotBlank(message = "Nome é obrigatório") String nome,
    // @NotBlank(message = "Email é obrigatório") @Email(message = "Informe um e-mail válido") String email,
    // @NotBlank(message = "A senha é obrigatória") @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres") String senha,
    // Sexo sexo, Endereco endereco)
    // {
    //     this.id = id;
    //     this.nome = nome;
    //     this.email = email;
    //     this.senha = senha;
    //     this.sexo = sexo;
    //     this.endereco = endereco;
    // }

    

    public Long getId()
    {
        return id;
    }

    public Usuario(Long id, @NotBlank(message = "Nome é obrigatório") String nome, @NotBlank(message = "Email é obrigatório") /*@Email(message = "Informe um e-mail válido")*/ String email, @NotBlank(message = "A senha é obrigatória") @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres") String senha)
    {
        this.id = id;
        this.nome = nome;
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

    // public Sexo getSexo()
    // {
    //     return sexo;
    // }

    // public void setSexo(Sexo sexo)
    // {
    //     this.sexo = sexo;
    // }

    // public Endereco getEndereco()
    // {
    //     return endereco;
    // }

    // public void setEndereco(Endereco endereco)
    // {
    //     this.endereco = endereco;
    // }

    // @Override
    // public String toString()
    // {
    //     return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", sexo=" + sexo + ", endereco=" + endereco + "]";
    // }
    
    
}
