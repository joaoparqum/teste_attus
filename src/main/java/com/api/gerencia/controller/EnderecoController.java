package com.api.gerencia.controller;

import com.api.gerencia.dto.EnderecoDTO;
import com.api.gerencia.model.Endereco;
import com.api.gerencia.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoas/enderecos")
public class EnderecoController implements IEnderecoController{

    final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> saveEndereco(@RequestBody @Valid EnderecoDTO enderecoDto){
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEndereco(){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEndereco(@PathVariable(value = "id") Long id){
        Optional<Endereco> tarefaOptional = enderecoService.findById(id);
        if (!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrada!");
        }
        enderecoService.delete(tarefaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletada com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid EnderecoDTO enderecoDto){
        Optional<Endereco> tarefaOptional = enderecoService.findById(id);
        if (!tarefaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrada!");
        }
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
        endereco.setId(tarefaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }
}
