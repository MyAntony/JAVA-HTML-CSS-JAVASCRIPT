package com.example.aula4.controller;

import com.example.aula4.model.Paciente;
import com.example.aula4.service.PacienteService;

import jakarta.validation.Valid;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Aceita conexões de aplicações externas
@RestController
@RequestMapping("/pacientes")
public class PacienteController
{
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService)
    {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listarTodos()
    {
        return pacienteService.listarTodos();
    }

    // @PostMapping
    // public ResponseEntity<String> salvar(@Valid @RequestBody Usuario usuario)
    // {
    //     usuarioService.salvar(usuario);
    //     String mensagem = "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
    //     return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    // }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Paciente paciente)
    {
        pacienteService.salvar(paciente);
        String mensagem = "Paciente " + paciente.getEmail() + " cadastrado com sucesso!";
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", mensagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Paciente paciente)
    {
        pacienteService.atualizar(paciente);
        String mensagem = "Usuário " + paciente.getEmail() + " atualizado com sucesso!";
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", mensagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id)
    {
        pacienteService.excluir(id);
        // return ResponseEntity.noContent().build();
        String mensagem = "Paciente deletado com sucesso!";
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", mensagem));
    }
}