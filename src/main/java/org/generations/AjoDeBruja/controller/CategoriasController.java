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
	}//constructor
	
	//GET
	@GetMapping
	public List<Categorias> getAllCategorias() {
		return categoriasService.getAllCategorias();
	}//getAllCategorias

	// GET
	@GetMapping(path = "{id_categoria}") // http://localhost:8080/api/products/
	public Categorias getCategoria(@PathVariable("id_categoria") Long id_categoria) {
		return categoriasService.getCategoria(id_categoria);
	}//getCategoria

	@PostMapping
	public Categorias addCategoria(@RequestBody Categorias categoria) {
		return categoriasService.addCategoria(categoria);
	}//addCategoria

	// PUT
	@PutMapping(path = "{id_categoria}") // http://locolhost:8080/api/products/
	public Categorias updateCategoria(@PathVariable("id_categoria") Long id_categoria,
			@RequestBody Categorias categorias) {
		return categoriasService.updateCategoria(id_categoria, categorias.getNombre());
	}//updateCategoria
	
	// DELETE
	@DeleteMapping(path = "{id_categoria}")// http://locolhost:8080/api/products/1/
	public Categorias deleteCategorias(@PathVariable("id_categoria") Long id_categoria) {
		return categoriasService.deleteCategoria(id_categoria);
	}//deleteCategoria

}//CategoriasController
