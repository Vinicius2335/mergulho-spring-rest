package com.viniciusvieira.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.viniciusvieira.algalog.domain.ValidationGroups;
import com.viniciusvieira.algalog.domain.exception.NegocioException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@ManyToOne
	@NotNull
	//@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	// quando queremos abstrair os dados de uma outra classe, porem mapear na tabela entrega,
	// é uma forma de fazer o bom uso da POO
	@Valid
	@NotNull
	@Embedded
	private Destinatario destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataPedido;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;

	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = Ocorrencia.builder()
				.descricao(descricao)
				.dataRegistro(OffsetDateTime.now())
				.entrega(this).build();
		
		this.getOcorrencias().add(ocorrencia);
		return ocorrencia;
	}

	public void finalizar() {
		boolean naoPodeSerFinalizada = !getStatus().equals(StatusEntrega.PENDENTE);
		
		if (naoPodeSerFinalizada) {
			throw new NegocioException("Entrega não pode ser finalizada");
		}
		
		setStatus(StatusEntrega.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
	}
	
}
