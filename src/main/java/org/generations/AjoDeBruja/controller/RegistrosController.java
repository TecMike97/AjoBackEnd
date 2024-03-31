package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.model.Registros;
import org.generations.AjoDeBruja.service.RegistrosService;
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
@RequestMapping(path="/api/registros/") //http://localhost:8080/api/registros/
public class RegistrosController {
	private final RegistrosService registrosService;// variable constante

	@Autowired
	public RegistrosController(RegistrosService registrosService) {
		this.registrosService = registrosService;
	}// constructor

	// GET
	@GetMapping
	public List<Registros> getAllRegistros() {
		return registrosService.getAllRegistros();
	}//getAllRegistros

	//GET
	@GetMapping(path = "{regId}") // http://localhost:8080/api/registros/
	public Registros getRegistro(@PathVariable("regId") Long regId) {
		return registrosService.getRegistro(regId);
	}//getRegistro

	//POST
	@PostMapping
	public Registros addRegistro(@RequestBody Registros registro) {
		return registrosService.addRegistro(registro);
	}//addRegistro

	//DELETE
	@DeleteMapping(path = "{regId}") // http://localhost:8080/api/registros/
	public Registros deleteRegistro(@PathVariable("regId") Long regId) {
		return registrosService.deleteRegistro(regId);
	}//deleteRegistro
	
	//PUT
	@PutMapping(path = "{regId}") // http://localhost:8080/api/registros/{regId}
	public Registros updateRegistro(@PathVariable("regId") Long regId, @RequestBody Registros nuevosDatosRegistro) {
	    return registrosService.updateRegistro(regId, nuevosDatosRegistro.getNombre_completo(), 
	                       		nuevosDatosRegistro.getTelefono(), nuevosDatosRegistro.getEmail(),
	                            nuevosDatosRegistro.getContraseña());
	}//updateRegistro
}//RegistrosController
