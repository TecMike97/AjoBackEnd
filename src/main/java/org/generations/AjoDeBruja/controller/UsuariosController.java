package org.generations.AjoDeBruja.controller;

import java.util.List;

import org.generations.AjoDeBruja.dto.CambioContrasena;
import org.generations.AjoDeBruja.model.Usuarios;
import org.generations.AjoDeBruja.service.UsuariosService;
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
@RequestMapping(path="api/users/")//http://localhost:8080/api/users/
public class UsuariosController {
	private final UsuariosService usuariosService;
	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	@GetMapping
	public List<Usuarios> getAllUsuarios(){
		return usuariosService.getAllUsuarios();
	}//getAllUsuarios
	
	@GetMapping(path="{usuarioId}")
	public Usuarios getUsuario(@PathVariable("usuarioId") Long id) {
		return usuariosService.getUsuario(id);
	}//getUsuario
	
	@DeleteMapping(path="{usuarioId}")
	public Usuarios deleteUsuario(@PathVariable("usuarioId") Long id) {
		return usuariosService.deleteUsuario(id);
	}//deleteUsuario
	
	@PostMapping
	public Usuarios addUsuario(@RequestBody Usuarios usuarios) {
		return usuariosService.addUsuario(usuarios);
	}//addUsuario
	
	@PutMapping(path="{usuarioId}")
	public Usuarios updateUsuario(@PathVariable("usuarioId") Long id,
			@RequestBody CambioContrasena cambioContrasena) {
		return usuariosService.updateUsuario(id, cambioContrasena);
	}//updateUsuario
	
}//class UsuariosController
