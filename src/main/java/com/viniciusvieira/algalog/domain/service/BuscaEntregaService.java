package com.viniciusvieira.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.viniciusvieira.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.viniciusvieira.algalog.domain.model.Entrega;
import com.viniciusvieira.algalog.domain.repository.EntregaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuscaEntregaService {
	private final EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
