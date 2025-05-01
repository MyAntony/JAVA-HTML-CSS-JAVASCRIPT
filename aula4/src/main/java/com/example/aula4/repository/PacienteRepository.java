package com.example.aula4.repository;

// import java.lang.classfile.ClassFile.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula4.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>
{
    Optional<Paciente> findByEmail(String email);
}