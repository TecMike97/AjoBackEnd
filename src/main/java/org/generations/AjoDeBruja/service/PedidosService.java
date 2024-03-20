package org.generations.AjoDeBruja.service;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Pedidos;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	public final ArrayList<Pedidos> list = new ArrayList<Pedidos>();

	public PedidosService() {
		list.add(new Pedidos(4, 450.00));
		list.add(new Pedidos(3, 360.00));
		list.add(new Pedidos(5, 820.00));
		list.add(new Pedidos(2, 480.00));
	}// constructor

	public ArrayList<Pedidos> getAllPedidos() {
		return list;
	}

	public Pedidos getPedidos(int pedId) {
		Pedidos tmpProd = null;
		for (Pedidos pedido : list) {
			if (pedido.getId_pedido() == pedId)
				tmpProd = pedido;
			break;
		} // forEach
		return tmpProd;
	}

	public Pedidos addPedidos(Pedidos pedido) {
		Pedidos tmpProd = null;
		if (list.add(pedido)) {
			tmpProd = pedido;
		} // if
		return tmpProd;
	}

	public Pedidos deletePedidos(int pedId) {
		Pedidos tmpProd = null;
		for (Pedidos product : list) {
			if (product.getId_pedido() == pedId) {
				tmpProd = product;
				list.remove(product);// borrar el producto de la lista
				break;
			} // if ==
		} // forEach
		return tmpProd;
	}
}
