package com.api.gerencia.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PessoaDTO {

    @NotBlank
    private String nome;
    private Date dataNascimento;
    @NotBlank
    private List<EnderecoDTO> enderecos;


}
