package com.example.aula4.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.aula4.model.Paciente;
import com.example.aula4.repository.PacienteRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class PacienteService
{
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository)
    {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos()
    {
        return pacienteRepository.findAll();
    }

    public Paciente salvar(@Valid Paciente paciente)
    {
        if(pacienteRepository.findByEmail(paciente.getEmail()).isPresent())
        {
            throw new RuntimeException("Usuário já cadastrado!");
        }

        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar(@Valid Paciente paciente)
    {
        Paciente pacienteAtualizar = pacienteRepository.findByEmail(paciente.getEmail()).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        // usuarioAtualizar.setNome(usuario.getNome());
        pacienteAtualizar.setEmail(paciente.getEmail());
        pacienteAtualizar.setSenha(paciente.getSenha());

        return pacienteRepository.save(pacienteAtualizar);
    }

    public void excluir(Long id)
    {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        pacienteRepository.deleteById(paciente.getId());
    }
}
