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
	}//constructor

	public List<Categorias> getAllCategorias() {
		return categoriasRepository.findAll();
	}//getAllCategorias

	public Categorias getCategoria(Long id_categoria) {
		return categoriasRepository.findById(id_categoria).orElseThrow(
				() -> new IllegalArgumentException("La categoría con el id [" +
						id_categoria + "] no existe."));
	}//getCategoria
	
	public Categorias addCategoria(Categorias categoria) {
		Optional<Categorias> tmpCat = categoriasRepository.findByNombre(categoria.getNombre());
		if (tmpCat.isEmpty()) {
			return categoriasRepository.save(categoria);
		} else {
			System.out.println("Ya existe la categoria con el nombre [" +
					categoria.getNombre() + "]");
			return null;
		} // if
	}//addCategoria

	public Categorias deleteCategoria(Long id_categoria) {
		Categorias tmpCat = null;
		if (categoriasRepository.existsById(id_categoria)) {
			tmpCat = categoriasRepository.findById(id_categoria).get();
			categoriasRepository.deleteById(id_categoria);
		} // if
		return tmpCat;
	}//deleteCategoria

	public Categorias updateCategoria(Long id_categoria, String nombre) {
		Categorias categoria = null;
		if (categoriasRepository.existsById(id_categoria)) {
			categoria = categoriasRepository.findById(id_categoria).get();
			if (nombre.length() != 0)
				categoria.setNombre(nombre);
			categoriasRepository.save(categoria);
		} // exist
		return categoria;
	}//updateCategoria
}//class CategoriasService
