package com.example.aula4.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
    private String cpf;

    @NotBlank(message = "RG é obrigatório")
    @Size(min = 7, max = 7, message = "O RG deve ter 7 dígitos")
    private String rg;

    @NotBlank(message = "Matrícula é obrigatória")
    @Size(min = 6, max = 6, message = "A matrícula deve ter 6 dígitos")
    private String matricula;

    @NotBlank(message = "Data de Nascimento é obrigatório")
    @Size(min = 10, max = 10, message = "A data de nascimento deve ter o formato dd/MM/yyyy")
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres")
    private String senha;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    // @NotNull(message = "Salário é obrigatório")
    // @NotBlank(message = "Salário é obrigatório")
    private double salario;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 10, max = 12, message = "O telefone deve ter entre 10 e 12 dígitos")
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Funcionario()
    {
        
    }

    public Funcionario(Long id, @NotBlank(message = "Nome é obrigatório") String nome,
    @NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos") String cpf,
    @NotBlank(message = "RG é obrigatório") @Size(min = 7, max = 7, message = "O RG deve ter 7 dígitos") String rg,
    @NotBlank(message = "Matrícula é obrigatória") @Size(min = 6, max = 6, message = "A matrícula deve ter 6 dígitos") String matricula,
    @NotBlank(message = "Data de Nascimento é obrigatório") @Size(min = 10, max = 10, message = "A data de nascimento deve ter o formato dd/MM/yyyy") String dataNascimento,
    @NotBlank(message = "Sexo é obrigatório") Sexo sexo,
    @NotBlank(message = "Email é obrigatório") @Email(message = "Informe um e-mail válido") String email,
    @NotBlank(message = "A senha é obrigatória") @Size(min = 3, message = "A senha deve ter no mínimo 3 caracteres") String senha,
    Setor setor, @NotBlank(message = "Salário é obrigatório") double salario,
    @NotBlank(message = "Telefone é obrigatório") @Size(min = 10, max = 12, message = "O telefone deve ter entre 10 e 12 dígitos") String telefone,
    Endereco endereco)
    {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}