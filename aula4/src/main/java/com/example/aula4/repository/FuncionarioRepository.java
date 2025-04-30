package com.example.aula4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula4.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
    Optional<Funcionario> findByEmail(String email);
}
