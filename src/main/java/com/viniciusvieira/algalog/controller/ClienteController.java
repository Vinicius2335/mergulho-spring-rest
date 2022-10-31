package com.viniciusvieira.algalog.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusvieira.algalog.domain.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Cliente> listar() {
		return List.of(
				Cliente.builder().id(1L).nome("João").email("Joao@email.com").telefone("1234-56789").build(),
				Cliente.builder().id(2L).nome("Maria").email("Maria@email.com").telefone("1111-99999").build()
		);
	}
}
