package com.viniciusvieira.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viniciusvieira.algalog.domain.model.Entrega;
import com.viniciusvieira.algalog.domain.model.Ocorrencia;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroOcorrenciaService {
	private final BuscaEntregaService entregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
