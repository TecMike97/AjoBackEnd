package org.generations.AjoDeBruja.controller;

import javax.servlet.ServletException;

import org.generations.AjoDeBruja.config.JwtFilter;
import org.generations.AjoDeBruja.dto.Token;
import org.generations.AjoDeBruja.model.Usuarios;
import org.generations.AjoDeBruja.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuariosService usuariosService;
	@Autowired
	public LoginController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}
	@PostMapping
	public Token loginUser(@RequestBody Usuarios usuario) throws ServletException {
		if (usuariosService.validateUser(usuario)) {
			System.out.println("Usuario valido " + usuario.getEmail());
			return new Token(generateToken(usuario.getEmail()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos " + usuario.getEmail());
	}//loginUser
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
}//class LoginController
