package org.generations.AjoDeBruja.service;

import java.util.List;

import org.generations.AjoDeBruja.model.Pedidos;
import org.generations.AjoDeBruja.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	public final PedidosRepository pedidosRepository;
	@Autowired
	public PedidosService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}//constructor
	
	public List<Pedidos> getAllPedidos(){
		return pedidosRepository.findAll();
	}//getAllPedidos

	public Pedidos getPedido(Long pedId) {
		return pedidosRepository.findById(pedId).orElseThrow(
				()-> new IllegalArgumentException("El pedido con el id ["
						+ pedId + "] no existe.") //este mensaje es para nosotros en consola, no para el usuario
				);//orElseThrow es cuando te aparece un Optional
	}//getPedido

	public Pedidos addPedido(Pedidos pedido) {
	//	Pedidos tmpPed = null;
	//	if(pedidosRepository.findById(pedido.getId_pedido()).isEmpty()) {
	//		tmpPed = pedidosRepository.save(pedido);
	//	}else {
	//		System.out.println("Ya existe un pedido con el id ["+
	//				pedido.getId_pedido() + "]");
	//	}//if
		return pedidosRepository.save(pedido);
	}//addPedido

	public Pedidos deletePedido(Long pedId) {
		Pedidos pedido = null;
		if(pedidosRepository.existsById(pedId)) {
			pedido=pedidosRepository.findById(pedId).get();
			pedidosRepository.deleteById(pedId);
		}//if
		return pedido;
	}//deletePedido
	
	public Pedidos updatePedido(Long pedId, Long cantidad_productos, Double precio_total) {
		Pedidos pedido = null;
		if(pedidosRepository.existsById(pedId)) {
			pedido=pedidosRepository.findById(pedId).get();
			if(cantidad_productos.longValue()>0) pedido.setCantidad_productos(cantidad_productos);
			if(precio_total.doubleValue()>0) pedido.setPrecio_total(precio_total);
			pedidosRepository.save(pedido);
			}//if exist
		return pedido;
	}//updatePedido
}//class PedidosService
