package com.viniciusvieira.algalog.api.representation.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.viniciusvieira.algalog.domain.model.StatusEntrega;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntregaDto {
	
	private Long id;
	private String nomeCliente;
	private DestinatarioDto destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
}
