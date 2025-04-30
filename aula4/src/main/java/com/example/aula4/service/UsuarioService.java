package com.example.aula4.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.aula4.model.Usuario;
import com.example.aula4.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class UsuarioService
{
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos()
    {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario)
    {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
        {
            throw new RuntimeException("Usuário já cadastrado!");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(@Valid Usuario usuario)
    {
        Usuario usuarioAtualizar = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        // usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setEmail(usuario.getEmail());
        usuarioAtualizar.setSenha(usuario.getSenha());

        return usuarioRepository.save(usuarioAtualizar);
    }

    public void excluir(Long id)
    {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuarioRepository.deleteById(usuario.getId());
    }
}
