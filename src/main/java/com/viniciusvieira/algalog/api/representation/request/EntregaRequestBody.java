package com.viniciusvieira.algalog.api.representation.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntregaRequestBody {
	
	@Valid
	@NotNull
	private ClienteIdRequestBody cliente;
	
	@Valid
	@NotNull
	private DestinatarioRequestBody destinatario;
	
	@NotNull
	private BigDecimal taxa;
}
