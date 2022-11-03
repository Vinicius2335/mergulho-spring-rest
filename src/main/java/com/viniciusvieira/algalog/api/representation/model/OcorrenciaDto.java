package com.viniciusvieira.algalog.api.representation.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaDto {
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
