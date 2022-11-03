package com.viniciusvieira.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viniciusvieira.algalog.domain.model.Cliente;
import com.viniciusvieira.algalog.domain.model.Entrega;
import com.viniciusvieira.algalog.domain.model.StatusEntrega;
import com.viniciusvieira.algalog.domain.repository.EntregaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitacaoEntregaService {
	private final EntregaRepository entregaRepository;
	private final CatalogoClienteService clienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
