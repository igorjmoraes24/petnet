package com.petnet.petnet.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Not found (HTTP 404)
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFound(NotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Recurso não encontrado");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    //Regras de Negocio (HTTP 400)
    @ExceptionHandler({RulesException.class, IllegalArgumentException.class})
    public ProblemDetail handleBusinessRule(RuntimeException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("Violação de regra de negócio");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    //Forbbiden (HTTP 403)
    @ExceptionHandler(ForbiddenException.class)
    public ProblemDetail handleForbidden(ForbiddenException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
        problem.setTitle("Access forbidden");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    //Conflito de dados(HTTP 409)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDatabaseIntegrity(DataIntegrityViolationException ex) {
        String mensagem = "Erro de integridade no banco de dados. Verifique chaves estrangeiras ou dados duplicados.";

        if (ex.getRootCause() != null && ex.getRootCause().getMessage() != null) {
            String causa = ex.getRootCause().getMessage();
            if (causa.contains("unique constraint")) {
                mensagem = "Já existe um registro cadastrado com esses dados únicos (E-mail, CNPJ ou Telefone).";
            } else if (causa.contains("foreign key constraint")) {
                mensagem = "O ID informado para o relacionamento não existe no banco de dados.";
            }
        }

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, mensagem);
        problem.setTitle("Conflito de dados");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    //Login (HTTP 401)
    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handleBadCredentials(BadCredentialsException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos.");
        problem.setTitle("Falha na autenticação");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    //Validação (HTTP 400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err ->
                erros.put(err.getField(), err.getDefaultMessage())
        );

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Um ou mais campos estão inválidos.");
        problem.setTitle("Erro de validação");
        problem.setProperty("campos", erros);
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }
}