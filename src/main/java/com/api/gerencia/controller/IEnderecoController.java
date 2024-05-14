package com.api.gerencia.controller;

import com.api.gerencia.dto.EnderecoDTO;
import com.api.gerencia.model.Endereco;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEnderecoController {

    public ResponseEntity<Object> saveEndereco(@RequestBody @Valid EnderecoDTO enderecoDto);
    public ResponseEntity<List<Endereco>> getAllEndereco();
    public ResponseEntity<Object> deleteEndereco(@PathVariable(value = "id") Long id);
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid EnderecoDTO enderecoDto);

}
