package org.generations.AjoDeBruja.service;

import java.util.List;
import java.util.Optional;

import org.generations.AjoDeBruja.dto.CambioContrasena;
import org.generations.AjoDeBruja.model.Usuarios;
import org.generations.AjoDeBruja.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
	private final UsuariosRepository usuariosRepository;

	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}// constructor

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAll();
	}// getAllUsuarios

	public Usuarios getUsuario(Long usuarioId) {
		return usuariosRepository.findById(usuarioId)
				.orElseThrow(() -> new IllegalArgumentException("El usuario con el id [" + usuarioId + "] no existe.") // este mensaje es para nosotros en la consola, no para el usuario
				);// orElseThrow es cuando te aparece un Optional
	}// getUsuario

	public Usuarios addUsuario(Usuarios usuario) {
		Usuarios tmpUser = null;
		if (usuariosRepository.findByEmail(usuario.getEmail()).isEmpty()) {
			usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
			tmpUser = usuariosRepository.save(usuario);
		} else {
			System.out.println("Ya existe un usuario con el email [" + usuario.getEmail() + "]");
		} // if
		return tmpUser;
	}// addUsuario

	public Usuarios deleteUsuario(Long usuarioId) {
		Usuarios user = null;
		if (usuariosRepository.existsById(usuarioId)) {
			user = usuariosRepository.findById(usuarioId).get();
			usuariosRepository.deleteById(usuarioId);
		} // if
		return user;
	}// deleteUsuario

	public Usuarios updateUsuario(Long id, CambioContrasena cambioContrasena) {
		Usuarios tmpUser = null;
		if (usuariosRepository.existsById(id)) {
			tmpUser = usuariosRepository.findById(id).get();
			//if (tmpUser.getContrasena().equals(cambioContrasena.getContrasena())) {
			if(passwordEncoder.matches(cambioContrasena.getContrasena(), tmpUser.getContrasena())) {
				tmpUser.setContrasena(passwordEncoder.encode(cambioContrasena.getNcontrasena()));
				usuariosRepository.save(tmpUser);
			} else {
				System.out.println("updateUsuario - La contraseña del usuario [" + tmpUser.getId() + "] no coincide");
				tmpUser = null;
			} // if equals
		} // if existById
		return tmpUser;

	}// updateUsuario

	public boolean validateUser(Usuarios usuario) {
		Optional<Usuarios> userByEmail = usuariosRepository.findByEmail(usuario.getEmail());
		if (userByEmail.isPresent()) {
			Usuarios tmpUser = userByEmail.get();
			// if(usuario.getContrasena().equals(tmpUser.getContrasena())) {
			if (passwordEncoder.matches(usuario.getContrasena(), tmpUser.getContrasena())) {// valida si la cifrada
				return true;
			} // if equals
		} // if isPresent
		return false;
	}// validateUser
}// class UsuariosService
