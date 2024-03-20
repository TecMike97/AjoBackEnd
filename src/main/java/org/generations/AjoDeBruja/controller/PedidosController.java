package org.generations.AjoDeBruja.controller;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Pedidos;
import org.generations.AjoDeBruja.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/pedidos/") //http://localhost:8080/api/pedidos/
public class PedidosController {
	private final PedidosService pedidosService;// variable constante

	@Autowired
	public PedidosController(PedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}// constructor

	// GET
	@GetMapping
	public ArrayList<Pedidos> getPedidos() {
		return pedidosService.getAllPedidos();
	}

	// GET
	@GetMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/
	public Pedidos getPedidos(@PathVariable("pedId") int pedId) {
		return pedidosService.getPedidos(pedId);
	}

	// POST
	@PostMapping
	public Pedidos addPedidos(@RequestBody Pedidos pedidos) {
		return pedidosService.addPedidos(pedidos);
	}

	// DELETE
	@DeleteMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/
	public Pedidos deletePedidos(@PathVariable("pedId") int pedId) {
		return pedidosService.deletePedidos(pedId);
	}
}// PedidosController
