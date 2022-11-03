package com.viniciusvieira.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusvieira.algalog.api.mapper.EntregaMapper;
import com.viniciusvieira.algalog.api.representation.model.EntregaDto;
import com.viniciusvieira.algalog.api.representation.request.EntregaRequestBody;
import com.viniciusvieira.algalog.domain.model.Entrega;
import com.viniciusvieira.algalog.domain.repository.EntregaRepository;
import com.viniciusvieira.algalog.domain.service.FinalizacaoEntregaService;
import com.viniciusvieira.algalog.domain.service.SolicitacaoEntregaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/entregas")
@RequiredArgsConstructor
public class EntregaController {
	private final SolicitacaoEntregaService entregaService;
	private final EntregaRepository entregaRepository;
	private final EntregaMapper entregaMapper;
	private final FinalizacaoEntregaService finalizacaoEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDto solicitar(@RequestBody @Valid EntregaRequestBody entregaRequestBody) {
		Entrega novaEntrega = entregaMapper.toEntregaDomain(entregaRequestBody);
		return entregaMapper.toEntregaDto(entregaService.solicitar(novaEntrega));
	}
	
	@GetMapping
	public List<EntregaDto> listar(){
		return entregaMapper.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDto> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaMapper.toEntregaDto(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}

}
