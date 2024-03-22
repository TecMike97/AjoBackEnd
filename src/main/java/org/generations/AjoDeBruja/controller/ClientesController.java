package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.model.Clientes;
import org.generations.AjoDeBruja.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/clientes/") // http://localhost:8080/api/clientes/
public class ClientesController {
	private final ClientesService clientesService;// variable constante

	@Autowired
	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}// constructor

	// GET
	@GetMapping(path = "{id_cliente}") // http://localhost:8080/api/clientes/1
	public List<Clientes> getProducts() {
		return clientesService.getAllClientes();
	}// getClientes

	@PostMapping
	public Clientes addClientes(@RequestBody Clientes clientes) {
		return clientesService.addClientes(clientes);
	}// addProduct

	// PUT
	// DELETE
	@DeleteMapping(path = "{id_cliente}") // http://localhost:8080/api/clientes/1
	public Clientes deleteClientes(@PathVariable("id_cliente") Long id_cliente) {
		return clientesService.deleteClientes(id_cliente);
	}// delete

	@PutMapping(path = "{id_cliente}") // http://locolhost:8080/ai/clientes/1
	public Clientes updateClientes(@PathVariable("id_cliente") Long id_cliente, @RequestBody Clientes clientes) {
		return clientesService.updateClientes(id_cliente, clientes.getNombre(), clientes.getApellido_pa(),
				clientes.getApellido_ma(), clientes.getEmail(), clientes.getTelefono());
	}// updateClientes
}// ClientesController
