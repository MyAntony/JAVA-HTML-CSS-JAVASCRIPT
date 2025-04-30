package com.example.aula4.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.example.aula4.model.Funcionario;
import com.example.aula4.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class FuncionarioService
{
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository)
    {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos()
    {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario)
    {
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent())
        {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario)
    {
        Funcionario funcionarioAtualizar = funcionarioRepository.findByEmail(funcionario.getEmail()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setRg(funcionario.getRg());
        funcionarioAtualizar.setMatricula(funcionario.getMatricula());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setTelefone(funcionario.getTelefone());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setSenha(funcionario.getSenha());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void excluir(String email)
    {
        Funcionario funcionario = funcionarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));

        funcionarioRepository.deleteById(funcionario.getId());
    }
}
