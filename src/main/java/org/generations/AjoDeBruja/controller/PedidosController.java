package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.model.Pedidos;
import org.generations.AjoDeBruja.service.PedidosService;
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
@RequestMapping(path="/api/pedidos/") //http://localhost:8080/api/pedidos/
public class PedidosController {
	private final PedidosService pedidosService;// variable constante

	@Autowired
	public PedidosController(PedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}// constructor

	// GET
	@GetMapping
	public List<Pedidos> getAllPedidos() {
		return pedidosService.getAllPedidos();
	}//getAllPedidos

	// GET
	@GetMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/
	public Pedidos getPedido(@PathVariable("pedId") Long pedId) {
		return pedidosService.getPedido(pedId);
	}//getPedido

	// POST
	@PostMapping
	public Pedidos addPedido(@RequestBody Pedidos pedido) {
		return pedidosService.addPedido(pedido);
	}//addPedido

	// DELETE
	@DeleteMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/
	public Pedidos deletePedido(@PathVariable("pedId") Long pedId) {
		return pedidosService.deletePedido(pedId);
	}//deletePedido
	
	//PUT
	@PutMapping(path="{pedId}")
	public Pedidos updatePedido(@PathVariable("pedId") Long pedId,
			@RequestBody Pedidos pedido){
				return pedidosService.updatePedido(pedId, pedido.getCantidad_productos(),
						pedido.getPrecio_total());
			}//updatePedido
}// PedidosController
