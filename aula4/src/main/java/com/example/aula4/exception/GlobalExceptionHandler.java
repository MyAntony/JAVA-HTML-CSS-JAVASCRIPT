package com.example.aula4.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    // Aqui você pode adicionar métodos para tratar exceções específicas
    // e retornar respostas personalizadas para o cliente.
    // Por exemplo, você pode usar @ExceptionHandler para capturar exceções específicas.

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRuntimeException(RuntimeException erro)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", erro.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensagem", "Recurso não encontrado!"));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensagem", "Recurso não encontrado!"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpMessageNotReadableException(HttpMessageNotReadableException erro)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", "Insira dados válidos!"));
    }
}
