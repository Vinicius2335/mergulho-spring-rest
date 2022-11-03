package com.viniciusvieira.algalog.api.representation.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioRequestBody {
	@NotBlank
	private String nome;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String bairro;
}
