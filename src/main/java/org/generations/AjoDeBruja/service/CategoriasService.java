package org.generations.AjoDeBruja.service;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Categorias;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
	public final ArrayList<Categorias> list = new ArrayList<Categorias>();

	public CategoriasService() {
		list.add(new Categorias("Comestibles"));
		list.add(new Categorias("Cuidado Personal"));
		list.add(new Categorias("Suplementos"));
		list.add(new Categorias("Veganos"));
	}// constructor

	public ArrayList<Categorias> getAllCategorias() {
		return list;
	}

	public Categorias getCategorias(int catId) {
		Categorias tmpProd = null;
		for (Categorias categoria : list) {
			if (categoria.getId_categoria() == catId)
				tmpProd = categoria;
			break;
		} // forEach
		return tmpProd;
	}

	public Categorias addCategorias(Categorias categoria) {
		Categorias tmpProd = null;
		if (list.add(categoria)) {
			tmpProd = categoria;
		} // if
		return tmpProd;
	}

	public Categorias deleteCategorias(int catId) {
		Categorias tmpProd = null;
		for (Categorias categoria : list) {
			if (categoria.getId_categoria() == catId) {
				tmpProd = categoria;
				list.remove(categoria);
				break;
			} // if ==
		} // forEach
		return tmpProd;
	}
}
