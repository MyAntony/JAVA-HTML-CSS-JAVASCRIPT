package com.example.aula4.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tabela_endereco")
public class Endereco
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Logradouro é obrigatório")
    private String logradouro;

    @NotBlank(message = "Número é obrigatório")
    private String numero;

    @NotBlank(message = "Complemento é obrigatório")
    private String complemento;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;

    @NotBlank(message = "UF é obrigatório")
    private String uf;

    public Endereco()
    {
        
    }

    public Endereco(Long id, @NotBlank(message = "Logradouro é obrigatório") String logradouro,
    @NotBlank(message = "Número é obrigatório") String numero,
    @NotBlank(message = "Complemento é obrigatório") String complemento,
    @NotBlank(message = "CEP é obrigatório") String cep,
    @NotBlank(message = "Cidade é obrigatório") String cidade,
    @NotBlank(message = "UF é obrigatório") String uf)
    {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getComplemento()
    {
        return complemento;
    }

    public void setComplemento(String complemento)
    {
        this.complemento = complemento;
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        this.cep = cep;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public String getUf()
    {
        return uf;
    }

    public void setUf(String uf)
    {
        this.uf = uf;
    }

    @Override
    public String toString()
    {
        return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
        + complemento + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + "]";
    }

    
}
