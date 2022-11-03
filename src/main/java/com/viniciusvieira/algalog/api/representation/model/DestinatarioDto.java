package com.viniciusvieira.algalog.api.representation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DestinatarioDto {
	
	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
}
