package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.model.Categorias;
import org.generations.AjoDeBruja.service.CategoriasService;
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
@RequestMapping(path = "/api/categorias/") // http://localhost:8080/api/categorias/
public class CategoriasController {

	private final CategoriasService categoriasService;

	@Autowired
	public CategoriasController(CategoriasService categoriasService) {
		this.categoriasService = categoriasService;
	}

	// GET
	@GetMapping(path = "{id_categoria}") // http://localhost:8080/api/products/1
	public List<Categorias> getCategorias() {
		return categoriasService.getAllCategorias();
	}// getProducts

	@PostMapping
	public Categorias addCategorias(@RequestBody Categorias categoria) {
		return categoriasService.addCategorias(categoria);
	}// addProduct

	// PUT
	// DELETE
	@DeleteMapping(path = "{id_categoria}") // http://localhost:8080/api/products/1
	public Categorias deleteCategorias(@PathVariable("id_categoria") Long id_categoria) {
		return categoriasService.deleteCategorias(id_categoria);
	}// delete

	@PutMapping(path = "{id_categoria}") // http://locolhost:8080/ai/products/1
	public Categorias updateCategorias(@PathVariable("id_categoria") Long id_producto, @RequestBody Categorias categorias) {
		return categoriasService.updateCategorias(id_producto, categorias.getNombre());
	}// updateProduct
}
// updateProduct
