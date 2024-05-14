package com.api.gerencia.service;

import com.api.gerencia.model.Endereco;

import java.util.List;
import java.util.Optional;

public interface IEnderecoService {

    public Endereco save(Endereco endereco);
    public List<Endereco> findAll();
    public Optional<Endereco> findById(Long id);
    public void delete(Endereco endereco);

}
