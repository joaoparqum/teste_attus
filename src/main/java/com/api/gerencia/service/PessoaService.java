package com.api.gerencia.service;

import com.api.gerencia.model.Endereco;
import com.api.gerencia.model.Pessoa;
import com.api.gerencia.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements IPessoaService{

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        //Indicando o endereço principal da pessoa
        Endereco enderecoPrincipal = null;
        for (Endereco endereco : pessoa.getEnderecos()) {
            if (endereco.isEnderecoPrincipal()) {
                enderecoPrincipal = endereco;
                break;
            }
        }

        //Definir o primeiro como principal
        if (enderecoPrincipal == null && !pessoa.getEnderecos().isEmpty()) {
            enderecoPrincipal = pessoa.getEnderecos().get(0);
            enderecoPrincipal.setEnderecoPrincipal(true);
        }

        //Removendo a marcação de endereço principal dos outros endereços
        for (Endereco endereco : pessoa.getEnderecos()) {
            if (endereco != enderecoPrincipal) {
                endereco.setEnderecoPrincipal(false);
            }
        }
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void delete(Pessoa pessoa){
        pessoaRepository.delete(pessoa);
    }


}
