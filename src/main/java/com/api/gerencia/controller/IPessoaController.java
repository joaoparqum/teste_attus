package com.api.gerencia.controller;

import com.api.gerencia.dto.PessoaDTO;
import com.api.gerencia.model.Pessoa;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPessoaController {

    public ResponseEntity<Object> savePessoa(@RequestBody @Valid PessoaDTO pessoaDto);
    public ResponseEntity<List<Pessoa>> getAllPessoa();
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") Long id);
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid PessoaDTO pessoaDto);

}
