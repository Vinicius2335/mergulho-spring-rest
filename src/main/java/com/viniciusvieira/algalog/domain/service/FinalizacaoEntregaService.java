package com.viniciusvieira.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viniciusvieira.algalog.domain.model.Entrega;
import com.viniciusvieira.algalog.domain.repository.EntregaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinalizacaoEntregaService {
	private final BuscaEntregaService buscaEntregaService;
	private final EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long entreId) {
		Entrega entrega = buscaEntregaService.buscar(entreId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
}
