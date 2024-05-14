package com.api.gerencia.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoDTO {

    @NotBlank
    private String logradouro;
    @NotBlank
    private String cep;
    @NotBlank
    private int numero;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;

}
