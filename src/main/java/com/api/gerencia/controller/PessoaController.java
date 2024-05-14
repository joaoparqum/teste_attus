package com.api.gerencia.controller;

import com.api.gerencia.dto.PessoaDTO;
import com.api.gerencia.model.Pessoa;
import com.api.gerencia.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoas")
public class PessoaController implements IPessoaController{

    final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> savePessoa(@RequestBody @Valid PessoaDTO pessoaDto){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoa(){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") Long id){
        Optional<Pessoa> tarefaOptional = pessoaService.findById(id);
        if (!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }
        pessoaService.delete(tarefaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid PessoaDTO pessoaDto){
        Optional<Pessoa> tarefaOptional = pessoaService.findById(id);
        if (!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        pessoa.setId(tarefaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }

}
