package com.viniciusvieira.algalog.api.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.viniciusvieira.algalog.api.representation.model.OcorrenciaDto;
import com.viniciusvieira.algalog.domain.model.Ocorrencia;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OcorrenciaMapper {
	private final ModelMapper modelMapper;
	
	public OcorrenciaDto toOcorrenciaDto(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDto.class);
	}
	
	public List<OcorrenciaDto> toCollectionOcorrenciaDto(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream()
				.map(this::toOcorrenciaDto)
				.toList();
	}
}
