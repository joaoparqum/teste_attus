package com.api.gerencia.service;

import com.api.gerencia.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface IPessoaService {

    public Pessoa save(Pessoa pessoa);
    public List<Pessoa> findAll();
    public Optional<Pessoa> findById(Long id);
    public void delete(Pessoa pessoa);

}
