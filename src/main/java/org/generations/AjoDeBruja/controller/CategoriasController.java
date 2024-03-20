package org.generations.AjoDeBruja.controller;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Categorias;
import org.generations.AjoDeBruja.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/categorias/") //http://localhost:8080/api/categorias/
public class CategoriasController {

	private final CategoriasService categoriasService;// variable constante

	@Autowired
	public CategoriasController(CategoriasService categoriasService) {
		this.categoriasService = categoriasService;
	}// constructor

	// GET
	@GetMapping
	public ArrayList<Categorias> getCategorias() {
		return categoriasService.getAllCategorias();
	}

	// GET
	@GetMapping(path = "{catId}") // http://localhost:8080/api/categorias/
	public Categorias getCategoria(@PathVariable("catId") int catId) {
		return categoriasService.getCategorias(catId);
	}

	// POST
	@PostMapping
	public Categorias addCategorias(@RequestBody Categorias categoria) {
		return categoriasService.addCategorias(categoria);
	}

	// DELETE
	@DeleteMapping(path = "{catId}") // http://localhost:8080/api/categorias/
	public Categorias deleteCategorias(@PathVariable("catId") int catId) {
		return categoriasService.deleteCategorias(catId);
	}

}// CategoriasController
