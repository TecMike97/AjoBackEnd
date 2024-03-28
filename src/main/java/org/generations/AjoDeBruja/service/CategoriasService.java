package org.generations.AjoDeBruja.service;

import java.util.List;
import java.util.Optional;

import org.generations.AjoDeBruja.model.Categorias;
import org.generations.AjoDeBruja.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
	private final CategoriasRepository categoriasRepository;

	@Autowired
	public CategoriasService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository = categoriasRepository;
	}

	public List<Categorias> getAllCategorias() {
		return categoriasRepository.findAll();
	}// getAllCategorias

	public Categorias getCategorias(Long id_categoria) {
		return categoriasRepository.findById(id_categoria).orElseThrow(
				() -> new IllegalArgumentException("El producto con el id [" + id_categoria + "] no existe"));
	}// getCategorias

	public Categorias deleteCategorias(Long id_categoria) {
		Categorias tmpCat = null;
		if (categoriasRepository.existsById(id_categoria)) {
			tmpCat = categoriasRepository.findById(id_categoria).get();
			categoriasRepository.deleteById(id_categoria);
		} // if
		return tmpCat;
	}// deleteCategorias

	public Categorias addCategorias(Categorias categorias) {
		Optional<Categorias> tmpCat = categoriasRepository.findByName(categorias.getNombre());
		if (tmpCat.isEmpty()) {
			return categoriasRepository.save(categorias);
		} else {
			System.out.println("Ya existe la categoria con el nombre [" + categorias.getNombre() + "]");
			return null;
		} // if
	}// addCategorias

	public Categorias updateCategorias(Long id_categoria, String name) {
		Categorias categorias = null;
		if (categoriasRepository.existsById(id_categoria)) {
			categorias = categoriasRepository.findById(id_categoria).get();
			if (name.length() != 0)
				categorias.setNombre(name);
			categoriasRepository.save(categorias);
		} // exist
		return categorias;
	}
}
