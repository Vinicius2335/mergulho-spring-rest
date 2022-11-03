package com.viniciusvieira.algalog.api.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.viniciusvieira.algalog.api.representation.model.EntregaDto;
import com.viniciusvieira.algalog.api.representation.request.EntregaRequestBody;
import com.viniciusvieira.algalog.domain.model.Entrega;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EntregaMapper {
	private final ModelMapper modelMapper;
	
	public EntregaDto toEntregaDto(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDto.class);
	}
	
	public List<EntregaDto> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toEntregaDto)
				.toList();
	}
	
	public Entrega toEntregaDomain(EntregaRequestBody entregaRequestBody) {
		return modelMapper.map(entregaRequestBody, Entrega.class);
	}
}
