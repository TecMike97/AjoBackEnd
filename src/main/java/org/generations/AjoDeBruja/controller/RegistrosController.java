package org.generations.AjoDeBruja.controller;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Registros;
import org.generations.AjoDeBruja.service.RegistrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/registros/") //http://localhost:8080/api/registros/
public class RegistrosController {
	private final RegistrosService registrosService;// variable constante

	@Autowired
	public RegistrosController(RegistrosService registrosService) {
		this.registrosService = registrosService;
	}// constructor

	// GET
	@GetMapping
	public ArrayList<Registros> getRegistros() {
		return registrosService.getAllRegistros();
	}

	// GET
	@GetMapping(path = "{regId}") // http://localhost:8080/api/registros/
	public Registros getRegistros(@PathVariable("regId") int regId) {
		return registrosService.getRegistros(regId);
	}

	// POST
	@PostMapping
	public Registros addRegistros(@RequestBody Registros registros) {
		return registrosService.addRegistros(registros);
	}

	// DELETE
	@DeleteMapping(path = "{regId}") // http://localhost:8080/api/registros/
	public Registros deleteRegistros(@PathVariable("regId") int regId) {
		return registrosService.deleteRegistros(regId);
	}
}// RegistrosController
