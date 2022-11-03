package com.viniciusvieira.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusvieira.algalog.domain.model.Cliente;
import com.viniciusvieira.algalog.domain.repository.ClienteRepository;
import com.viniciusvieira.algalog.domain.service.CatalogoClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteRepository clienteRepository;
	private final CatalogoClienteService clienteService;
	
//	@PersistenceContext
//	private EntityManager manager;
//	
//	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//	public List<Cliente> listar() {
//		return manager.createQuery("from Cliente", Cliente.class)
//				.getResultList();
//	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/listar")
	public List<Cliente> listarByNome() {
		return clienteRepository.findByNomeContaining("j");
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody @Valid Cliente cliente){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			cliente.setId(clienteId);
			return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
		}
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			clienteService.excluir(clienteId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
}
