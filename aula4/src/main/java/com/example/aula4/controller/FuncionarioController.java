package com.example.aula4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.aula4.model.Funcionario;
import com.example.aula4.service.FuncionarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController
{
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService)
    {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos()
    {
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Funcionario funcionario)
    {
        funcionarioService.salvar(funcionario);
        String mensagem = "Funcionário " + funcionario.getNome() + " cadastrado com sucesso!";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario)
    {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok().body("Funcionário atualizado com sucesso!");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> excluir(@PathVariable String email)
    {
        funcionarioService.excluir(email);
        // return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body("Funcionário excluído com sucesso!");
    }
}
