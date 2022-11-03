package com.viniciusvieira.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusvieira.algalog.api.mapper.OcorrenciaMapper;
import com.viniciusvieira.algalog.api.representation.model.OcorrenciaDto;
import com.viniciusvieira.algalog.api.representation.request.OcorrenciaRequestBody;
import com.viniciusvieira.algalog.domain.model.Entrega;
import com.viniciusvieira.algalog.domain.model.Ocorrencia;
import com.viniciusvieira.algalog.domain.service.BuscaEntregaService;
import com.viniciusvieira.algalog.domain.service.RegistroOcorrenciaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {
	private final RegistroOcorrenciaService registroOcorrenciaService;
	private final OcorrenciaMapper ocorrenciaMapper;
	private final BuscaEntregaService buscaEntregaService; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDto registrar(@PathVariable Long entregaId, @RequestBody @Valid OcorrenciaRequestBody 
			ocorrencia) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrencia.getDescricao());
		return ocorrenciaMapper.toOcorrenciaDto(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaDto> buscar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaMapper.toCollectionOcorrenciaDto(entrega.getOcorrencias());
	}
	
}
