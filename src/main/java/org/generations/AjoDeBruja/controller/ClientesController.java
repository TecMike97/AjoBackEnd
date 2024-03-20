package org.generations.AjoDeBruja.controller;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Clientes;
import org.generations.AjoDeBruja.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/clientes/") //http://localhost:8080/api/clientes/
public class ClientesController {
	private final ClientesService clientesService;// variable constante

	@Autowired
	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}// constructor

	// GET
	@GetMapping
	public ArrayList<Clientes> getClientes() {
		return clientesService.getAllClientes();
	}

	// GET
	@GetMapping(path = "{clienteId}") // http://localhost:8080/api/clientes/
	public Clientes getClientes(@PathVariable("clienteId") int clienteId) {
		return clientesService.getClientes(clienteId);
	}

	// POST
	@PostMapping
	public Clientes addClientes(@RequestBody Clientes clientes) {
		return clientesService.addClientes(clientes);
	}

	// DELETE
	@DeleteMapping(path = "{clienteId}") // http://localhost:8080/api/clientes/
	public Clientes deleteClientes(@PathVariable("clienteId") int clienteId) {
		return clientesService.deleteClientes(clienteId);
	}
}// ClientesController
