package com.viniciusvieira.algalog.api.representation.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OcorrenciaRequestBody {
	@NotBlank
	private String descricao;
}
