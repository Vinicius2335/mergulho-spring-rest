package com.viniciusvieira.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viniciusvieira.algalog.domain.exception.NegocioException;
import com.viniciusvieira.algalog.domain.model.Cliente;
import com.viniciusvieira.algalog.domain.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogoClienteService {
	private final ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteEncontrado -> !clienteEncontrado.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
}
