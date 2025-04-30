package com.example.aula4.repository;

// import java.lang.classfile.ClassFile.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula4.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    Optional<Usuario> findByEmail(String email);
}