package org.generations.AjoDeBruja.service;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Clientes;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {
	public final ArrayList<Clientes> list = new ArrayList<Clientes>();

	public ClientesService() {
		list.add(new Clientes("José", "López", "Rodríguez", "joselo_01@gmail.com", "5545990810"));
		list.add(new Clientes("Enrique", "Becerril", "Navarrete", "becerriln.enrique@gmail.com", "5564602346"));
		list.add(new Clientes("Joel Francisco", "Gómez", "Castro", "joelfcogomezc@gmail.com", "5530499196"));
		list.add(new Clientes("Glenda", "Valentín", "Robles", "glendavalentin25@gmail.com", "5573261445"));
	}// constructor

	public ArrayList<Clientes> getAllClientes() {
		return list;
	}

	public Clientes getClientes(int clienteId) {
		Clientes tmpProd = null;
		for (Clientes cliente : list) {
			if (cliente.getId_cliente() == clienteId)
				tmpProd = cliente;
			break;
		} // forEach
		return tmpProd;
	}

	public Clientes addClientes(Clientes cliente) {
		Clientes tmpProd = null;
		if (list.add(cliente)) {
			tmpProd = cliente;
		} // if
		return tmpProd;
	}

	public Clientes deleteClientes(int clienteId) {
		Clientes tmpProd = null;
		for (Clientes cliente : list) {
			if (cliente.getId_cliente() == clienteId) {
				tmpProd = cliente;
				list.remove(cliente);// borrar el producto de la lista
				break;
			} // if ==
		} // forEach
		return tmpProd;
	}
}
